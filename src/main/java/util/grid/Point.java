package util.grid;

public record Point(int x, int y) {

    public Point move(Direction dir) {
        return switch (dir) {
            case UP -> new Point(this.x, this.y - 1);
            case DOWN -> new Point(this.x, this.y + 1);
            case LEFT -> new Point(this.x - 1, this.y);
            case RIGHT -> new Point(this.x + 1, this.y);
        };
    }
}
