package helper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FareCalculatorTest {
    final FareCalculator fareCalculator = new FareCalculator();

    @Test
    public void FareCalculatorTest1() {
        assertEquals(fareCalculator.calculate("Stop1", "Stop2"), "$3.25");
    }

    @Test
    public void FareCalculatorTest2() {
        assertEquals(fareCalculator.calculate("Stop2", "Stop3"), "$5.50");
    }

    @Test
    public void FareCalculatorTest3() {
        assertEquals(fareCalculator.calculate("Stop1", "Stop3"), "$7.30");
    }

    @Test
    public void FareCalculatorTest4() {
        assertEquals(fareCalculator.calculate("Stop1", "Stop2"), "$3.25");
    }

    @Test
    public void FareCalculatorTest5() {
        assertEquals(fareCalculator.calculate("Stop2", "Stop1"), "$3.25");
    }

    @Test
    public void FareCalculatorTest6() {
        assertEquals(fareCalculator.calculate("Stop3", "Stop1"), "$7.30");
    }

    @Test
    public void FareCalculatorTest7() {
        assertEquals(fareCalculator.calculate("Stop1", null), "$7.30");
    }

    @Test
    public void FareCalculatorTest8() {
        assertEquals(fareCalculator.calculate("Stop2", null), "$5.50");
    }

    @Test
    public void FareCalculatorTest9() {
        assertEquals(fareCalculator.calculate("Stop3", null), "$7.30");
    }
}
