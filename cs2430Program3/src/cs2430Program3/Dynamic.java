package cs2430Program3;

import java.util.ArrayList;

public class Dynamic {
    public static void main(String[] args) {
		 Experiment[] experiments = {
             new Experiment("Cloud Patterns",            36,  5),
             new Experiment("Solar Flares",              264, 9),
             new Experiment("Solar Power",               188, 6),
             new Experiment("Binary Stars",              203, 8),
             new Experiment("Relativity",                104, 8),
             new Experiment("Seed Viability",            7,   4),
             new Experiment("Sun Spots",                 90,  2),
             new Experiment("Mice Tumors",               65,  8),
             new Experiment("Microgravity Plant Growth", 75,  5),
             new Experiment("Micrometeorites",           170, 9),
             new Experiment("Cosmic Rays",               80,  7),
             new Experiment("Yeast Fermentation",        27,  4),
         };
         Payload result = calculate(experiments, 700);

    //    Experiment[] experiments = {
    //        new Experiment("Sheet", 3, 4),
    //        new Experiment("Box",   6, 5),
    //        new Experiment("Bag",   5, 5),
    //        new Experiment("Spec",  1, 1),
    //    };
    //    Payload result = calculate(experiments, 10);
        
        
        System.out.println(result.experimentList());
        System.out.println(result.getWeight());
        System.out.println(result.getRating());
    }

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

    public static Payload calculate(Experiment[] experiments, int maxWeight) {
        int[][] table = new int[experiments.length][maxWeight+1];

        for(int i=0; i<experiments.length; i++) {
            Experiment currentExperiment = experiments[i];
            addExperiment(table, i, currentExperiment);
        }
        
        ArrayList<Experiment> usedExperiments = traceExperiments(table, experiments);
        printTable(table);
        
        return new Payload(usedExperiments);
    }

    private static ArrayList<Experiment> traceExperiments(int[][] table, Experiment[] experiments) {
        ArrayList<Experiment> output = new ArrayList<Experiment>();

        // 1. start at bottom right
        // 2. go left until you see a change. if 0, quit
        // 3. go up until you see the thing that made that change. include it
        // 4. goto 2.

        int row = table.length-1;
        int col = table[0].length-1;
        while(true) {
            int cell = table[row][col];
            int leftCell = table[row][col-1];

            if(cell == 0) break;

            if(cell == leftCell) {
                cell = table[row][--col];
                continue;
            }

            // at this point, cell != leftCell
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

            row -= 1;
            col -= currentExperiment.getWeight();
            if(row == -1) break;

        }

        return output;
    }

    private static void addExperiment(int[][] table, int row, Experiment experiment) {
        for(int weight=0; weight<table[0].length; weight++) {
            if(experiment.getWeight() > weight) {
                table[row][weight] = above(table, row, weight);
                continue;
            }
            int prevScoreBack = getPrevScore(table, row, weight, experiment.getWeight());
            int candidateScore = prevScoreBack + experiment.getRating();
            int prevScoreAbove = above(table, row, weight);
            table[row][weight] = Integer.max(candidateScore, prevScoreAbove);
        }
    }

    private static int getPrevScore(int[][] table, int row, int col, int weight) {
        if(row == 0)
            return 0;

        if(weight > col)
            return 0;

        return table[row-1][col - weight];
    }

    private static int above(int[][] table, int row, int col) {
        if(row == 0)
            return 0;
        return table[row-1][col];
    }

    private static int left(int[][] table, int row, int col, int weight) {
        if(weight >= col)
            return 0;
        return table[row][col - weight];
    }
}
