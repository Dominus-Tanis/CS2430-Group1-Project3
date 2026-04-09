package cs2430Program3;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 *
 * @author Cory
 */
public class Experiment {

    private String name;
    private int weight;
    private int rating;
    private double score;

    public Experiment(String name, int weight, int rating) {
        this.name = name;
        this.weight = weight;
        this.rating = rating;
        this.score = (double) rating / weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getRating() {
        return rating;
    }

    public double getScore() {
        return score;
    }
}
