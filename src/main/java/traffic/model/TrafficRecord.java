
package traffic.model;

import java.time.LocalDateTime;
/**
 * TrafficRecord - record to hold parsed input data -
 * timestamp and no.of cars passed in each line of input file.
 * @author  Kuladeep Parella.
 */
// reason to choose record instead of java.util.Map(can hold timestamp as key and cars as value)
// is future extensibility.
public record TrafficRecord(LocalDateTime timestamp, int cars) {}
