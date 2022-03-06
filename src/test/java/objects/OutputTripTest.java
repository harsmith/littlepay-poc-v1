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

        OutputTrip outputTrip = new OutputTrip(date1, date2, duration, "Stop1", "Stop2", "$3.25", "Company71", "Bus3", panInput, "COMPLETE");

        assertEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:00:00"), outputTrip.getStartDateTimeUtc());
        assertEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-03-2018 17:01:00"), outputTrip.getStopDateTimeUtc());
        assertEquals(60L, outputTrip.getDurationSeconds().longValue());
        assertEquals("Stop1", outputTrip.getFromStopId());
        assertEquals("Stop2", outputTrip.getToStopId());
        assertEquals("$3.25", outputTrip.getFareAmount());
        assertEquals("Company71", outputTrip.getCompanyId());
        assertEquals("Bus3", outputTrip.getBusId());
        assertEquals(122000000000003L, outputTrip.getPan().longValue());
        assertEquals("COMPLETE", outputTrip.getStatus());
    }

    @Test
    public void OutputTripTest2() throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:00:00");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:50:00");
        Long panInput = 4917610000000000003L;
        Long duration = 3000L;

        OutputTrip outputTrip = new OutputTrip(date1, date2, duration, "Stop1", "Stop3", "$7.30", "Company30", "Bus21", panInput, "INCOMPLETE");

        assertEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:00:00"), outputTrip.getStartDateTimeUtc());
        assertEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("20-04-2018 18:50:00"), outputTrip.getStopDateTimeUtc());
        assertEquals(3000L, outputTrip.getDurationSeconds().longValue());
        assertEquals("Stop1", outputTrip.getFromStopId());
        assertEquals("Stop3", outputTrip.getToStopId());
        assertEquals("$7.30", outputTrip.getFareAmount());
        assertEquals("Company30", outputTrip.getCompanyId());
        assertEquals("Bus21", outputTrip.getBusId());
        assertEquals(4917610000000000003L, outputTrip.getPan().longValue());
        assertEquals("INCOMPLETE", outputTrip.getStatus());
    }

    @Test
    public void OutputTripNegativeTest1() throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("30-04-2018 22:00:00");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("30-04-2018 22:00:00");
        Long panInput = 4484070000000000L;
        Long duration = 60L;

        OutputTrip outputTrip = new OutputTrip(date1, date2, duration, "Stop1", "Stop3", "$5", "Company1", "Bus1", panInput, "COMPLETED");

        assertNotEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 20:00:00"), outputTrip.getStartDateTimeUtc());
        assertNotEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 21:00:00"), outputTrip.getStopDateTimeUtc());
        assertNotEquals(100L, outputTrip.getDurationSeconds().longValue());
        assertNotEquals("Stop1", outputTrip.getToStopId());
        assertNotEquals("Stop2", outputTrip.getFromStopId());
        assertNotEquals("$3.25", outputTrip.getFareAmount());
        assertNotEquals("Company2", outputTrip.getCompanyId());
        assertNotEquals("Bus2", outputTrip.getBusId());
        assertNotEquals(4917610000000000L, outputTrip.getPan().longValue());
        assertNotEquals("INCOMPLETE", outputTrip.getStatus());
    }
}
