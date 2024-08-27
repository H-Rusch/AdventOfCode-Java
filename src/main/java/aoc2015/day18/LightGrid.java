package aoc2015.day18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.grid.Bounds;
import util.grid.Point;

public class LightGrid {

  private Bounds bounds;
  private Set<Point> litPoints;
  private Set<Point> nextLitPoints;
  private final boolean edgesAlwaysOn;

  public LightGrid(String input, boolean edgesAlwaysOn) {
    this.edgesAlwaysOn = edgesAlwaysOn;
    this.litPoints = new HashSet<>();
    parseInputToLitPoints(input);
  }

  public int countLitLights() {
    return litPoints.size();
  }

  public void simulation(int steps) {
    for (int i = 0; i < steps; i++) {
      simulation();
    }
  }

  private void simulation() {
    this.nextLitPoints = new HashSet<>();
    for (int y = bounds.minY(); y <= bounds.maxY(); y++) {
      for (int x = bounds.minX(); x <= bounds.maxX(); x++) {
        var point = new Point(x, y);
        var adjacentLit = countAdjacentLitLights(point);
        transformPoint(point, adjacentLit);
      }
    }

    this.litPoints = nextLitPoints;
    activateEdges();
  }

  private long countAdjacentLitLights(Point point) {
    var adjacent = bounds.filterInBounds(point.allAdjacent().stream());
    return adjacent.filter(p -> litPoints.contains(p)).count();
  }

  private void transformPoint(Point point, long adjacentLit) {
    if (litPoints.contains(point)) {
      if (adjacentLit == 2 || adjacentLit == 3) {
        nextLitPoints.add(point);
      }
    } else {
      if (adjacentLit == 3) {
        nextLitPoints.add(point);
      }
    }
  }

  private void parseInputToLitPoints(String input) {
    var lines = input.lines().toList();
    for (int y = 0; y < lines.size(); y++) {
      var row = lines.get(y).toCharArray();
      for (int x = 0; x < row.length; x++) {
        if (row[x] == '#') {
          litPoints.add(new Point(x, y));
        }
      }
    }
    this.bounds = new Bounds(0, lines.getFirst().length() - 1, 0, lines.size() - 1);

    activateEdges();
  }

  private void activateEdges() {
    if (!edgesAlwaysOn) {
      return;
    }

    litPoints.addAll(List.of(
        new Point(bounds.minX(), bounds.minY()),
        new Point(bounds.maxX(), bounds.minY()),
        new Point(bounds.minX(), bounds.maxY()),
        new Point(bounds.maxX(), bounds.maxY())
    ));
  }
}
