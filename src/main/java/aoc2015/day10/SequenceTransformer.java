package aoc2015.day10;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import lombok.Getter;

public class SequenceTransformer {

    @Getter
    private String sequence;

    public SequenceTransformer(String sequence) {
        this.sequence = sequence;
    }

    public void transform() {
        StringBuilder newSequence = new StringBuilder();
        CharacterIterator iterator = new StringCharacterIterator(sequence);

        while (iterator.current() != CharacterIterator.DONE) {
            char current = iterator.current();
            newSequence.append(countSameLettersFromIndex(iterator))
                    .append(current);
        }

        this.sequence = newSequence.toString();
    }

    private int countSameLettersFromIndex(CharacterIterator iterator) {
        int count = 1;
        char current = iterator.current();

        while (iterator.next() == current) {
            count++;
        }

        return count;
    }
}
