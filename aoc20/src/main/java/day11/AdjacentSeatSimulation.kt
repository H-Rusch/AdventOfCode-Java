package day11

import util.grid.Point

class AdjacentSeatSimulation(seats: Set<Point>) : SeatSimulation(seats) {

    override fun handleEmpty(nextOccupied: MutableSet<Point>, nextEmpty: MutableSet<Point>) {
        for (seat in emptySeats) {
            if (seat.allAdjacent().none { occupiedSeats.contains(it) }) {
                nextOccupied.add(seat)
            } else {
                nextEmpty.add(seat)
            }
        }
    }

    override fun handleOccupied(nextOccupied: MutableSet<Point>, nextEmpty: MutableSet<Point>) {
        for (seat in occupiedSeats) {
            if (seat.allAdjacent().count { occupiedSeats.contains(it) } >= 4) {
                nextEmpty.add(seat)
            } else {
                nextOccupied.add(seat)
            }
        }
    }
}