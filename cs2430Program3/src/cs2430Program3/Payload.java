package cs2430Program3;

import java.util.ArrayList;
import java.util.List;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 *
 * The Payload class provides functionality for a Payload object, which is a
 * collection of Experiment objects that also tracks the combined weight and
 * rating of all Experiments contained.
 *
 * @author Cory
 */
public class Payload {

	private List<Experiment> experiments;
	private int weight;
	private int rating;

	/**
	 * Construct an empty Payload to add Experiments to.
	 */
	public Payload() {
		experiments = new ArrayList<>();
	}

	/**
	 * Constructor to build a Payload using an input list of experiments.
	 * 
	 * @param externalExperimentList A list of Experiment objects used to build the
	 *                               Payload.
	 */
	public Payload(List<Experiment> externalExperimentList) {
		experiments = new ArrayList<>();
		for (Experiment experiment : externalExperimentList) {
			experiments.add(experiment);
			weight += experiment.getWeight();
			rating += experiment.getRating();
		}
	}

	/**
	 * Get the names of all Experiments in the Payload.
	 * 
	 * @return A String output of the names of all Experiments contained within the
	 *         Payload.
	 */
	public String experimentList() {
		String experimentList = "";
		for (Experiment experiment : experiments) {
			if (experimentList.isEmpty()) {
				experimentList += experiment.getName();
			} else {
				experimentList += ", " + experiment.getName();
			}
		}
		return "Experiments: " + experimentList;
	}

	/**
	 * Get the combined weight of Experiments in the Payload.
	 * 
	 * @return An int value of the total weight of the Payload.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Get the combined rating of Experiments in the Payload.
	 * 
	 * @return An int value of the total rating of the Payload.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Add an Experiment to the Payload.
	 * 
	 * @param experiment Experiment object to be added to the Payload.
	 */
	public void addExperiment(Experiment experiment) {
		experiments.add(experiment);
		weight += experiment.getWeight();
		rating += experiment.getRating();
	}
}
