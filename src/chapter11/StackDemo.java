package chapter11;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    System.out.println(stack.empty());

    stack.push("main");
    stack.push("add");
    stack.push("println");

    Iterator<String> iterator = stack.iterator();
    while (iterator.hasNext()){ //hasNext가 false이기 전까지
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();

    while (!stack.empty()){ //fori에서 stack.size를 범위로 두면 안됨
      System.out.println(stack); //toSting()구현됨
      stack.pop();
    }

    stack.add("vector");
    stack.add("list");
    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println(stack.pop() + "를 삭제함");
  }
}
