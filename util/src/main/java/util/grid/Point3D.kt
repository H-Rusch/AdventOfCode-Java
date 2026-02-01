package util.grid

import kotlin.math.pow
import kotlin.math.sqrt

data class Point3D(val x: Int, val y: Int, val z: Int)

fun euclidianDistance(pointA: Point3D, pointB: Point3D): Double {
    val p = sequenceOf(pointA.x, pointA.y, pointA.z).map { it.toDouble() }
    val q = sequenceOf(pointB.x, pointB.y, pointB.z).map { it.toDouble() }

    return sqrt(
        p.zip(q)
        .map { (a, b) -> a - b }
        .map { it.pow(2.0) }
        .sum())
}

