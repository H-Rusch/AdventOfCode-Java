package util.grid;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction fromChar(char c) {
        return switch (c) {
            case '>' -> RIGHT;
            case '<' -> LEFT;
            case '^' -> UP;
            case 'v' -> DOWN;
            default -> null;
        };
    }
}
