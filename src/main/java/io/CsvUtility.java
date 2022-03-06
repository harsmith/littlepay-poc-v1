package io;

import com.opencsv.bean.CsvToBeanBuilder;
import objects.InputTrip;
import objects.OutputTrip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvUtility {
    public List read(String fileName) throws FileNotFoundException {

        return new CsvToBeanBuilder(new FileReader(fileName))
                .withType(InputTrip.class)
                .build()
                .parse();
    }

    public void write(List<OutputTrip> outputTripList, String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        String[] outputHeaders = {"Started", "Finished", "DurationSecs", "FromStopId", "ToStopId", "ChargeAmount", "companyId", "BusID", "PAN", "Status"};

        writer.println(String.join(",", outputHeaders));

        for (OutputTrip outputTrip : outputTripList) {
            writer.println(outputTrip.toString());
        }

        writer.close();
    }
}