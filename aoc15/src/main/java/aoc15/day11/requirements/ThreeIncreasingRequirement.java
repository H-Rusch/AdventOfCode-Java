package aoc15.day11.requirements;

public class ThreeIncreasingRequirement implements PasswordRequirement {

  @Override
  public boolean matches(String password) {
    for (int i = 0; i < password.length() - 3; i++) {
      if (password.charAt(i) == password.charAt(i + 1) - 1 &&
          password.charAt(i + 1) == password.charAt(i + 2) - 1) {
        return true;
      }
    }
    return false;
  }
}
