TrafficDataProcessor

TrafficDataProcessor is a Java-based application developed using Java 21 and Gradle. It parses traffic data from input files, analyzes it, and produces insightful statistics such as total cars seen, cars per day, top half-hours with most traffic, and periods with least traffic.

Note: The project originally started with Java 25, but it was downgraded to Java 21 due to compatibility issues between Java 25 and the latest Gradle version. More details on this issue can be found here: 
Gradle Issue #35054 - https://github.com/gradle/gradle/issues/35054.

<u> About code base: </u>

    Features 
       Reads traffic data from a text file and converts it into Java objects.
       Calculates:
           Total number of cars observed.
           Number of cars per day.
           Top 3 half-hour periods with the most traffic.
           1.5-hour period with the least traffic. 
       Logs all results clearly using SLF4J - console logging through logback.xml.

<u> Instructions to build and run the project </u>

- Make sure you have Java 21 installed.
- git clone https://github.com/kul-parella/TrafficDataProcessor.git
- cd TrafficDataProcessor
- clean and build the project using gradle command -  <i> ./gradlew clean build  </i>  
- to run use gradle run command -  <i> ./gradlew run </i> or directly run through jar using <i> java -jar build/libs/traffic-counter-1.0.0.jar
  </i>
- By default, the application looks for a file named traffic.txt in the project root
- You can also provide a custom file path as an argument - <i> ./gradlew run --args="path to external file" </i>
- After successfully running app with above commands, results and be seen in console logs 


<u> sample logs from previous runs </u>

        --- Results ---
2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp -
1. Total cars seen:
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - Total cars seen: 398
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp -
2. Cars per day:
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01: 179
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-05: 81
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-08: 134
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-09: 4
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp -
3. Top 3 half-hours with most cars:
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01T07:30: 46
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01T08:00: 42
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-08T18:00: 33
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp -
4. one and half hour period with least cars:
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01T15:00: 9
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01T15:30: 11
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp - 2021-12-01T23:30: 0
   2025-12-17 01:25:45 INFO  [main] traffic.TrafficDataProcessorApp -
   Traffic Data Processor finished.

            




