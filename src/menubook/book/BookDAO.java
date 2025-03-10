package menubook.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BookDAO {

	private Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/madangdb";
	private String user = "madang";
	private String password = "madang1234";

	public BookDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
	}

	public void close() throws SQLException {
		con.close();
	} // close

	public Vector<Vector<String>> readAll() throws SQLException {
		String sqlSelectAll = "SELECT * FROM BOOK";

		Vector<Vector<String>> list = new Vector<Vector<String>>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlSelectAll);
		while(rs.next()) {
			Vector<String> obj = new Vector<String>();
			obj.add( rs.getString("bookid") );
			obj.add( rs.getString("bookname") );
			obj.add( rs.getString("publisher") );
			obj.add( rs.getString("price") );
			list.add(obj);
		} // while
		rs.close();
		stmt.close();

		return list;
	} // readAll

	public int insertOne(String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;
		String sqlInsertOne = "INSERT INTO book(bookname, publisher, price) VALUES(?,?,?)";

		PreparedStatement psmt = con.prepareStatement(sqlInsertOne);
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // insertOne

	public int updateOne(String selectedBookID, String bookname, String publisher, String price) throws SQLException {
		int successCnt = 0;
		String sqlUpdateOne = "UPDATE book SET bookname=?, publisher=?, price=? WHERE bookid=?";

		PreparedStatement psmt = con.prepareStatement(sqlUpdateOne);
		psmt.setString(1, bookname);
		psmt.setString(2, publisher);
		psmt.setString(3, price);
		psmt.setString(4, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // updateOne

	public int deleteOne(String selectedBookID) throws SQLException {
		int successCnt = 0;
		String sqlDeleteOne = "DELETE FROM book WHERE bookid=?";

		PreparedStatement psmt = con.prepareStatement(sqlDeleteOne);
		psmt.setString(1, selectedBookID);
		successCnt = psmt.executeUpdate();
		psmt.close();

		return successCnt;
	} // deleteOne

} // class
