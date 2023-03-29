import java.sql.*;
class CreateTable{
	
	public static void main(String[] args){
		try{
			Class.forName("org.postgresql.Driver");

			Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demo","postgres","tiger");

			if(!conn.isClosed()) System.out.println("Hurrey !!!, Connection established...");

			String q = "CREATE table student(id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL)";

			Statement stmt = conn.createStatement();

			stmt.executeUpdate(q);
 
			System.out.println("Table Created Sucessfully");
			conn.close();
	    	}catch(Exception e){

			e.printStackTrace();
		}	
	}
}