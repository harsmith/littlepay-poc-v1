import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

public class ApplicationTest {

    @Test
    public void CompleteTripTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/completeTripTest1.csv";
        String outputFileName = "src/test/resources/application/output/completeTripTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/completeTripTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void CompleteTripTest2() throws IOException {
        String inputFileName = "src/test/resources/application/input/completeTripTest2.csv";
        String outputFileName = "src/test/resources/application/output/completeTripTest2.csv";
        String expectedFileName = "src/test/resources/application/expected/completeTripTest2.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void CompleteTripNegativeTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/completeTripNegativeTest1.csv";
        String outputFileName = "src/test/resources/application/output/completeTripNegativeTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/completeTripNegativeTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assertNotEquals(readFile(outputFileName), readFile(expectedFileName));
    }

    @Test
    public void IncompleteTripTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/incompleteTripTest1.csv";
        String outputFileName = "src/test/resources/application/output/incompleteTripTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/incompleteTripTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void IncompleteTripTest2() throws IOException {
        String inputFileName = "src/test/resources/application/input/incompleteTripTest2.csv";
        String outputFileName = "src/test/resources/application/output/incompleteTripTest2.csv";
        String expectedFileName = "src/test/resources/application/expected/incompleteTripTest2.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void IncompleteTripNegativeTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/incompleteTripNegativeTest1.csv";
        String outputFileName = "src/test/resources/application/output/incompleteTripNegativeTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/incompleteTripNegativeTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assertNotEquals(readFile(outputFileName), readFile(expectedFileName));
    }

    @Test
    public void CancelledTripTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/cancelledTripTest1.csv";
        String outputFileName = "src/test/resources/application/output/cancelledTripTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/cancelledTripTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);
        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void CancelledTripTest2() throws IOException {
        String inputFileName = "src/test/resources/application/input/cancelledTripTest2.csv";
        String outputFileName = "src/test/resources/application/output/cancelledTripTest2.csv";
        String expectedFileName = "src/test/resources/application/expected/cancelledTripTest2.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);

        assert (readFile(outputFileName).equals(readFile(expectedFileName)));
    }

    @Test
    public void CancelledTripNegativeTest1() throws IOException {
        String inputFileName = "src/test/resources/application/input/cancelledTripNegativeTest1.csv";
        String outputFileName = "src/test/resources/application/output/cancelledTripNegativeTest1.csv";
        String expectedFileName = "src/test/resources/application/expected/cancelledTripNegativeTest1.csv";

        String[] inputString = {inputFileName, outputFileName};

        Application.main(inputString);

        assertNotEquals(readFile(outputFileName), readFile(expectedFileName));
    }

    @Test
    public void IOExceptionTest() {
        String inputFileName = "src/test/resources/application/input/fakeFile.csv";
        String[] inputString = {inputFileName, ""};

        assertThrows(IOException.class, () -> Application.main(inputString));
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
