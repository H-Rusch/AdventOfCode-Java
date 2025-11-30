package aoc15.day11.requirements;

import java.util.Set;

public class NotContainSelectedLettersRequirement implements PasswordRequirement {

  private final Set<Character> forbiddenChars = Set.of('l', 'i', 'o');

  @Override
  public boolean matches(String password) {
    for (int i = 0; i < password.length(); i++) {
      if (forbiddenChars.contains(password.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
