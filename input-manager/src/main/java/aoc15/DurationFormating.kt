package aoc15

import java.time.Duration
import java.util.concurrent.TimeUnit

fun formatDuration(duration: Duration): String {
    return when {
        duration.seconds >= 1 -> {
            val millis = TimeUnit.MILLISECONDS.convert(Duration.ofNanos(duration.nano.toLong()))
            "${duration.seconds}.${millis} s"
        }

        duration.nano >= 1_000_000 -> "${TimeUnit.MILLISECONDS.convert(duration)} ms"
        duration.nano >= 1_000 -> "${TimeUnit.MICROSECONDS.convert(duration)} µs"
        else -> "${TimeUnit.NANOSECONDS.convert(duration)} ns"
    }
}