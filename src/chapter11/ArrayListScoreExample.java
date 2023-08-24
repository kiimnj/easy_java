//package chapter11;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Scanner;
//
//public class ArrayListScoreExample {
//  public static void main(String[] args) {
//    ArrayList<Integer> scores = new ArrayList<>();
//
//    System.out.println("점수 입력 : ");
//    Scanner in = new Scanner(System.in);
//    while (true){
//      scores.add(in.nextInt());
//      if (scores.get(scores.size()-1) < 0){ //입력을 변수로 받고 if-break을 add 전에
//        scores.remove(scores.size());
//        break;
//      }
//    }
//
//    ArrayList<String> grades = new ArrayList<>(); //따로 구현하지 않고 print만 다르게 해도 됨
//    Iterator<Integer> iterator = scores.iterator();
//    while (iterator.hasNext()) { //maxScore함수 구현 - sort 후 마지막값
//      if (iterator.next() > scores.~~ - 10) grades.add("A");
//      else if (iterator.next() > scores.~~ - 20) grades.add("B");
//      else grades.add("C");
//    }
//
//    System.out.println("전체 학생은 " + scores.size() + "명이다.");
//    System.out.println("학생들의 성적 : ");
//    iterator = scores.iterator();
//    while (iterator.hasNext()) {
//      System.out.print(iterator.next() + " ");
//    }
//
//    int i = 0;
//    iterator = scores.iterator();
//    while (iterator.hasNext()) {
//      System.out.println(i + "번 학생의 성적은 " + iterator.next() + "점이며 등급은" + "이다.");
//      i++;
//    }
//  }
//}
