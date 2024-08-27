package util.grid

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    TOP_LEFT,
    TOP_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_RIGHT;

    fun turnRight(): Direction {
        return when (this) {
            UP -> RIGHT
            TOP_RIGHT -> BOTTOM_RIGHT
            RIGHT -> DOWN
            BOTTOM_RIGHT -> BOTTOM_LEFT
            DOWN -> LEFT
            BOTTOM_LEFT -> TOP_LEFT
            LEFT -> UP
            TOP_LEFT -> BOTTOM_RIGHT
        }
    }

    fun turnLeft(): Direction {
        return when (this) {
            UP -> LEFT
            TOP_RIGHT -> TOP_LEFT
            RIGHT -> UP
            BOTTOM_RIGHT -> TOP_RIGHT
            DOWN -> RIGHT
            BOTTOM_LEFT -> BOTTOM_RIGHT
            LEFT -> DOWN
            TOP_LEFT -> BOTTOM_LEFT
        }
    }

    companion object {
        fun fromChar(ch: Char): Direction {
            return when (ch.uppercaseChar()) {
                'U', '^' -> UP
                'R', '>' -> RIGHT
                'D', 'V' -> DOWN
                'L', '<' -> LEFT
                else -> throw UnsupportedOperationException("Could not generate a Direction from char $ch")
            }
        }
    }
}