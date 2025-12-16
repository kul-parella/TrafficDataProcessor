TrafficDataProcessor

TrafficDataProcessor is a Java-based application developed using Java 21 and Gradle 9.1. It parses traffic data from input file, analyzes it, and produces insightful statistics such as total cars seen, cars per day, top half-hours with most traffic, and periods with least traffic.

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
- to run use gradle run command -  <i> ./gradlew run </i> or directly run through jar using <i> java -jar build/libs/TrafficDataProcessor-1.0.0.jar </i>
- By default, the application looks for a file named traffic.txt in the project root
- You can also provide a custom file path as an argument - <i> ./gradlew run --args="path to external file" </i>
- After successfully running app with above commands, results can be seen in console logs 


## Sample Output

### 1. Total Cars Seen
**398**

### 2. Cars Per Day
| Date       | Cars |
|-----------|------|
| 2021-12-01 | 179  |
| 2021-12-05 | 81   |
| 2021-12-08 | 134  |
| 2021-12-09 | 4    |

### 3. Top 3 Half-Hours With Most Cars
| Time Slot              | Cars |
|-----------------------|------|
| 2021-12-01 07:30–08:00 | 46   |
| 2021-12-01 08:00–08:30 | 42   |
| 2021-12-08 18:00–18:30 | 33   |

### 4. 1.5-Hour Period With Least Cars
| Time Slot              | Cars |
|-----------------------|------|
| 2021-12-01 15:00–15:30 | 9    |
| 2021-12-01 15:30–16:00 | 11   |
| 2021-12-01 23:30–00:00 | 0    |
            




