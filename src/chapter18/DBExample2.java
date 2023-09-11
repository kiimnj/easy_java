package chapter18;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBExample2 {
  //Create?(add) - 유효성 검사
  static Connection conn = DBConn.makeConnection();

  public static void main(String[] args) throws SQLException {
    if (conn != null) {
      while (true) {
        System.out.print("입력할 dbNum 입력 (1 addBook, 2 addCustomer, 3 addOrder, -1 종료) : ");
        Scanner in = new Scanner(System.in);
        int dbNum = in.nextInt();

        if(dbNum < 0){
          System.out.println("프로그램 종료");
          break;
        }

        try {
        switch (dbNum) {
          case 1:
            addBook();
            break;
          case 2:
            addCustomer();
            break;
          case 3:
            addOrder();
        }
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
  static void addBook() throws SQLException {
    Statement statement = conn.createStatement();
    Scanner in = new Scanner(System.in);

    System.out.print("bookid (int) : ");
    int bookid = in.nextInt();

    System.out.print("bookname (String) : ");
    String bookname = in.next();

    System.out.print("publisher (String) : ");
    String publisher = in.next();

    System.out.print("price (String) : ");
    String price = in.next();

    String sql = "insert into book (bookid, bookname, publisher, price) values ("
        + bookid + ", '"
        + bookname + "', '"
        + publisher + "', '"
        + price + "')";

    System.out.println("입력된 쿼리문 : " + sql);
    int i = statement.executeUpdate(sql); //비어있는 상태라서 sql 넘겨줌

    if(i == 1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    conn.close(); //접속 끊기
    statement.close(); //나오기
  }
  static void addCustomer() throws SQLException {
    Statement statement = conn.createStatement();
    Scanner in = new Scanner(System.in);

    System.out.print("custid (int) : ");
    int custid = in.nextInt();

    System.out.print("name (String) : ");
    String name = in.next();

    System.out.print("address (String) : ");
    String address = in.next();

    System.out.print("phone (String) : ");
    String phone = in.next();

    String sql = "insert into customer (custid, name, address, phone) values ("
        + custid + ", '"
        + address + "', '"
        + address + "', '"
        + phone + "')";

    System.out.println("입력된 쿼리문 : " + sql);
    int i = statement.executeUpdate(sql); //비어있는 상태라서 sql 넘겨줌

    if(i == 1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    conn.close(); //접속 끊기
    statement.close(); //나오기
  }

  static void addOrder() throws SQLException { //validCustomer, Book 메서드 추가
    Statement statement = conn.createStatement();
    Scanner in = new Scanner(System.in);

    System.out.print("orderid (int) : ");
    int orderid = in.nextInt();

    System.out.print("custid (int) : ");
    int custid = in.nextInt();

    System.out.print("bookid (int) : ");
    int bookid = in.nextInt();

    System.out.print("saleprice (String) : ");
    String saleprice = in.next();

    System.out.print("orderdate (String) : ");
    String orderdate = in.next();

    String sql = "insert into customer (orderid, custid, bookid, saleprice, orderdate) values ("
        + orderid + ", '"
        + custid + ", '"
        + bookid + "', '"
        + saleprice + "', '"
        + orderdate + "')";

    System.out.println("입력된 쿼리문 : " + sql);
    int i = statement.executeUpdate(sql); //비어있는 상태라서 sql 넘겨줌

    if(i == 1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    conn.close(); //접속 끊기
    statement.close(); //나오기
  }
}
