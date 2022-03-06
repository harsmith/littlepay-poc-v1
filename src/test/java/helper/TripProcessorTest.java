package helper;

import io.CsvUtility;
import objects.OutputTrip;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class TripProcessorTest {
    final TripProcessor tripProcessor = new TripProcessor();
    final CsvUtility csvUtility = new CsvUtility();

    @Test
    public void ProcessTripsTest1() throws IOException {
        String inputFileName = "src/test/resources/helper/input/processTripsTest1.csv";
        String outputFileName = "src/test/resources/helper/output/processTripsTest1.csv";
        String expectedFileName = "src/test/resources/helper/expected/processTripsTest1.csv";


        tripProcessor.processTrips(inputFileName, outputFileName);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void ProcessTripsTest2() throws IOException {
        String inputFileName = "src/test/resources/helper/input/processTripsTest2.csv";
        String outputFileName = "src/test/resources/helper/output/processTripsTest2.csv";
        String expectedFileName = "src/test/resources/helper/expected/processTripsTest2.csv";


        tripProcessor.processTrips(inputFileName, outputFileName);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void ProcessTripsNegativeTest1() {
        String inputFileName = "src/test/resources/helper/input/processTripsNegativeTest1.csv";

        assertThrows(IOException.class, () -> tripProcessor.processTrips(inputFileName, null));
    }

    @Test
    public void AnalyseTripsTest1() throws IOException {
        String inputFileName = "src/test/resources/helper/input/analyseTripsTest1.csv";
        String expectedFileName = "src/test/resources/helper/expected/analyseTripsTest1.csv";


        List<OutputTrip> outputTripList = tripProcessor.analyseTrips(csvUtility.read(inputFileName));
        assert (outputTripList.size() == 1);
        assert (readFile(expectedFileName).equals(outputTripList.get(0).toString()));
    }

    @Test
    public void AnalyseTripsTest2() throws IOException {
        String inputFileName = "src/test/resources/helper/input/analyseTripsTest2.csv";
        String expectedFileName = "src/test/resources/helper/expected/analyseTripsTest2.csv";


        List<OutputTrip> outputTripList = tripProcessor.analyseTrips(csvUtility.read(inputFileName));
        assert (outputTripList.size() == 1);
        assert (readFile(expectedFileName).equals(outputTripList.get(0).toString()));
    }

    @Test
    public void AnalyseTripsNegativeTest1() throws FileNotFoundException {
        String inputFileName = "src/test/resources/helper/input/analyseTripsNegativeTest1.csv";

        List<OutputTrip> outputTripList = tripProcessor.analyseTrips(csvUtility.read(inputFileName));
        assert (outputTripList.size() == 0);
    }

    @Test
    public void AnalyseTripsNegativeTest2() {
        String inputFileName = "src/test/resources/helper/input/analyseTripsNegativeTest2.csv";

        assertThrows(IOException.class, () -> tripProcessor.analyseTrips(csvUtility.read(inputFileName)));
    }

    public String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String fileAsString = "";

        String line;
        while ((line = br.readLine()) != null) {
            fileAsString += line;
        }

        br.close();

        return fileAsString;
    }
}
