
package traffic.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * AnalyzedResults - record to hold processed results - output data
 * @author  Kuladeep Parella.
 */
public record AnalyzedResults(

    int totalCars,
    Map<LocalDate, Integer> carsPerDay,
    List<TrafficRecord> top3HalfHours,
    List<TrafficRecord> leastTraffic1Point5Hours

) {}
