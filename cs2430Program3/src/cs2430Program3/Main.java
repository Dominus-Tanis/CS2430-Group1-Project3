package cs2430Program3;

public class Main {
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

        // DELETEME - Proof of concept for DP solution
        Payload result = Dynamic.calculate(experiments, 700);

        System.out.println(result.experimentList());
        System.out.println(result.getWeight());
        System.out.println(result.getRating());
    }
}
