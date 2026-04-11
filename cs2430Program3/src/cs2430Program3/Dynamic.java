package cs2430Program3;

import java.util.ArrayList;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 * 
 * Solution to the knapsack problem designed to be more efficient than
 * brute force, but almost as good. Uses the ideas of Dynamic Programming
 * to create a table and gradually add experiments to the table, keeping track
 * of the best ones.
 * Note that currently this is probably worse than brute force, since this operates in
 * experiments * maxWeight = 12*700 = 8400 operations, over double that for brute force.
 */
public class Dynamic {
    /**
     * Entry method for the DP solution.
     * Tries to find the best combination of
     * experiments in O(experiment * maxWeight) space & time.
     * @param experiments Array of experiments to potentially include
     * @param maxWeight The maximum weight of the payload
     * @return a Payload of the highest-rated experiments it could find
     */
    public static Payload calculate(Experiment[] experiments, int maxWeight) {
        // Create a DP table to track the best score for each weight, incrementally
        // adding in new experiments as you go.
        // Each row is a new experiment, and each column is a new weight.
        int[][] table = new int[experiments.length][maxWeight+1];
        // note: it makes maxWeight+1 columns because column 0 corresponds to 0kg

        // call addExperiment on each row
        for(int i=0; i<experiments.length; i++) {
            Experiment currentExperiment = experiments[i];
            addExperiment(table, i, currentExperiment);
        }
        
        // It's not clear what experiments ended up being useful until the table is
        // complete, so we trace back through the table seeing what experiments got
        // used to determine what to return.
        ArrayList<Experiment> usedExperiments = traceExperiments(table, experiments);
        return new Payload(usedExperiments);
    }

    /**
     * Adds values to a row in the table. Each row corresponds to
     * an experiment, so this method adds an experiment to the table using
     * the values from the previous row.
     * @param table DP table of experiments/weights/ratings
     * @param row row of the experiment to calculate
     * @param experiment corresponding Experiment object, to use its weight/rating
     */
    private static void addExperiment(int[][] table, int row, Experiment experiment) {
        // This is the crux of the DP algorithm.
        //
        // For every weight, if the experiment is light enough to be considered, consider
        // the rating from the previous experiments at currentWeight-experimentWeight. If
        // using the current experiment would yield a better rating what we have for the
        // previous experiments (at the current weight), then use it instead. 
        for(int weight=0; weight<table[0].length; weight++) {

            // edge case: if the current experiment is too heavy for the current weight, then
            // just default to what we had for the previous experiments for the current weight
            if(experiment.getWeight() > weight) {
                table[row][weight] = getAbove(table, row, weight);
                continue;
            }

            // subtract the current experiment's weight. How well did previous experiments
            // do for that weight? If it wasn't very good, we might be able to add this experiment
            // to it for the current weight to get a better rating
            int prevScoreBack = getAbove(table, row, weight - experiment.getWeight());

            // how well would we do combining the current experiment with prevScoreBack?
            int candidateScore = prevScoreBack + experiment.getRating();

            // how well did the previous experiments do for the current weight?
            int prevScoreAbove = getAbove(table, row, weight);

            // set the current weight's rating to be whichever one was better
            table[row][weight] = Integer.max(candidateScore, prevScoreAbove);
        }
    }

    /**
     * Starting at the end of the table, work backwards to figure
     * out what experiments were used to set that rating/weight combo.
     * @param table DP table of experiments/weights/ratings
     * @param experiments experiments for each row in the table
     * @return the experiments that were used to make best rating in table
     */
    private static ArrayList<Experiment> traceExperiments(int[][] table, Experiment[] experiments) {
        ArrayList<Experiment> output = new ArrayList<Experiment>();

        // Overall structure:
        // 1. start at bottom right of table
        // 2. go left until you see a change. if 0, quit (done!)
        // 3. go up until you see the experiment that made that change. include it
        // 4. repeat from 2.

        int row = table.length-1;
        int col = table[0].length-1;
        while(true) {
            int cell = table[row][col];
            int leftCell = table[row][col-1];

            // base case: if cell is 0, we've run out of
            // experiments to add, so quit
            if(cell == 0) break;

            // we only care if leftCell is different
            if(cell == leftCell) {
                cell = table[row][--col];
                continue;
            }

            // at this point, cell != leftCell
            // go up until cell != the above cell
            if(row != 0) {
                while(table[row][col] == table[row-1][col]) {
                    row--;
                    if(row == 0) break;
                }
            }

            // at this point, cell is different from the one above it.
            // this means that on this row, one of the final experiments was added.

            Experiment currentExperiment = experiments[row];
            output.add(experiments[row]);

            // Success! we have the experiment that was used, now set the
            // current cell to be the one currentExperiment was added onto
            row -= 1;
            col -= currentExperiment.getWeight();

            // edge case: don't loop if this is the very first row
            if(row == -1) break;
            // note that, since the entire left column is 0's (0kg), we don't need
            // a dedicated edge case for boundary on the left side, because the
            // above base case takes care of that.
        }

        return output;
    }

    /**
     * Helper method to safely get the above cell, or return 0 if out of bounds
     * @param table table to undex into
     * @param row row of cell to look above
     * @param col column of cell to index into
     * @return the value of the cell above the current one (or 0)
     */
    private static int getAbove(int[][] table, int row, int col) {
        if(row == 0)
            return 0;
        return table[row-1][col];
    }

    /**
     * Helper method to diagnose issues with the DP table.
     * Not necessary for end product.
     * 
     * Prints the table of integers
     * @param table table of integers to be printed.
     */
    @SuppressWarnings("unused")
    private static void printTable(int[][] table) {
        for(int[] row : table) {
            System.out.printf("\n[ ");
            for(int cell : row) {
                System.out.printf("%d\t", cell);
            }
            System.out.printf("]");
        }
        System.out.println("\n");
    }
}
