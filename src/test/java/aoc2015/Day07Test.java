package aoc2015;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    private String loadExampleInput() {
        Path file = Paths.get("src/main/resources/examples/2015/day07.txt");

        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void part1Test() {
        var day = new Day07();
        String exampleInput = loadExampleInput();

        day.buildTree(exampleInput);

        assertEquals(72, day.calculateValueForNode("d"));
        assertEquals(507, day.calculateValueForNode("e"));
        assertEquals(492, day.calculateValueForNode("f"));
        assertEquals(114, day.calculateValueForNode("g"));
        assertEquals(65412, day.calculateValueForNode("h"));
        assertEquals(65079, day.calculateValueForNode("i"));
        assertEquals(123, day.calculateValueForNode("x"));
        assertEquals(456, day.calculateValueForNode("y"));
    }
}
