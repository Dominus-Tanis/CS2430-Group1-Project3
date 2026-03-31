package cs2430Program3;

import java.util.ArrayList;

public class Dynamic {
    public static Payload calculate(Experiment[] experiments, int maxWeight) {
        int[][] table = new int[experiments.length][maxWeight];
        table[0][0] = 0;

        for(int i=0; i<experiments.length; i++) {
            Experiment currentExperiment = experiments[i];
            addExperiment(table, i, currentExperiment);
        }
        
        ArrayList<Experiment> usedExperiments = traceExperiments(table, experiments);
        
        return new Payload(usedExperiments);
    }

    private static ArrayList<Experiment> traceExperiments(int[][] table, Experiment[] experiments) {
        ArrayList<Experiment> output = new ArrayList<Experiment>();

        for(int row=table.length - 1; row >=0; row--) {
            // if item is bigger than one above it, output.add(experiments[row])
        }

    }

    private static void addExperiment(int[][] table, int row, Experiment experiment) {
        for(int weight=0; weight<table.length; weight++) {
            int prevWeightBack = getPrevWeight(table, row, weight, experiment.getWeight());
            int candidateWeight = prevWeightBack + experiment.getWeight();
            int prevWeightAbove = above(table, row, weight);
            table[row][weight] = Integer.max(candidateWeight, prevWeightAbove);
        }
    }

    private static int getPrevWeight(int[][] table, int row, int col, int weight) {
        if(row == 0)
            return 0;

        if(weight >= col)
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
