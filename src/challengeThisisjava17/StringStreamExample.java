package challengeThisisjava17;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringStreamExample {
  public static void main(String[] args) {
    List<String> list = Arrays.asList(
        "This is a java book",
        "Lambda Expressions",
        "Java8 supports lambda expressions"
    );
    list.stream()
        .map(x -> x.toLowerCase())
//        .filter(x -> x.toLowerCase().contains("java"))
        .forEach(System.out::println);
  }
}