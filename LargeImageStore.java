import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LargeImageStore {
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	
	public static void main(String[] args) {
		if(conn == null) {
			try {
				Class.forName("org.postgresql.Driver");

				Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demo","postgres","tiger");

				String q = "INSERT INTO images(pic) values(?)";

				pstmt = conn.prepareStatement(q);
				
				JFileChooser jfc = new JFileChooser(); // gives a gui screen to choose image
				jfc.showOpenDialog(null);
				File file =jfc.getSelectedFile();
				FileInputStream fis = new FileInputStream(file);
				
				pstmt.setBinaryStream(1, fis, fis.available());
				pstmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Sucess"); // pop up message on screen

			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null)conn.close();
					if(pstmt != null) pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
