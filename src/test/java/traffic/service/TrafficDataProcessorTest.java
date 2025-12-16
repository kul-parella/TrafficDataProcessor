
package traffic.service;
import org.junit.jupiter.api.Test;
import traffic.model.TrafficRecord;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TrafficDataProcessor
 *  @author  Kuladeep Parella.
 */
class TrafficDataProcessorTest {

    @Test
    void totalCarsCalculatedCorrectly() {
        var records = List.of(
                new TrafficRecord(LocalDateTime.parse("2021-12-01T05:00:00"), 5),
                new TrafficRecord(LocalDateTime.parse("2021-12-01T05:30:00"), 10)
        );

        var analyzer = new TrafficDataProcessor();
        var result = analyzer.process(records);

        assertEquals(15, result.totalCars());
    }
}
