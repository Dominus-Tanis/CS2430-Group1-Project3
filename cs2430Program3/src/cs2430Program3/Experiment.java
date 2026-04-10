package cs2430Program3;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 *
 * The Experiment class is used to create Experiment objects and track their
 * name, weight, rating, and score.
 *
 * @author Cory
 */
public class Experiment {

	private String name;
	private int weight;
	private int rating;
	private double score;

	/**
	 * Constructs an Experiment object using an input name, weight, and rating.
	 * Score is calculated by dividing rating by weight.
	 * 
	 * @param name   Name of the experiment.
	 * @param weight Weight of the experiment.
	 * @param rating Rating of the experiment.
	 */
	public Experiment(String name, int weight, int rating) {
		this.name = name;
		this.weight = weight;
		this.rating = rating;
		this.score = (double) rating / weight;
	}

	/**
	 * A simple getter method to retrieve the name of an Experiment object.
	 * 
	 * @return Experiment name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A simple getter method to retrieve the weight of an Experiment object.
	 * 
	 * @return Experiment weight.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * A simple getter method to retrieve the rating of an Experiment object.
	 * 
	 * @return Experiment rating.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * A simple getter method to retrieve the score of an Experiment object. Score
	 * is calculated by dividing rating by weight on Experiment object creation.
	 * 
	 * @return Experiment score.
	 */
	public double getScore() {
		return score;
	}
}
