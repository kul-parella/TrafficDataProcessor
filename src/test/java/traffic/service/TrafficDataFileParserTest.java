package traffic.service;

import org.junit.jupiter.api.Test;
import traffic.model.TrafficRecord;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TrafficDataFileParser
 *  @author  Kuladeep Parella.
 */
public class TrafficDataFileParserTest {

    private final TrafficDataFileParser parser = new TrafficDataFileParser();

    @Test
    void testParseExistingFile() {
        Path file = Path.of("traffic.txt");

        // Ensure traffic.txt exists in project root
        assertTrue(Files.exists(file), "traffic.txt must exist in project root for this test");

        // Parse the file
        List<TrafficRecord> records = parser.parse(file);

        // Validate results
        assertNotNull(records, "Parsed list should not be null");
        assertFalse(records.isEmpty(), "Parsed list should not be empty");

        // Optional: check first record is parsed correctly
        TrafficRecord first = records.get(0);
        assertNotNull(first.timestamp(), "First record timestamp should not be null");
        assertTrue(first.cars() >= 0, "First record cars should be non-negative");
    }

    @Test
    void testParseNonExistentFile() {
        Path nonExistentFile = Path.of("nonexistent.txt");

        List<TrafficRecord> records = parser.parse(nonExistentFile);

        // Should return empty list
        assertNotNull(records);
        assertTrue(records.isEmpty(), "Parsing a non-existent file should return empty list");
    }
}
