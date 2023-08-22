package chapter08;

public class StringBuilderDemo {
  public static void main(String[] args) {
    String s = new String("hi");
    System.out.println(s); //이미 toString()구현됨 - 값 출력

    System.out.println(s.hashCode()); //주소 출력
    s = s + "!";
    System.out.println(s.hashCode()); //주소가 다르므로 변환X, 새 객체 생성 - 불변

    //java.lang 패키지 사용해보기
    StringBuilder sb = new StringBuilder("hi");
    System.out.println(sb.hashCode());
    sb = sb.append("!");
    System.out.println(sb.hashCode()); //주소 동일- 변환ㅇ
    System.out.println(sb.capacity()); //버퍼값 = 문자열 길이
    //replace - end는 포함 안함
  }
}
