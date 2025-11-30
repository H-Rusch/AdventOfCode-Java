package aoc2015.day14;

public abstract class ReindeerState {

    int timeLeftInState;
    Reindeer reindeer;

    ReindeerState(Reindeer reindeer, int timeLeftInState) {
        this.reindeer = reindeer;
        this.timeLeftInState = timeLeftInState;
    }

    public abstract void tick();
}
