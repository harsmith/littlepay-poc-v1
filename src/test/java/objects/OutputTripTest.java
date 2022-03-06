package objects;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class OutputTripTest {
    @Test
    public void OutputTripTest1() throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:00:00");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:01:00");
        Long panInput = 122000000000003L;
        Long duration = 60L;

        OutputTrip outputTrip = new OutputTrip(date1, date2,
                duration, "Stop1", "Stop2", "$3.25",
                "Company71", "Bus3", panInput, "COMPLETE");

        assertEquals(outputTrip.getStartDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:00:00"));
        assertEquals(outputTrip.getStopDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:01:00"));
        assertEquals(outputTrip.getDurationSeconds().longValue(), 60L);
        assertEquals(outputTrip.getFromStopId(), "Stop1");
        assertEquals(outputTrip.getToStopId(), "Stop2");
        assertEquals(outputTrip.getFareAmount(), "$3.25");
        assertEquals(outputTrip.getCompanyId(), "Company71");
        assertEquals(outputTrip.getBusId(), "Bus3");
        assertEquals(outputTrip.getPan().longValue(), 122000000000003L);
        assertEquals(outputTrip.getStatus(), "COMPLETE");
    }

    @Test
    public void OutputTripTest2() throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:00:00");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:50:00");
        Long panInput = 4917610000000000003L;
        Long duration = 3000L;

        OutputTrip outputTrip = new OutputTrip(date1, date2,
                duration, "Stop1", "Stop3", "$7.30",
                "Company30", "Bus21", panInput, "INCOMPLETE");

        assertEquals(outputTrip.getStartDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:00:00"));
        assertEquals(outputTrip.getStopDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:50:00"));
        assertEquals(outputTrip.getDurationSeconds().longValue(), 3000L);
        assertEquals(outputTrip.getFromStopId(), "Stop1");
        assertEquals(outputTrip.getToStopId(), "Stop3");
        assertEquals(outputTrip.getFareAmount(), "$7.30");
        assertEquals(outputTrip.getCompanyId(), "Company30");
        assertEquals(outputTrip.getBusId(), "Bus21");
        assertEquals(outputTrip.getPan().longValue(), 4917610000000000003L);
        assertEquals(outputTrip.getStatus(), "INCOMPLETE");
    }

    @Test
    public void OutputTripNegativeTest1() throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("30-04-2018 22:00:00");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("30-04-2018 22:00:00");
        Long panInput = 4484070000000000L;
        Long duration = 60L;

        OutputTrip outputTrip = new OutputTrip(date1, date2,
                duration, "Stop1", "Stop3", "$5",
                "Company1", "Bus1", panInput, "COMPLETED");

        assertNotEquals(outputTrip.getStartDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 20:00:00"));
        assertNotEquals(outputTrip.getStopDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 21:00:00"));
        assertNotEquals(outputTrip.getDurationSeconds().longValue(), 100L);
        assertNotEquals(outputTrip.getToStopId(), "Stop1");
        assertNotEquals(outputTrip.getFromStopId(), "Stop2");
        assertNotEquals(outputTrip.getFareAmount(), "$3.25");
        assertNotEquals(outputTrip.getCompanyId(), "Company2");
        assertNotEquals(outputTrip.getBusId(), "Bus2");
        assertNotEquals(outputTrip.getPan().longValue(), 4917610000000000L);
        assertNotEquals(outputTrip.getStatus(), "INCOMPLETE");
    }
}
