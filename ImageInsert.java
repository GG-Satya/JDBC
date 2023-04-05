import java.sql.*;
import java.io.*;

public class ImageInsert
{
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","postgres","tiger");

			String q = "INSERT INTO images(pic) values(?)";

			pstmt = conn.prepareStatement(q);

			FileInputStream fis = new FileInputStream("C:/Users/Satyaprasanna Dsah/Downloads/my_profile.jpg");

			pstmt.setBinaryStream(1,fis,fis.available());

			pstmt.executeUpdate();

			System.out.println("Image inserted sucessfully...");

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}