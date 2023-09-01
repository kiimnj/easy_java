package chapter14;

public class ThreadDemo1 {
  public static void main(String[] args) {
    Thread thread = new Thread(new MyRunnable());
//    thread.run(); //멀티가 아닌 순차 처리
    thread.start(); //멀티 스레드 - 병렬 처리

    for (int i = 0; i < 5; i++) {
      System.out.print("main 입니다. ");
      System.out.println("안녕!");
      try {
        Thread.sleep(500); //sleep - throws InterruptedException : try-catch 혹은 throw
      } catch (InterruptedException e) {}
    }
  }
}
 class MyRunnable implements Runnable { //Runnable - @Functional InterFace
   @Override
   public void run() {
     for (int i = 0; i < 5; i++) {
       System.out.println("안녕!");
       try {
         Thread.sleep(500); //sleep - throws InterruptedException : try-catch 혹은 throw
       } catch (InterruptedException e) {}
     }
   }
 }