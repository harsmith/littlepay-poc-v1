package helper;

import objects.InputTrip;
import objects.OutputTrip;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TripPricingHelper {
    final FareCalculator fareCalculator = new FareCalculator();

    public Boolean identifierCheck(InputTrip trip1, InputTrip trip2) {
        //Verifies all the identifying information between two trips to correlate them.
        return (trip1.getPan().equals(trip2.getPan())) && (trip1.getBusId().equals(trip2.getBusId()) && (trip1.getCompanyId().equals(trip2.getCompanyId())));
    }

    public Boolean tapOffCheck(InputTrip trip1, InputTrip trip2) {
        // Verifies that a touch on and then a touch off has happened,
        // if no touch off was detected, then full price will be charged.
        return trip1.getTapType().equals("ON") && trip2.getTapType().equals("OFF");
    }

    public OutputTrip calculatePriceOfCompletedTrip(InputTrip trip1, InputTrip trip2) {
        Long tripTime = calculateTripTime(trip1.getDateTimeUtc(), trip2.getDateTimeUtc());

        // Two scenarios, calculate trip where the passenger went from stop a to stop b,
        // or process the scenario where the passenger went from stop a to stop a, so nothing is charged.
        if (!trip1.getStopId().equals(trip2.getStopId())) {
            String fareAmount = fareCalculator.calculate(trip1.getStopId(), trip2.getStopId());
            // Process a completed trip
            return new OutputTrip(trip1.getDateTimeUtc(), trip2.getDateTimeUtc(), tripTime, trip1.getStopId(), trip2.getStopId(), fareAmount, trip1.getCompanyId(), trip1.getBusId(), trip1.getPan(), "COMPLETED");
        } else {
            // Process a cancelled trip
            return new OutputTrip(trip1.getDateTimeUtc(), trip2.getDateTimeUtc(), tripTime, trip1.getStopId(), trip2.getStopId(), "$0", trip1.getCompanyId(), trip1.getBusId(), trip1.getPan(), "CANCELLED");
        }
    }

    public OutputTrip calculatePriceOfIncompleteTrip(InputTrip trip1) {
        Long tripTime = calculateTripTime(trip1.getDateTimeUtc(), trip1.getDateTimeUtc());
        String fareAmount = fareCalculator.calculate(trip1.getStopId(), null);

        return new OutputTrip(trip1.getDateTimeUtc(), trip1.getDateTimeUtc(), tripTime, trip1.getStopId(), trip1.getStopId(), fareAmount, trip1.getCompanyId(), trip1.getBusId(), trip1.getPan(), "INCOMPLETE");
    }

    private Long calculateTripTime(Date date1, Date date2) {
        return TimeUnit.MILLISECONDS.toSeconds(date2.getTime() - date1.getTime());
    }
}
