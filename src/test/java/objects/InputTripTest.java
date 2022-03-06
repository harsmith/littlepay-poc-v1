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


        assertEquals(1L, inputTrip.getId().longValue());
        assertEquals( new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("18-01-2018 15:00:00"), inputTrip.getDateTimeUtc());
        assertEquals("ON", inputTrip.getTapType());
        assertEquals("Stop1", inputTrip.getStopId());
        assertEquals("Company1", inputTrip.getCompanyId());
        assertEquals("Bus1", inputTrip.getBusId());
        assertEquals(630495060000000000L, inputTrip.getPan().longValue());
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


        assertEquals(2L, inputTrip.getId().longValue());
        assertEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("11-06-2018 23:00:00"), inputTrip.getDateTimeUtc());
        assertEquals("OFF", inputTrip.getTapType());
        assertEquals("Stop2", inputTrip.getStopId());
        assertEquals("Company2", inputTrip.getCompanyId());
        assertEquals("Bus2", inputTrip.getBusId());
        assertEquals(3528000700000000L, inputTrip.getPan().longValue());
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


        assertNotEquals(4L, inputTrip.getId().longValue());
        assertNotEquals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("25-04-2018 21:00:00"), inputTrip.getDateTimeUtc());
        assertNotEquals("OFF", inputTrip.getTapType());
        assertNotEquals("Stop2", inputTrip.getStopId());
        assertNotEquals("Company2", inputTrip.getCompanyId());
        assertNotEquals("Bus2", inputTrip.getBusId());
        assertNotEquals(34343434343435L, inputTrip.getPan().longValue());
    }
}
