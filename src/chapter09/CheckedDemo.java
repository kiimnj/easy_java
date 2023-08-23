package chapter09;

public class CheckedDemo {
  public static void main(String[] args) throws InterruptedException {
//    //1 내가 처리하는 로직 작성
//    try {
//      System.out.println("3초간 쉽니다.");
//      Thread.sleep(3000);
//      System.out.println("3초간 쉽니다."); //매우 긴 시간
//    } catch (InterruptedException e) { // 그동안 들어온 에러 처리
//      throw new RuntimeException(e);
//    }

    //2 throws InterruptedException - 메인-JVM에게 넘기기
    Thread.sleep(1000);
  }
}
