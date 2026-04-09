package cs2430Program3;

import java.util.ArrayList;
import java.util.List;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 *
 * @author Cory
 */
public class Payload {

    private List<Experiment> experiments;
    private int weight;
    private int rating;

    public Payload() {
        experiments = new ArrayList<>();
    }
    
    public Payload(List<Experiment> externalExperimentList) {
        experiments = new ArrayList<>();
        for(Experiment experiment : externalExperimentList) {
            experiments.add(experiment);
            weight += experiment.getWeight();
            rating += experiment.getRating();
        }
    }
    
    public String experimentList() {
        String experimentList = "";
        for (Experiment experiment : experiments) {
            if (experimentList.isEmpty()){
                experimentList += experiment.getName();
            } else {
                experimentList += ", " + experiment.getName();
            }
        }
        return "Experiments: " + experimentList;
    }

    public int getWeight() {
        return weight;
    }

    public int getRating() {
        return rating;
    }

    public void addExperiment(Experiment experiment) {
        experiments.add(experiment);
        weight += experiment.getWeight();
        rating += experiment.getRating();
    }
}
