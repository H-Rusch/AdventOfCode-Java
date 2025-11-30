package util.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexHelper {

  public static List<String> getGroups(Matcher matcher) {
    List<String> list = new ArrayList<>(matcher.groupCount());
    if (matcher.matches()) {
      for (int i = 0; i <= matcher.groupCount(); i++) {
        list.add(matcher.group(i));
      }
    }

    return list;
  }
}
