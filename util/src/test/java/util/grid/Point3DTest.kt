package util.grid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Point3DTest {

    @Test
    fun euclidianDistanceBetweenPoints() {
        val pointA = Point3D(4, 10, 6)
        val pointB = Point3D(9, 8, 1)

        val result = euclidianDistance(pointA, pointB)

        assertThat(result).isBetween(7.34846, 7.34847)
    }
}