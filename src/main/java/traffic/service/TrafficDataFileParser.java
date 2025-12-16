package traffic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import traffic.model.TrafficRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TrafficDataFileParser - Parser class to Deserialize input data from file to TrafficRecord list.
 * @author  Kuladeep Parella.
 */
public class TrafficDataFileParser {

    private static final Logger log =
            LoggerFactory.getLogger(TrafficDataFileParser.class);

    /**
     * parse provided file
     * This method parse the file from path provided
     * deserializes each row of the file to TrafficRecord.
     * @param file Path of the file.
     * @return List of TrafficRecords.
     */
    public List<TrafficRecord> parse(Path file) {
        // Checking if file exists, if file not found log error and return empty list.
        if (!Files.exists(file)) {
            log.error("File not found: {}", file.toAbsolutePath());
            return List.of();
        }
        // As file exists, reading file line by line and converting data to list of TrafficRecords
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .map(line -> {
                        // split each line to parts where there is space
                        var parts = line.split(" ");
                        return new TrafficRecord(
                                // first part timestamp
                                LocalDateTime.parse(parts[0]),
                                // second part no. of cars
                                Integer.parseInt(parts[1])
                        );
                    })
                    .collect(Collectors.toList());

    } catch (IOException e) {
            // logging error if exception is raised while parsing and deserializing to TrafficRecord.
            log.error("Error reading traffic data file: {}", file.toAbsolutePath(), e);
            // empty list returned in case of exception raised while parsing.
            return List.of();
        }
    }
}
