package challengeThisisjava17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JobFilterExample {
  public static void main(String[] args) {
    List<Member> list = Arrays.asList(
        new Member("홍길동", "개발자"),
        new Member("김나리", "디자이너"),
        new Member("신용권", "개발자")
    );
    List<Member> developers = list.stream()
        .filter(x -> x.getJob().equals("개발자"))
        .collect(Collectors.toList()); //그냥 .toList()도 가능

    developers
        .stream()
        .forEach(m -> System.out.println(m.getName()));
  }
}
