package cs2430Program3;

/**
 * Group 1 Cory Neilsen, Spencer Peck, Benjamin Shaw, Dallin Yauney CS 2430-002
 * Project 3: Optimal Selection – Spring 2026
 *
 * The BruteForce class contains methods to determine the three highest-rated
 * valid Payloads (weight less than or equal to 700).
 *
 * Bit manipulation method to generate all subsets adapted from:
 * https://www.geeksforgeeks.org/dsa/backtracking-to-find-all-subsets/
 *
 * @author Cory Neilsen
 */
public class BruteForce {

    /**
     * Generates all possible Payloads of Experiments and outputs the three
     * highest-rated valid Payloads (weight less than or equal to 700)
     *
     * @param arr Input array of experiments.
     * @return Array containing the top three payloads. Best at index 0, worst
     * at index 2.
     */
    public static Payload[] bruteForce(Experiment[] arr) {
        int n = arr.length;
        Payload[] topThree = new Payload[3];

        // Loop through all possible subsets.
        for (int i = 0; i < (1 << n); i++) {
            Payload subset = new Payload();

            // Loop through all elements of the input array.
            for (int j = 0; j < n; j++) {

                // Check if the jth bit is set
                if ((i & (1 << j)) != 0) {
                    subset.addExperiment(arr[j]);
                }
            }

            // Check that subset is below the weight threshold.
            if (subset.getWeight() <= 700) {

                // If null value in first place, set all indices of topThree to subset.
                if (topThree[0] == null) {
                    topThree[0] = subset;
                    topThree[1] = subset;
                    topThree[2] = subset;
                } else {

                    // Compare rating of subset to third place payload.
                    if (subset.getRating() > topThree[2].getRating()) {
                        topThree[2] = subset;

                        // Compare rating of subset to second place payload. 
                        if (subset.getRating() > topThree[1].getRating()) {
                            topThree[2] = topThree[1];
                            topThree[1] = subset;

                            // Compare rating of subset to first place payload.
                            if (subset.getRating() > topThree[0].getRating()) {
                                topThree[1] = topThree[0];
                                topThree[0] = subset;
                            }
                        }
                    }
                }
            }
        }

        return topThree;
    }

}
