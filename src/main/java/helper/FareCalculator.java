package helper;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

public class FareCalculator {
    public String calculate(String stop1, String stop2) {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        int priceMatrixSize = 4;

        // Generate price matrix
        for (int i = 1; i < priceMatrixSize; i++) {
            for (int j = 1; j < priceMatrixSize; j++) {
                String price = "$0";
                
                if (i == j) {
                    multiKeyMap.put(new MultiKey<>("Stop" + i, "Stop" + j), price);
                    continue;
                }

                if (i == 1 && j == 2 || i == 2 && j == 1) {
                    price = "$3.25";
                } else if (i == 2 && j == 3 || i == 3 && j == 2) {
                    price = "$5.50";
                } else if (i == 3 && j == 1 || i == 1 && j == 3) {
                    price = "$7.30";
                }

                multiKeyMap.put(new MultiKey<>("Stop" + i, "Stop" + j), price);
            }
        }

        // Custom conditions of incomplete trip, highest price is charged for an incomplete trip
        multiKeyMap.put(new MultiKey<>("Stop1", null), "$7.30");
        multiKeyMap.put(new MultiKey<>("Stop2", null), "$5.50");
        multiKeyMap.put(new MultiKey<>("Stop3", null), "$7.30");

        // Query the multi key map
        return multiKeyMap.get(stop1, stop2);
    }
}
