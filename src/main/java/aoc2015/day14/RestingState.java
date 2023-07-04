package aoc2015.day14;

public class RestingState extends ReindeerState {

    public RestingState(Reindeer reindeer) {
        super(reindeer, reindeer.getRestTime());
    }

    @Override
    public void tick() {
        timeLeftInState--;
        if (timeLeftInState <= 0) {
            this.reindeer.changeState(new FlyingState(reindeer));
        }
    }
}
