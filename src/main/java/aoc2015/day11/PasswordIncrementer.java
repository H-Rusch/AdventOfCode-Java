package aoc2015.day11;

import java.util.HashMap;
import java.util.Map;

class PasswordIncrementer {

  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  private final Map<Character, Character> incrementsTo;
  private final char[] password;

  public PasswordIncrementer(String password) {
    this.incrementsTo = createIncrementsMap();
    this.password = password.toCharArray();
  }

  private Map<Character, Character> createIncrementsMap() {
    var map = new HashMap<Character, Character>();
    char[] chars = ALPHABET.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], chars[(i + 1) % chars.length]);
    }

    return map;
  }

  public void incrementPassword() {
    int index = password.length - 1;
    while (index >= 0) {
      password[index] = incrementsTo.get(password[index]);

      if (password[index] != 'a') {
        break;
      }
      index--;
    }
  }

  public String getPassword() {
    return String.valueOf(password);
  }
}
