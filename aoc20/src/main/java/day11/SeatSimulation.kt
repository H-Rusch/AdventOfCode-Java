package day11

import util.grid.Point

abstract class SeatSimulation(seats: Set<Point>) {

    protected var emptySeats: Set<Point> = seats
    protected var occupiedSeats: Set<Point> = setOf()

    fun runSimulation(): Int {
        do {
            val previousEmpty = emptySeats
            val previousOccupied = occupiedSeats

            simulate()
        } while (previousEmpty != emptySeats || previousOccupied != occupiedSeats)

        return occupiedSeats.size
    }

    private fun simulate() {
        val nextEmpty = mutableSetOf<Point>()
        val nextOccupied = mutableSetOf<Point>()

        handleEmpty(nextOccupied, nextEmpty)
        handleOccupied(nextOccupied, nextEmpty)

        emptySeats = nextEmpty
        occupiedSeats = nextOccupied
    }

    protected abstract fun handleEmpty(
        nextOccupied: MutableSet<Point>,
        nextEmpty: MutableSet<Point>
    )

    protected abstract fun handleOccupied(
        nextOccupied: MutableSet<Point>,
        nextEmpty: MutableSet<Point>
    )
}