package chapter09;

import java.io.BufferedInputStream;

public class ExceptionHandlingDemo {
  public static void main(String[] args) {
    int i = 0;
    String s = null;
    //컨+알트+t - try catch
    try {
      s.length(); //여기서 에러 발생하면
      int res = 10 / i; //여기 실행 안하고 넘어감
    } catch (ArithmeticException e) {
//      throw new RuntimeException(e); // 자동완성으로 만들어진 코드
      System.out.println("0으로 나눌 수 없습니다.");
    } catch (NullPointerException e){
      System.out.println("문자열의 내용이 없습니다.");
    } catch (Exception e) { //범위가 더 큰 익셉션을 뒤에 배치
      System.out.println("예외가 발생했습니다.");
    } finally {
      System.out.println("프로그램을 종료합니다.");
    }

  }
}
