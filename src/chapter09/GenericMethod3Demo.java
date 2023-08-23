package chapter09;

public class GenericMethod3Demo {
  public static void main(String[] args) {
    Ticket[] ta = {
        new Ticket(5),
        new Ticket(3),
        new Ticket(10),
        new Ticket(7),
        new Ticket(4)
    };
    System.out.println(countGT(ta, ta[4]));
  }
  static <T extends Comparable> int countGT(T[] ta, T t){
    int count = 0;
    for(T one : ta){
      if(one.compareTo(t) > 0){
        count++;
      }
    }
    return count;
  }
}

class Ticket implements Comparable<Ticket>{
  int no;
  public Ticket(int no){
    this.no = no;
  }

  @Override
  public int compareTo(Ticket ticket) {
    if(ticket != null){
      return this.no - ticket.no;
    }
    return 0;
  }
}