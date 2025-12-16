
package traffic.service;

import traffic.model.TrafficRecord;
import traffic.model.AnalyzedResults;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TrafficDataProcessor - process parsed data from file as per requirement
 * @author  Kuladeep Parella.
 */
public class TrafficDataProcessor {
    /**
     *
     * @param records List of TrafficRecords (holding timestamp and no. of cars passed).
     * @return AnalyzedResults - processed/analyzed results from input as per requirement.
     */
    public AnalyzedResults process(List<TrafficRecord> records) {
        // sorting records in natural ordering of timestamps
        records = records.stream()
                .sorted(Comparator.comparing(TrafficRecord::timestamp))
                .toList();
        // The number of cars seen in total
        int total = records.stream().mapToInt(TrafficRecord::cars).sum();

        /*A sequence of lines where each line contains a date (in yyyy-mm-dd format) and the
        number of cars seen on that day (eg. 2016-11-23 289) for all days listed in the input file.*/
        Map<LocalDate, Integer> perDay = records.stream()
                // collecting groupBy of date and sum of cars passed for each date
                .collect(Collectors.groupingBy(
                        r -> r.timestamp().toLocalDate(),
                        TreeMap::new,
                        Collectors.summingInt(TrafficRecord::cars)
                ));

        //The top 3 half hours with most cars, in the same format as the input file.
        List<TrafficRecord> top3 = records.stream()
                // sort by natural ordering and then reversing to get higher to lower
                .sorted(Comparator.comparingInt(TrafficRecord::cars).reversed())
                // get first 3 records to list
                .limit(3)
                .toList();

        //The 1.5 hour period with least cars (i.e. 3 contiguous half hour records)
        List<TrafficRecord> least = findLeast(records, 3);
        // create and return AnalyzedResults with all results
        return new AnalyzedResults(total, perDay, top3, least);
    }

    /**
     * findLeast private method - uses sliding window approach to
     * find the consecutive half hour records with lease cars passed.
     *
     * @param records list of TrafficRecords parsed.
     * @param windowSize fixed size of 3 as per requirement.
     * @return List of trafficRecords
     */
    private List<TrafficRecord> findLeast(List<TrafficRecord> records, int windowSize) {
        // making sure window size is more than size of records.
        if (records.size() < windowSize) {
            return List.of();
        }

        // local record Window
        record Window(int index, int sum) {}

        Window minWindow = IntStream.rangeClosed(0, records.size() - windowSize)
                // converts index to window object
                .mapToObj(i -> new Window(
                        i,
                        // sum of cars for each window
                        records.subList(i, i + windowSize)
                                .stream()
                                .mapToInt(TrafficRecord::cars)
                                .sum()
                ))
                // min of the sum
                .min(Comparator.comparingInt(Window::sum))
                .orElseThrow();

        return records.subList(minWindow.index(), minWindow.index() + windowSize);
    }


}
