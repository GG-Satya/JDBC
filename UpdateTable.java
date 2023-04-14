import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTable {
	private static Connection conn;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demo","postgres","tiger");
			String q = "UPDATE student set name=? WHERE id =?";
			pstmt = conn.prepareStatement(q);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the new Name :");
			String name = br.readLine();
			
			System.out.println("Enter the id:");
			int  id = Integer.parseInt(br.readLine());
			
			pstmt.setString(1,name);
			pstmt.setInt(2,id);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
				System.out.println("sucessfully closed connections...");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
