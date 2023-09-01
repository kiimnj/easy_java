package chapter14;

public class ThreadDemo4 {
  public static void main(String[] args) {
    //익명객체
    Thread thread = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500); //sleep - throws InterruptedException : try-catch 혹은 throw
          } catch (InterruptedException e) {}
        }
      }
    };
    thread.start();

    //람다식
    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("안녕!");
        try {
          Thread.sleep(500); //sleep - throws InterruptedException : try-catch 혹은 throw
        } catch (InterruptedException e) {}
      }
    }).start();

    for (int i = 0; i < 5; i++) {
      System.out.print("main 입니다. ");
      System.out.println("안녕!");
      try {
        Thread.sleep(500); //sleep - throws InterruptedException : try-catch 혹은 throw
      } catch (InterruptedException e) {}
    }
  }
}