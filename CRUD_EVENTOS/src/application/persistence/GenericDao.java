package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	private Connection c;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String hostName = "localhost";
		String dbName = "teste_CRUD2";
		String user = "Larissa";
		String senha = "1234567";
		
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
		c = 
	    DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/crudEventos;instance=sqlexpress;user=Larissa;password=1234567");

		return c;
	}
}


