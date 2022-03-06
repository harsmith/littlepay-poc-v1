package helper;

import objects.InputTrip;
import objects.OutputTrip;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripPricingHelperTest {
    final TripPricingHelper tripPricingCalculator = new TripPricingHelper();

    @Test
    public void IdentifierCheckTest1() {
        InputTrip inputTrip1 = new InputTrip();
        inputTrip1.setCompanyId("Company123");
        inputTrip1.setBusId("Bus123");
        inputTrip1.setPan(6011000400000000L);

        InputTrip inputTrip2 = new InputTrip();
        inputTrip2.setCompanyId("Company123");
        inputTrip2.setBusId("Bus123");
        inputTrip2.setPan(6011000400000000L);

        assert(tripPricingCalculator.identifierCheck(inputTrip1, inputTrip2));
    }

    @Test
    public void IdentifierCheckTest2() {
        InputTrip inputTrip1 = new InputTrip();
        inputTrip1.setCompanyId("Company1");
        inputTrip1.setBusId("Bus1");
        inputTrip1.setPan(4484070000000000L);

        InputTrip inputTrip2 = new InputTrip();
        inputTrip2.setCompanyId("Company1");
        inputTrip2.setBusId("Bus1");
        inputTrip2.setPan(4484070000000000L);

        assert(tripPricingCalculator.identifierCheck(inputTrip1, inputTrip2));
    }

    @Test
    public void IdentifierCheckNegativeTest1() {
        InputTrip inputTrip1 = new InputTrip();
        inputTrip1.setCompanyId("Company1");
        inputTrip1.setBusId("Bus1");
        inputTrip1.setPan(4484070000000000L);

        InputTrip inputTrip2 = new InputTrip();
        inputTrip2.setCompanyId("Company2");
        inputTrip2.setBusId("Bus2");
        inputTrip2.setPan(6799990100000000019L);

        assert(!tripPricingCalculator.identifierCheck(inputTrip1, inputTrip2));
    }

    @Test
    public void TapOffCheckCheckTest1() {
        InputTrip inputTrip1 = new InputTrip();
        inputTrip1.setTapType("ON");

        InputTrip inputTrip2 = new InputTrip();
        inputTrip2.setTapType("OFF");

        assert(tripPricingCalculator.tapOffCheck(inputTrip1, inputTrip2));
    }

    @Test
    public void TapOffCheckCheckNegativeTest1() {
        InputTrip inputTrip1 = new InputTrip();
        inputTrip1.setTapType("OFF");

        InputTrip inputTrip2 = new InputTrip();
        inputTrip2.setTapType("OFF");

        assert(!tripPricingCalculator.tapOffCheck(inputTrip1, inputTrip2));
    }

    @Test
    public void CalculatePriceOfCompletedTripCheckTest1() throws ParseException {
        Date startDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("27-01-2017 13:00:00");
        Date endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("27-01-2017 13:20:00");
        String company = "Company1000";
        String busId = "Bus1010";
        Long pan = 4484070000000000L;

        InputTrip inputTrip1 = new InputTrip();

        inputTrip1.setId(1L);
        inputTrip1.setDateTimeUtc(startDate);
        inputTrip1.setTapType("ON");
        inputTrip1.setStopId("Stop1");
        inputTrip1.setCompanyId(company);
        inputTrip1.setBusId(busId);
        inputTrip1.setPan(pan);

        InputTrip inputTrip2 = new InputTrip();

        inputTrip2.setId(2L);
        inputTrip2.setDateTimeUtc(endDate);
        inputTrip2.setTapType("OFF");
        inputTrip2.setStopId("Stop2");
        inputTrip2.setCompanyId(company);
        inputTrip2.setBusId(busId);
        inputTrip2.setPan(pan);


        OutputTrip outputTrip = new OutputTrip(startDate, endDate, 1200L, "Stop1", "Stop2", "$3.25", company, busId, pan, "COMPLETED");

        assert(tripPricingCalculator.calculatePriceOfCompletedTrip(inputTrip1, inputTrip2).toString().equals(outputTrip.toString()));
    }

    @Test
    public void CalculatePriceOfCompletedTripCheckTest2() throws ParseException {
        Date startDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("26-01-2017 07:00:00");
        Date endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("27-01-2017 07:05:00");
        String company = "Company1234";
        String busId = "Bus1234";
        Long pan = 4917300800000000L;

        InputTrip inputTrip1 = new InputTrip();

        inputTrip1.setId(1L);
        inputTrip1.setDateTimeUtc(startDate);
        inputTrip1.setTapType("ON");
        inputTrip1.setStopId("Stop1");
        inputTrip1.setCompanyId(company);
        inputTrip1.setBusId(busId);
        inputTrip1.setPan(pan);

        InputTrip inputTrip2 = new InputTrip();

        inputTrip2.setId(2L);
        inputTrip2.setDateTimeUtc(endDate);
        inputTrip2.setTapType("OFF");
        inputTrip2.setStopId("Stop3");
        inputTrip2.setCompanyId(company);
        inputTrip2.setBusId(busId);
        inputTrip2.setPan(pan);


        OutputTrip outputTrip = new OutputTrip(startDate, endDate, 86700L, "Stop1", "Stop3", "$7.30", company, busId, pan, "COMPLETED");

        assert(tripPricingCalculator.calculatePriceOfCompletedTrip(inputTrip1, inputTrip2).toString().equals(outputTrip.toString()));
    }

    @Test
    public void CalculatePriceOfCompletedTripCheckTest3() throws ParseException {
        Date startDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-01-2017 01:00:00");
        Date endDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-01-2017 01:10:00");
        String company = "Company1234";
        String busId = "Bus1234";
        Long pan = 4917300800000000L;

        InputTrip inputTrip1 = new InputTrip();

        inputTrip1.setId(1L);
        inputTrip1.setDateTimeUtc(startDate);
        inputTrip1.setTapType("ON");
        inputTrip1.setStopId("Stop1");
        inputTrip1.setCompanyId(company);
        inputTrip1.setBusId(busId);
        inputTrip1.setPan(pan);

        InputTrip inputTrip2 = new InputTrip();

        inputTrip2.setId(2L);
        inputTrip2.setDateTimeUtc(endDate);
        inputTrip2.setTapType("OFF");
        inputTrip2.setStopId("Stop1");
        inputTrip2.setCompanyId(company);
        inputTrip2.setBusId(busId);
        inputTrip2.setPan(pan);


        OutputTrip outputTrip = new OutputTrip(startDate, endDate, 600L, "Stop1", "Stop1", "$0", company, busId, pan, "CANCELLED");

        assert(tripPricingCalculator.calculatePriceOfCompletedTrip(inputTrip1, inputTrip2).toString().equals(outputTrip.toString()));
    }

    @Test
    public void CalculatePriceOfIncompleteTripTest1() throws ParseException {
        Date startDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-01-2017 01:00:00");
        String company = "Company1234";
        String busId = "Bus1234";
        Long pan = 4917300800000000L;

        InputTrip inputTrip1 = new InputTrip();

        inputTrip1.setId(1L);
        inputTrip1.setDateTimeUtc(startDate);
        inputTrip1.setTapType("ON");
        inputTrip1.setStopId("Stop1");
        inputTrip1.setCompanyId(company);
        inputTrip1.setBusId(busId);
        inputTrip1.setPan(pan);

        OutputTrip outputTrip = new OutputTrip(startDate, startDate, 0L, "Stop1", "Stop1", "$7.30", company, busId, pan, "INCOMPLETE");

        assert(tripPricingCalculator.calculatePriceOfIncompleteTrip(inputTrip1).toString().equals(outputTrip.toString()));
    }

    @Test
    public void CalculatePriceOfIncompleteTripTest2() throws  ParseException {
        Date startDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-01-2017 01:00:00");
        String company = "Company1234";
        String busId = "Bus1234";
        Long pan = 4917300800000000L;

        InputTrip inputTrip1 = new InputTrip();

        inputTrip1.setId(1L);
        inputTrip1.setDateTimeUtc(startDate);
        inputTrip1.setTapType("ON");
        inputTrip1.setStopId("Stop2");
        inputTrip1.setCompanyId(company);
        inputTrip1.setBusId(busId);
        inputTrip1.setPan(pan);

        OutputTrip outputTrip = new OutputTrip(startDate, startDate, 0L, "Stop2", "Stop2", "$5.50", company, busId, pan, "INCOMPLETE");

        assert(tripPricingCalculator.calculatePriceOfIncompleteTrip(inputTrip1).toString().equals(outputTrip.toString()));
    }
}
