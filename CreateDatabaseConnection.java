import java.sql.*;

class CreateDatabaseConnection {

	public static void main(String[] args){

	   	try{
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/demo";

			String username = "postgres";

			String pass = "tiger";

			Connection conn = DriverManager.getConnection(url,username,pass);

			if(conn.isClosed()){

				System.out.println("Connection is closed");

			}else{

				System.out.println("Hurrey !!!, Connection established");

				conn.close();
			}
 
	    	}catch(Exception e){

			e.printStackTrace();
		}	
	}
}