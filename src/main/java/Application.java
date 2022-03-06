import helper.TripProcessor;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // Specifies default fileNames
        String inputFileName = "src/main/resources/taps.csv";
        String outputFileName = "src/main/resources/trips.csv";

        TripProcessor tripProcessor = new TripProcessor();

        if (args.length == 1) {
            // Handle a custom input file path
            inputFileName = args[0];

        } else if (args.length == 2) {
            // Handle a custom input & output file path
            inputFileName = args[0];
            outputFileName = args[1];
        }

        // Process trips based off the provided input file
        tripProcessor.processTrips(inputFileName, outputFileName);
    }
}
