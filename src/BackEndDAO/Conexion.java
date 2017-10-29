package BackEndDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/supermercado?"
                        + "user=root&password=habo123456");
	}

}
