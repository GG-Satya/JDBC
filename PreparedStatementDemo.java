import java.sql.*;
public class PreparedStatementDemo{
	public static void main(String[] args){

		try{
			// Load the driver
			Class.forName("org.postgresql.Driver");
		
			// Establish Connection
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","postgres","tiger");
		
			String q = "INSERT into student(id,name) values(?,?)";
		
			// get PreparedStatemenet object by passing query
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			pstmt.setString(2,"satya");
			pstmt.setInt(1,101);

			pstmt.executeUpdate();

			System.out.println("Sucessfully Inserted into table");
		
			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}