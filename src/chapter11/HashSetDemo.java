package chapter11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
  public static void main(String[] args) {
    Set<String> set = Set.of("A","B","C","D","E");
    HashSet<String> hashSet = new HashSet<>(set);
//    set.add("F"); //불변(imutable)객체 - 에러
    hashSet.add("F");
    Iterator<String> iterator = hashSet.iterator();
    while (iterator.hasNext()){
      System.out.print(iterator.next());
    }
    System.out.println();
    System.out.println(set);
    System.out.println(hashSet);


    boolean e = hashSet.add("E");
    if (!e) System.out.println("추가 못함");

//    boolean isExist = false;
//    for (String ele : hashSet){
//      if(ele.hashCode() == "F".hashCode()){
//        isExist = true;
//        break;
//      }
//    }
//    if(!isExist) hashSet.add("F");
    if(!isExist(hashSet, "F")) hashSet.add("F");
    else System.out.println("F가 이미 존재하여 추가할 수 없음");

    System.out.println("\"E\".hashCode() = " + "E".hashCode());
    System.out.println("\"F\".hashCode() = " + "F".hashCode());

//    isExist = false;
//    for (String ele : hashSet){
//      if(ele.hashCode() == "G".hashCode()){
//        isExist = true;
//        break;
//      }
//    }
//    if(!isExist) hashSet.add("G");
    if(!isExist(hashSet, "G")) hashSet.add("G");
    else System.out.println("G가 이미 존재하여 추가할 수 없음");

  }
  static <T> boolean isExist(Set<T> set, T obj){ //반복 - 함수화
    boolean isExist = false;
    for (T ele : set){
      if(ele.hashCode() == "F".hashCode()){
        isExist = true;
        break;
      }
    }
    return isExist;
  }
}
