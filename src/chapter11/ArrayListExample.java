package chapter11;

import java.util.ArrayList;

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("갈매기");
    arrayList.add("나비");
    arrayList.add("다람쥐");
    arrayList.add("라마");
    arrayList.add("동물");
    for (String animal : arrayList){
      if(animal.length() == 2){
        System.out.println(animal);
      }
    }
  }
}
