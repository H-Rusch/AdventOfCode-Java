package day02

import java.util.stream.Stream
import kotlin.streams.asStream

data class IdRange(val lower: Long, val upper: Long) {

    fun iterate(): Stream<Long> {
        return (lower..upper).asSequence().asStream()
    }
}
