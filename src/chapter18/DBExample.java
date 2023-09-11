package chapter18;

import java.sql.*;
import java.util.Scanner;

public class DBExample {
  //Read
  static Connection conn = DBConn.makeConnection();

  public static void main(String[] args) throws SQLException{

//    Connection conn = makeConnection();

    System.out.print("받을 dbNum 입력 (1- bookList, 2- customerList, 3- orderList) : ");
    Scanner in = new Scanner(System.in);
    int dbNum = in.nextInt();


    // if(conn != null),while문 추가 &종료 -1,
    // static void ~~List() throws SQLexception {~~} 이용, try-catch
    // 칸 간격 일정하게
    switch (dbNum) {
      case 1:
        System.out.println("\nbookList");

        String sql = "select * from book";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) { //rs != null, getInt getString 구분
          System.out.print("bookid : " + rs.getString(1) + ", ");
          System.out.print("bookname : " + rs.getString(2) + ", ");
          System.out.print("publisher : " + rs.getString(3) + ", ");
          System.out.println("price : " + rs.getString(4));
        }

        conn.close(); //접속 끊기
        preparedStatement.close(); //나오기

        System.out.println("\n프로그램 종료");
        break;


      case 2:
        System.out.println("\ncustomerList");

        String sql2 = "select * from customer";
        PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
        ResultSet rs2 = preparedStatement2.executeQuery();

        while (rs2.next()) {
          System.out.print("custid : " + rs2.getString(1) + ", ");
          System.out.print("name : " + rs2.getString(2) + ", ");
          System.out.print("address : " + rs2.getString(3) + ", ");
          System.out.println("phone : " + rs2.getString(4));
        }

        conn.close(); //접속 끊기
        preparedStatement2.close(); //나오기

        System.out.println("\n프로그램 종료");
        break;


      case 3:
        System.out.println("\norderList");

        String sql3 = "select * from orders";
        PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
        ResultSet rs3 = preparedStatement3.executeQuery();

        while (rs3.next()) {
          System.out.print("orderid : " + rs3.getString(1) + ", ");
          System.out.print("custid : " + rs3.getString(2) + ", ");
          System.out.print("bookid : " + rs3.getString(3) + ", ");
          System.out.print("saleprice : " + rs3.getString(4) + ", ");
          System.out.println("orderdate : " + rs3.getString(5));
        }

        conn.close(); //접속 끊기
        preparedStatement3.close(); //나오기

        System.out.println("\n프로그램 종료");
        break;
    }
  }
}
