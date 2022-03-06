package io;

import objects.InputTrip;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class CsvUtilityTest {
    private final CsvUtility csvUtility = new CsvUtility();

    @Test
    public void CsvUtilityReadTest1() throws FileNotFoundException, ParseException {
        List<InputTrip> input = csvUtility.read("src/test/resources/io/input/csvUtilityReadTest1.csv");
        InputTrip inputTrip = new InputTrip();

        inputTrip.setId(1L);
        inputTrip.setDateTimeUtc(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("27-01-2017 13:00:00"));
        inputTrip.setTapType("ON");
        inputTrip.setStopId("Stop1");
        inputTrip.setCompanyId("Company101");
        inputTrip.setBusId("Bus101");
        inputTrip.setPan(4911830000000L);

        List<InputTrip> expectedInput = Arrays.asList(inputTrip);

        assertEquals(input.size(), expectedInput.size());
        assertEquals(input.get(0).toString(), expectedInput.get(0).toString());
    }

    @Test
    public void CsvUtilityReadTest2() throws FileNotFoundException, ParseException {
        List<InputTrip> input = csvUtility.read("src/test/resources/io/input/csvUtilityReadTest2.csv");
        InputTrip inputTrip = new InputTrip();

        inputTrip.setId(2L);
        inputTrip.setDateTimeUtc(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("11-07-2018 07:10:01"));
        inputTrip.setTapType("OFF");
        inputTrip.setStopId("Stop2");
        inputTrip.setCompanyId("Company100");
        inputTrip.setBusId("Bus56");
        inputTrip.setPan(4484070000000000L);

        List<InputTrip> expectedInput = Arrays.asList(inputTrip);

        assertEquals(input.size(), expectedInput.size());
        assertEquals(input.get(0).toString(), expectedInput.get(0).toString());
    }

    @Test
    public void CsvUtilityReadFileNotFoundExceptionTest1() {
        assertThrows(FileNotFoundException.class, () -> csvUtility.read("src/test/resources/io/input/csvUtilityReadFileNotFoundExceptionTest1.csv"));
    }
}
