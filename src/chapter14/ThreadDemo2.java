package chapter14;

public class ThreadDemo2 {
  public static void main(String[] args) {
    //ver2 Demo1의 익명 객체 버전
     Thread thread = new Thread(new MyRunnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {}
        }
      }
    });
    thread.start();


    //ver3 변수로 생성 안하고 바로 start
    new Thread(new MyRunnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {}
        }
      }
    }).start();

    //ver4 람다식
    new Thread(() -> {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {}
      }
    }).start();


    for (int i = 0; i < 5; i++) {
      System.out.print("main 입니다. ");
      System.out.println("안녕!");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}
    }
  }
}