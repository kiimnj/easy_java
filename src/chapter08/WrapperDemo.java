package chapter08;

public class WrapperDemo {
  public static void main(String[] args) {
//    Integer bi = new Integer(10); @Deprecated(since="9", forRemoval = true)
    Integer bi = Integer.valueOf(10);
    bi = 10; //자동 박싱
    float f = Float.parseFloat("3.14"); //자동 언박싱
//    int i = Integer.parseInt("3.14"); //3으로 넣어줘야 컴파일 에러가 나지 않음
  }
}
