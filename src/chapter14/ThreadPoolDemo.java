package chapter14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
  public static void main(String[] args) {
    Runnable task = () -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("안녕~");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}
      }
    };

    ExecutorService ex = Executors.newFixedThreadPool(4);
    ex.submit(task);

    for (int i = 0; i < 5; i++) {
      System.out.println("main 입니다. 안녕~");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}
    }

    ex.shutdown();
  }
}