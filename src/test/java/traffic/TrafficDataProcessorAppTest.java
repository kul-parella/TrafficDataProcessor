package traffic;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for TrafficDataProcessorApp.
 * @author Kuladeep Parella.
 */
public class TrafficDataProcessorAppTest {

    @Test
    void testMainWithDefaultFile() {
        Path file = Path.of("traffic.txt");

        // Ensure traffic.txt exists in project root
        assertTrue(Files.exists(file), "traffic.txt must exist in project root for this test");

        // Call the main method with no arguments (default file)
        TrafficDataProcessorApp.main(new String[]{});
    }

    @Test
    void testMainWithExplicitFile() {
        Path file = Path.of("traffic.txt");

        // Ensure traffic.txt exists
        assertTrue(Files.exists(file), "traffic.txt must exist in project root for this test");

        // Call the main method with explicit file path
        TrafficDataProcessorApp.main(new String[]{file.toAbsolutePath().toString()});
    }

    @Test
    void testMainWithNonExistentFile() {
        // Call main with a non-existent file path
        // Should log an error but not throw an exception
        TrafficDataProcessorApp.main(new String[]{"nonexistent.txt"});
    }
}
