package day12

import util.grid.Direction
import util.grid.Point
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

class ShipWithWaypoint {

    private var ship = Point(0, 0)
    private var waypoint = Point(10, 1)

    fun executeCommand(command: Char, amount: Int) {
        when (command) {
            'N' -> waypoint = waypoint.move(Direction.DOWN, amount)
            'W' -> waypoint = waypoint.move(Direction.LEFT, amount)
            'S' -> waypoint = waypoint.move(Direction.UP, amount)
            'E' -> waypoint = waypoint.move(Direction.RIGHT, amount)
            'F' -> ship += waypoint * amount
            'L' -> waypoint = rotateLeft(amount)
            'R' -> waypoint = rotateRight(amount)
            else -> throw UnsupportedOperationException()
        }
    }

    fun distanceToStart(): Int = ship.manhattenDistance(Point(0, 0))

    private fun rotateLeft(amount: Int): Point {
        val degree = amount / 180.0 * PI

        val xNew = waypoint.x * cos(degree) - waypoint.y * sin(degree)
        val yNew = waypoint.y * cos(degree) + waypoint.x * sin(degree)

        return Point(xNew.roundToInt(), yNew.roundToInt())
    }

    private fun rotateRight(amount: Int): Point {
        val degree = amount / 180.0 * PI

        val xNew = waypoint.x * cos(degree) + waypoint.y * sin(degree)
        val yNew = waypoint.y * cos(degree) - waypoint.x * sin(degree)

        return Point(xNew.roundToInt(), yNew.roundToInt())
    }
}