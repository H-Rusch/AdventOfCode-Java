package day03

enum class Tile {

    TREE,
    EMPTY;

    companion object {
        fun from(char: Char): Tile {
            return when (char) {
                '#' -> TREE
                '.' -> EMPTY
                else -> throw RuntimeException("Unexpected input when parsing Tile {$char}")
            }
        }
    }
}