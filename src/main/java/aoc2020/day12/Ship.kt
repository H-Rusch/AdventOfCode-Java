package aoc2020.day12

import util.grid.Direction
import util.grid.Point

class Ship {

    private var coordinate = Point(0, 0)
    private var direction = Direction.RIGHT

    fun executeCommand(command: Char, amount: Int) {
        when (command) {
            'N' -> coordinate = coordinate.move(Direction.UP, amount)
            'W' -> coordinate = coordinate.move(Direction.LEFT, amount)
            'S' -> coordinate = coordinate.move(Direction.DOWN, amount)
            'E' -> coordinate = coordinate.move(Direction.RIGHT, amount)
            'F' -> coordinate = coordinate.move(direction, amount)
            'L' -> repeat(amount / 90) { direction = direction.turnLeft() }
            'R' -> repeat(amount / 90) { direction = direction.turnRight() }
            else -> throw UnsupportedOperationException()
        }
    }

    fun distanceToStart(): Int = coordinate.manhattenDistance(Point(0, 0))
}