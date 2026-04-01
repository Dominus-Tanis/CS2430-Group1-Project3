package cs2430Program3;
/**
 * 
 * @author Spencer J Peck
 * @author
 * @author
 * @author
 */
public class Main {

	public static void main(String[] args) {
		Experiment[] experiments = {new Experiment("Cloud Patterns", 36, 5),
            new Experiment("Solar Flares", 264, 9),
            new Experiment("Solar Power", 188, 6),
            new Experiment("Binary Stars", 203, 8),
            new Experiment("Relativity", 104, 8),
            new Experiment("Seed Viability", 7, 4),
            new Experiment("Sun Spots", 90, 2),
            new Experiment("Mice Tumors", 65, 8),
            new Experiment("Microgravity Plant Growth", 75, 5),
            new Experiment("Micrometeorites", 170, 9),
            new Experiment("Cosmic Rays", 80, 7),
            new Experiment("Yeast Fermentation", 27, 4)};
		
		Payload test = new Payload();
		for(Experiment exp : experiments) {
			test.addExperiment(exp);
		}
		printTitle("Brute Force Test 1");
		printPayload(test);
		
		
	}
	/**
	 * Uses system printf to print a title that is roofed and floored by a "=" frame.
	 * This method was created to provide a uniform way of creating titles
	 * @param titleName The title you wish to put in the frame.
	 * 
	 * @author Spencer J Peck
	 */
	private static void printTitle(String titleName) {
		System.out.printf("\n====================\n%10s\n====================\n",titleName);
	}
	/**
	 * Prints out information from the Payload class.
	 * This method was created to provide an external way of printing the Payload object-
	 *  that was specific to the concerns of this testing group
	 * @param payload
	 * 
	 * @author Spencer J Peck
	 */
	private static void printPayload(Payload payload) {
		if(payload == null) {
			return;
		}
		System.out.println("Payload Rating: "+ payload.getRating());
		System.out.println("Payload Weight: " + payload.getWeight());
		System.out.println("Payload " + payload.experimentList());
	}


}
