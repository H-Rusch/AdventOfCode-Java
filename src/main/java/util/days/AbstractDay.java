package util.days;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public abstract class AbstractDay {

    private final int year;
    private final int day;

    public AbstractDay(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public abstract String part1(String input);

    public abstract String part2(String input);

    private String loadInput() {
        try {
            return InputFetcher.fetchInput(year, day);
        } catch (IOException | InterruptedException | UnsuccessfulDownloadException e) {
            throw new RuntimeException(e);
        }
    }

    public void main() {
        System.out.println(year + " day " + day + ":\n");
        String input = this.loadInput();

        Instant start = Instant.now();
        String result = part1(input);
        Instant stop = Instant.now();
        printResult(1, result, Duration.between(start, stop));

        start = Instant.now();
        result = part2(input);
        stop = Instant.now();
        printResult(2, result, Duration.between(start, stop));
    }

    private void printResult(int part, String result, Duration duration) {
        System.out.println("part " + part + ": " + result);
        System.out.println(DynamicDuration.formatDuration(duration));
    }
}
