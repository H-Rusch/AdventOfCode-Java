package day03

import util.grid.Point

class AreaMap(private val map: List<List<Tile>>) {

    fun getTile(point: Point): Tile {
        val adjustedX = point.x % map[point.y].size

        return map[point.y][adjustedX]
    }

    fun hasReachedBottom(point: Point): Boolean = point.y >= map.size
}