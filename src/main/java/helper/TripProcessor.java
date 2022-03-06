package helper;


import io.CsvUtility;
import objects.InputTrip;
import objects.OutputTrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripProcessor {

    public void processTrips(String inputFileName, String outputFileName) throws IOException {
        CsvUtility csvUtility = new CsvUtility();

        List<InputTrip> inputTripList = csvUtility.read(inputFileName);
        List<OutputTrip> outputTripList = analyseTrips(inputTripList);

        csvUtility.write(outputTripList, outputFileName);
    }

    public List<OutputTrip> analyseTrips(List<InputTrip> inputTripList) {
        ArrayList<OutputTrip> outputTripList = new ArrayList<>();
        ArrayList<InputTrip> calculatedRoutes = new ArrayList<>();

        TripPricingHelper tripPricingCalculator = new TripPricingHelper();

        for (int i = 0; i < inputTripList.size(); i++) {
            InputTrip correspondingTrip = null;

            // One a trip has already been calculated we don't need to check for it again, similarly as stated
            // as a presumption a trip can't start with an OFF
            if (inputTripList.get(i).getTapType().equals("OFF") || calculatedRoutes.contains(inputTripList.get(i))) {
                continue;
            }

            // Setting the nested loop to the outer loops value, so
            // we optimise and don't reprocess elements already checked.
            for (int j = (i + 1); j < inputTripList.size(); j++) {
                InputTrip trip1 = inputTripList.get(i);
                InputTrip trip2 = inputTripList.get(j);

                if (tripPricingCalculator.identifierCheck(trip1, trip2) && tripPricingCalculator.tapOffCheck(trip1, trip2)) {
                    correspondingTrip = trip2;
                }
            }

            // Verifies the if there was a corresponding trip, or if it was incomplete
            OutputTrip output = (correspondingTrip != null) ? tripPricingCalculator.calculatePriceOfCompletedTrip(inputTripList.get(i), correspondingTrip) : tripPricingCalculator.calculatePriceOfIncompleteTrip(inputTripList.get(i));
            calculatedRoutes.add(inputTripList.get(i));

            if (correspondingTrip != null) {
                calculatedRoutes.add(correspondingTrip);
            }

            outputTripList.add(output);
        }

        return outputTripList;
    }
}
