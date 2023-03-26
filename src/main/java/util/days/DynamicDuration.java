package util.days;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicDuration {

    public static String formatDuration(Duration duration) {
        if (duration.getSeconds() >= 1) {
            return duration.getSeconds() + "." + TimeUnit.MILLISECONDS.convert(Duration.ofNanos(duration.getNano())) + "s";
        }
        if (duration.getNano() >= 1000000) {
            return TimeUnit.MILLISECONDS.convert(duration) + "ms";
        }
        if (duration.getNano() >= 1000) {
            return TimeUnit.MICROSECONDS.convert(duration) + "µs";
        }
        return TimeUnit.NANOSECONDS.convert(duration) + "ns";
    }
}
