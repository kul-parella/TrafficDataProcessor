package traffic;

import traffic.model.TrafficRecord;
import traffic.model.AnalyzedResults;
import traffic.service.TrafficDataProcessor;
import traffic.service.TrafficDataFileParser;

import java.nio.file.Path;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TrafficDataProcessorApp - main class to start process
 * Author: Kuladeep Parella
 */
public class TrafficDataProcessorApp {

    private static final Logger log =
            LoggerFactory.getLogger(TrafficDataProcessorApp.class);

    public static void main(String[] args) {

        String filePath = args.length > 0 ? args[0] : "traffic.txt";
        Path file = Path.of(filePath);

        log.info("Starting Traffic Data Processor...");
        log.info("Input file: {}", file.toAbsolutePath());

        // Parse file
        TrafficDataFileParser parser = new TrafficDataFileParser();
        log.info("Parsing file...");
        List<TrafficRecord> records = parser.parse(file);
        log.info("Parsing done. {} records loaded.", records.size());

        if (records.isEmpty()) {
            log.error("No records found! Please check the input file.");
            return;
        }

        // Process traffic data
        TrafficDataProcessor processor = new TrafficDataProcessor();
        log.info("Processing traffic data...");
        AnalyzedResults result = processor.process(records);
        log.info("Processing completed.");

        log.info("\n--- Results ---");

        // Total cars
        log.info("\n1. Total cars seen:");
        log.info("Total cars seen: {}", result.totalCars());

        // Cars per day
        log.info("\n2. Cars per day:");
        result.carsPerDay().forEach((day, cars) ->
                log.info("{}: {}", day, cars)
        );

        // Top 3 half-hours
        log.info("\n3. Top 3 half-hours with most cars:");
        result.top3HalfHours().forEach(tr ->
                log.info("{}: {}", tr.timestamp(), tr.cars())
        );

        // 1.5-hour period with least cars
        log.info("\n4. one and half hour period with least cars:");
        if (result.leastTraffic1Point5Hours().isEmpty()) {
            log.warn("Not enough data for 1.5-hour analysis.");
        } else {
            result.leastTraffic1Point5Hours().forEach(r ->
                    log.info("{}: {}", r.timestamp(), r.cars())
            );
        }

        log.info("\nTraffic Data Processor finished.");
    }
}
