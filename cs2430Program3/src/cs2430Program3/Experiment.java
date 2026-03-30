package cs2430program3;

/**
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
