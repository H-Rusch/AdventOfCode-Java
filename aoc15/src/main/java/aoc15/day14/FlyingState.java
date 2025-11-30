package aoc15.day14;

public class FlyingState extends ReindeerState {

  public FlyingState(Reindeer reindeer) {
    super(reindeer, reindeer.getFlyingLimit());
  }

  @Override
  public void tick() {
    reindeer.fly();

    timeLeftInState--;
    if (timeLeftInState <= 0) {
      this.reindeer.changeState(new RestingState(reindeer));
    }
  }
}
