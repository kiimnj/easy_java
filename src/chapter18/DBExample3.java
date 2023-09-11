package chapter18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBExample3 {
  //Update
  //Delete시에는 FK부터 먼저 지우고 PK가 지워지도록 해야 에러 안남
  static Connection conn = DBConn.makeConnection();

  public static void main(String[] args) {
    if (conn != null) {
      while (true) {
        System.out.print("수정할 dbNum 입력 (1 updateBook, 2 updateCustomer, 3 updateOrder, -1 종료) : ");
        Scanner in = new Scanner(System.in);
        int dbNum = in.nextInt();

        if(dbNum < 0){
          System.out.println("프로그램 종료");
          break;
        }

        try {
          switch (dbNum) {
            case 1:
              updateBook();
              break;
            case 2:
              updateCustomer();
              break;
            case 3:
              updateOrder();
          }
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  static void updateBook() throws SQLException { //더 비개발자에게도 좋은 네이밍 ex changeBook
//    String sql = "insert into book (bookid, bookname, publisher, price) values (?, ?, ?, ?)";
    String sql = "insert into book values (?, ?, ?, ?)";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    Scanner in = new Scanner(System.in);

    String sql1 = "update book set price = ? where bookname = ?;";

    System.out.print("변경할 데이터의 bookname (String) : ");
    String bookname = in.next();

    System.out.print("변경할 price (String) : ");
    String price = in.next();

    PreparedStatement ps = conn.prepareStatement(sql1);
    ps.setString(1, bookname);
    ps.setString(2, price);

    boolean execute = ps.execute(); //변경여부
    if(!execute) System.out.println("수정 성공");
    else System.out.println("수정 실패");

    conn.close(); //접속 끊기
    preparedStatement.close(); //나오기
  }

  static void updateCustomer() throws SQLException {
    String sql = "insert into customer (custid, name, address, phone) values (?, ?, ?, ?)";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    Scanner in = new Scanner(System.in);

    String sql1 = "update customer set name = ? where phone = ?;";

    System.out.print("변경할 데이터의 name (String) : ");
    String name = in.next();

    System.out.print("변경할 phone (String) : ");
    String phone = in.next();

    PreparedStatement ps = conn.prepareStatement(sql1);
    ps.setString(1, name);
    ps.setString(2, phone);

    boolean execute = ps.execute(); //변경여부
    if(!execute) System.out.println("수정 성공");
    else System.out.println("수정 실패");

    conn.close(); //접속 끊기
    preparedStatement.close(); //나오기
  }

  static void updateOrder() throws SQLException {
    String sql = "insert into customer (orderid, custid, bookid, saleprice, orderdate) values (?, ?, ?, ?)";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    Scanner in = new Scanner(System.in);

    String sql1 = "update customer set name = ? where phone = ?;";

    System.out.print("변경할 데이터의 orderid (int) : ");
    int orderid = in.nextInt();

    System.out.print("변경할 saleprice (String) : ");
    String saleprice = in.next();


    PreparedStatement ps = conn.prepareStatement(sql1);
    ps.setInt(1, orderid);
    ps.setString(2, saleprice);

    boolean execute = ps.execute(); //변경여부
    if(!execute) System.out.println("수정 성공");
    else System.out.println("수정 실패");

    conn.close(); //접속 끊기
    preparedStatement.close(); //나오기
  }
}
