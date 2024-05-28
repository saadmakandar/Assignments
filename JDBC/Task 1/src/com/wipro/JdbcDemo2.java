package com.wipro;
import java.sql.*;
import java.sql.DriverManager;

public class JdbcDemo2 {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
		System.out.println("Connection is Success");
		
		Statement st=con.createStatement();
		
	//	st.executeUpdate("create table products(id number primary key, name varchar2(20), price number)");
		System.out.println("Table is Created");
		
		//st.executeUpdate("insert into products values(4, 'bag', 1000)");
		//st.executeUpdate("insert into products values(5, 'book', 2000)");
		//st.executeUpdate("insert into products values(6, 'chair', 3500)");
		
		System.out.println("data inserted Successfully");
		
		System.out.println("after updating data");
		st.executeUpdate("update products set price = 4000 where id = 4");
		
		ResultSet rs=st.executeQuery("Select * from products");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}

}
