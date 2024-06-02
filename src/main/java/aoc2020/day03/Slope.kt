package aoc2020.day03

import util.grid.Point

class Slope(private val right: Int, private val down: Int) {

    fun nextPoint(point: Point): Point = Point(point.x + right, point.y + down)
}