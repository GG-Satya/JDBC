import java.sql.*;
import java.io.*;

class DynamicPreaparedStatement {
	public static void main(String[] args)throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try{

		Class.forName("org.postgresql.Driver");

		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","postgres","tiger");

		String q = "INSERT into student(id,name) values(?,?)";

		pstmt = conn.prepareStatement(q);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter student id: ");
		int id = Integer.parseInt(br.readLine());

		System.out.println("Enter student name: ");
		String name = br.readLine();

		pstmt.setInt(1,id);
		pstmt.setString(2,name);

		pstmt.executeUpdate();
		System.out.println("Sucessfully Inserted... ");
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
	}
}