package day11

import util.grid.Bounds
import util.grid.Direction
import util.grid.Point

class FirstSeenSeatSimulation(seats: Set<Point>) : SeatSimulation(seats) {

    private val bounds = Bounds(0, seats.maxOf { it.x }, 0, seats.maxOf { it.y })

    override fun handleEmpty(nextOccupied: MutableSet<Point>, nextEmpty: MutableSet<Point>) {
        emptySeats.forEach {
            val target = if (countOccupiedSeatsSeen(it) == 0) nextOccupied else nextEmpty
            target.add(it)
        }
    }

    override fun handleOccupied(nextOccupied: MutableSet<Point>, nextEmpty: MutableSet<Point>) {
        occupiedSeats.forEach {
            val target = if (countOccupiedSeatsSeen(it) >= 5) nextEmpty else nextOccupied
            target.add(it)
        }
    }

    private fun countOccupiedSeatsSeen(seat: Point): Int {
        return Direction.entries.count { seesOccupiedSeat(seat, it) }
    }

    private fun seesOccupiedSeat(seat: Point, direction: Direction): Boolean {
        var nextSeat = seat
        do {
            nextSeat = nextSeat.move(direction)
            if (occupiedSeats.contains(nextSeat)) {
                return true
            }
            if (emptySeats.contains(nextSeat)) {
                return false
            }
        } while (bounds.isInbound(nextSeat))

        return false
    }
}