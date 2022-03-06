package objects;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class InputTripTest {
    @Test
    public void OutputTripTest1() throws ParseException {
        InputTrip inputTrip = new InputTrip();

        inputTrip.setId(1L);
        inputTrip.setDateTimeUtc(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("18-01-2018 15:00:000"));
        inputTrip.setTapType("ON");
        inputTrip.setStopId("Stop1");
        inputTrip.setCompanyId("Company1");
        inputTrip.setBusId("Bus1");
        inputTrip.setPan(630495060000000000L);


        assertEquals(inputTrip.getId().longValue(), 1L);
        assertEquals(inputTrip.getDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("18-01-2018 15:00:00"));
        assertEquals(inputTrip.getTapType(), "ON");
        assertEquals(inputTrip.getStopId(), "Stop1");
        assertEquals(inputTrip.getCompanyId(), "Company1");
        assertEquals(inputTrip.getBusId(), "Bus1");
        assertEquals(inputTrip.getPan().longValue(), 630495060000000000L);
    }

    @Test
    public void OutputTripTest2() throws ParseException {
        InputTrip inputTrip = new InputTrip();

        inputTrip.setId(2L);
        inputTrip.setDateTimeUtc(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("11-06-2018 23:00:00"));
        inputTrip.setTapType("OFF");
        inputTrip.setStopId("Stop2");
        inputTrip.setCompanyId("Company2");
        inputTrip.setBusId("Bus2");
        inputTrip.setPan(3528000700000000L);


        assertEquals(inputTrip.getId().longValue(), 2L);
        assertEquals(inputTrip.getDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("11-06-2018 23:00:00"));
        assertEquals(inputTrip.getTapType(), "OFF");
        assertEquals(inputTrip.getStopId(), "Stop2");
        assertEquals(inputTrip.getCompanyId(), "Company2");
        assertEquals(inputTrip.getBusId(), "Bus2");
        assertEquals(inputTrip.getPan().longValue(), 3528000700000000L);
    }

    @Test
    public void OutputTripNegativeTest1() throws ParseException {
        InputTrip inputTrip = new InputTrip();

        inputTrip.setId(3L);
        inputTrip.setDateTimeUtc(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("30-04-2018 22:00:00"));
        inputTrip.setTapType("ON");
        inputTrip.setStopId("Stop1");
        inputTrip.setCompanyId("Company1");
        inputTrip.setBusId("Bus1");
        inputTrip.setPan(34343434343434L);


        assertNotEquals(inputTrip.getId().longValue(), 4L);
        assertNotEquals(inputTrip.getDateTimeUtc(), new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 21:00:00"));
        assertNotEquals(inputTrip.getTapType(), "OFF");
        assertNotEquals(inputTrip.getStopId(), "Stop2");
        assertNotEquals(inputTrip.getCompanyId(), "Company2");
        assertNotEquals(inputTrip.getBusId(), "Bus2");
        assertNotEquals(inputTrip.getPan().longValue(), 34343434343435L);
    }
}
