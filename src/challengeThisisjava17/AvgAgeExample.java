package challengeThisisjava17;

import java.util.Arrays;
import java.util.List;

public class AvgAgeExample {
  public static void main(String[] args) {
    List<Member> list = Arrays.asList(
        new Member("홍길동", 30),
        new Member("신용권", 40),

        new Member("감자바", 26)
    );
    double avg = list.stream()
        .mapToInt(x -> x.getAge())
        .average()
        .getAsDouble(); //옵셔널타입이기 때문

    System.out.println("평균 나이: " + avg);
  }
}
