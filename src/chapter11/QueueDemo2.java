package chapter11;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo2 {
  public static void main(String[] args) {
    Queue<String> q = new LinkedList<>();
    q.offer("바나나");
    q.offer("사과");
    q.offer("배");

    System.out.println(q.peek());
    while (!q.isEmpty()) {
      System.out.println(q.poll() + "가 삭제됨");
    }

    System.out.println(q.peek());
    System.out.println(q.poll());
  }
}
