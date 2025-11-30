package aoc15.day11.requirements;

import java.util.HashSet;
import java.util.Set;

public class ContainTwoPairRequirement implements PasswordRequirement {

  @Override
  public boolean matches(String password) {
    Set<Character> pairChars = new HashSet<>();

    for (int i = 0; i < password.length() - 1; i++) {
      if (password.charAt(i) == password.charAt(i + 1)) {
        pairChars.add(password.charAt(i));
      }
    }

    return pairChars.size() >= 2;
  }
}
