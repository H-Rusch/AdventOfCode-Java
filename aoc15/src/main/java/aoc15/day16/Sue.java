package aoc15.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.Getter;

@Getter
public class Sue {

  private static final Pattern FIELD_PATTERN = Pattern.compile("(\\w*?): (\\d+)");

  private final Map<String, Integer> fields = new HashMap<>();

  public static Sue fromString(String line) {
    Sue sue = new Sue();

    FIELD_PATTERN.matcher(line)
        .results()
        .map(r -> new String[]{r.group(1), r.group(2)})
        .forEach(arr -> sue.fields.put(arr[0], Integer.valueOf(arr[1])));

    return sue;
  }
}
