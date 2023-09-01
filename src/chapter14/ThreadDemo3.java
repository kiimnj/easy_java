package chapter14;

public class ThreadDemo3 {
  public static void main(String[] args) {
    Thread thread = new MyThread();
    thread.start(); //멀티

    for (int i = 0; i < 5; i++) {
      System.out.print("main 입니다. ");
      System.out.println("안녕!");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}
    }
  }
}

class MyThread extends Thread { //앞 두 예제는 implements
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("안녕!");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}
    }
  }
}