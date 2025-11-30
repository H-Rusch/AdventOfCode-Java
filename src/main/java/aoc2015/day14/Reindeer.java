package aoc2015.day14;

import java.util.List;
import java.util.regex.Pattern;
import lombok.Getter;
import util.regex.RegexHelper;

public class Reindeer {

  private static final Pattern REINDEER_DESCRIPTION = Pattern.compile(
      "(.*?) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

  private final int speed;
  @Getter
  private final int flyingLimit;
  @Getter
  private final int restTime;
  @Getter
  private int distance;
  @Getter
  private int score;

  // seemed funny to try to implement the state pattern for this
  private ReindeerState state;

  public Reindeer(int speed, int flyingLimit, int restTime) {
    this.speed = speed;
    this.flyingLimit = flyingLimit;
    this.restTime = restTime;
    this.distance = 0;

    this.state = new FlyingState(this);
  }

  public static Reindeer fromString(String input) {
    List<String> groups = RegexHelper.getGroups(REINDEER_DESCRIPTION.matcher(input));

    return new Reindeer(
        Integer.parseInt(groups.get(2)),
        Integer.parseInt(groups.get(3)),
        Integer.parseInt(groups.get(4))
    );
  }

  public void tick() {
    state.tick();
  }

  public void changeState(ReindeerState state) {
    this.state = state;
  }

  public void fly() {
    this.distance += this.speed;
  }

  public void increaseScore() {
    this.score++;
  }
}
