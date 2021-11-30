
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {
/*
* loadIndianStateCodeData() method to load data from CSV file
* */
    public int loadIndianStateCodeData(String csvFilePath) throws CensusAnalyserException, IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBean<StateCensusAnalyser>csvToBean = new CsvToBeanBuilder<StateCensusAnalyser>(reader)
                    .withType(StateCensusAnalyser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<StateCensusAnalyser> iterator = csvToBean.iterator();
            Iterable<StateCensusAnalyser> csvIterable = () -> iterator;
            int count = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
            return count;
        } catch (IOException e) {
            throw e;
        }
    }
}
