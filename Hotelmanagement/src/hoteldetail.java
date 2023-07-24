import java.sql.*;
public class hoteldetail {
	public void gettable()throws Exception {
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		
		Connection con = DriverManager.getConnection(url, name,pass);
		Statement st=con.createStatement();
		String Sql ="CREATE TABLE MENU"
				+ "(ID INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "MenuDishes VARCHAR(200),"
				+ "Price INTEGER)";
		st.executeUpdate(Sql);
	}
	public void getmenu()throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		String Sql = "insert into MENU VALUES(?,?,?)";
		Connection con = DriverManager.getConnection(url, name,pass);
		PreparedStatement pst = con.prepareStatement(Sql);
		pst.setInt(1,2);
		pst.setString(2,"SHAWARMA");
		pst.setInt(3,120);
		pst.executeUpdate();
	}
	public void updatemenu()throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		String Sql = "Update menu set MenuDishes =?,Price=? where ID=?";
		Connection con = DriverManager.getConnection(url, name,pass);
		PreparedStatement pst = con.prepareStatement(Sql);
		pst.setString(1,"PANIPURI");
		pst.setInt(2, 50);
		pst.setInt(3, 5);
		pst.executeUpdate();
	}
	public void deletemenu()throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		int ID=2;
		String Sql = "DELETE FROM menu where ID="
				+ ID;
		Connection con = DriverManager.getConnection(url, name,pass);
		PreparedStatement pst = con.prepareStatement(Sql);
		pst.executeUpdate(Sql);
		pst.close();
	}
	public void deleteallmenu()throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		String Sql = "drop table menu";
		Connection con = DriverManager.getConnection(url, name,pass);
		PreparedStatement pst = con.prepareStatement(Sql);
		pst.executeUpdate();
		pst.close();
	}
	public void selectmenu()throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/Hotel_Management";
		String name="root";
		String pass="1007";
		int ID=1;
		String Sql = "select * from menu where ID="
				+ ID;
		Connection con = DriverManager.getConnection(url, name,pass);
	    Statement st = (Statement)con.createStatement();
	    ResultSet rs= st.executeQuery(Sql);
	    while(rs.next()) {
	    	System.out.println("ID :"+rs.getInt(1));
	    	System.out.println("MENU :"+rs.getString(2));
	    	System.out.println("PRICE :"+rs.getInt(3));
	    }
	    
	}
}
