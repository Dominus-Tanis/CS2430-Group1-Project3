package cs2430Program3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * GreedyStrategies has six methods.  3 of them are publicly available
 * for you to get the highest rated, lightest, and highest rated to weight
 * Payloads.  The other 3 classes are helper methods to help you with
 * getting those by returning the rated, lightest, and highest rated to
 * weight experiments.
 * 
 * @author Benjamin Shaw
 */
public class GreedyStrategies {

	/**
	 * highestRatingFirst creates the highest rated Payload by implementing
	 * the highestRatingExperiment method to get the highest rated experiment
	 * and add it to the Payload to then return the Payload and have it be
	 * less than 700 weight
	 * 
	 * 
	 * @param experiments
	 * @return the highest rated Payload
	 */
	public Payload highestRatingFirst(Experiment[] experiments) {
		ArrayList<Experiment> experimentsList = new ArrayList<Experiment>(Arrays.asList(experiments));
		Payload output = new Payload();
		while (output.getWeight() + highestRatingExperiment(experimentsList).getWeight() < 700) {
			output.addExperiment(highestRatingExperiment(experimentsList));
			experimentsList.remove(highestRatingExperiment(experimentsList));
		}
		return output;
	}
	
	
	
	/**
	 * highestRatingExperiment returns the highest rated experiment by
	 * getting the element by comparison and get the index to then return
	 * the highest rated experiment by getting it by the index
	 * 
	 * @param experiments
	 * @return highest rated experiment
	 */
	private Experiment highestRatingExperiment(ArrayList<Experiment> experiments) {
		int highestRatingIndex = 0;
		int highestRating = 0;
		for (Experiment experiment : experiments) {
			if (highestRating < experiment.getRating()) {
				highestRating = experiment.getRating();
				highestRatingIndex = experiments.indexOf(experiment);
			}
		}
		return experiments.get(highestRatingIndex);
	}
	

	
	/**
	 * lightestFirst creates a Payload that has all the lightest experiments
	 * by implementing the lightestExperiment method to get the lightest 
	 * experiment and add it to the Payload to then return the Payload and
	 * have it be less than 700 weight
	 * 
	 * @param experiments
	 * @return most dense Payload
	 */
	public Payload lightestFirst(Experiment[] experiments) {
		ArrayList<Experiment> experimentsList = new ArrayList<Experiment>(Arrays.asList(experiments));
		Payload output = new Payload();
		while (output.getWeight() + lightestExperiment(experimentsList).getWeight() < 700) {
			output.addExperiment(lightestExperiment(experimentsList));
			experimentsList.remove(lightestExperiment(experimentsList));
		}
		return output;
	}

	
	
	/**
	 * lightestExperiment returns the lightest experiment by getting the 
	 * element by comparison and get the index to then return the lightest
	 * experiment by getting it by the index
	 * 
	 * @param experiments
	 * @return
	 */
	private Experiment lightestExperiment(ArrayList<Experiment> experiments) {
		int lightestIndex = 0;
		int lightest = 0;
		for (Experiment experiment : experiments) {
			if (lightest > experiment.getWeight()) {
				lightest = experiment.getWeight();
				lightestIndex = experiments.indexOf(experiment);
			}
		}
		return experiments.get(lightestIndex);
	}
	
	
	
	/**
	 * bestRatingToWeightFirst creates the best rating to weight ratio Payload
	 * by implementing the bestRatingToWeightExperiment method to get the highest
	 * rated to weight experiment and add it to the Payload to then return the
	 * Payload and have it be less than 700 weight
	 * 
	 * @param experiments
	 * @return best rating to weight ratio Payload
	 */
	public Payload bestRatingToWeightFirst(Experiment[] experiments) {
		ArrayList<Experiment> experimentsList = new ArrayList<Experiment>(Arrays.asList(experiments));
		Payload output = new Payload();
		while (output.getWeight() + bestRatingToWeightExperiment(experimentsList).getWeight() < 700) {
			output.addExperiment(bestRatingToWeightExperiment(experimentsList));
			experimentsList.remove(bestRatingToWeightExperiment(experimentsList));
		}
		return output;
	}

	
	
	/**
	 * bestRatingToWeightExperiment returns the highest rating to weight
	 * experiment by getting the element by comparison and get the index to
	 *  then return the lightest experiment by getting it by the index
	 * 
	 * @param experiments
	 * @return highest rating to weight experiment
	 */
	private Experiment bestRatingToWeightExperiment(ArrayList<Experiment> experiments) {
		int bestRatingToWeightIndex = 0;
		int bestRatingToWeight = 0;
		for (Experiment experiment : experiments) {
			if (bestRatingToWeight < experiment.getRating() / experiment.getWeight()) {
				bestRatingToWeight = experiment.getRating() / experiment.getWeight();
				bestRatingToWeightIndex = experiments.indexOf(experiment);
			}
		}
		return experiments.get(bestRatingToWeightIndex);
	}
}
