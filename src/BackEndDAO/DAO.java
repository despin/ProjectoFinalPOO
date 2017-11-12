package BackEndDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DAO {
	private static String driver = null;
	private static String host = null;
	private static String port = null;
	private static String db = null;
	private static String user = null;
	private static String passwd = null;
	
	public static Connection conectar() throws SQLException {
        
		JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("properties.json"));

            JSONObject jsonObject = (JSONObject) obj;
            driver = (String) jsonObject.get("driver");
            host = (String) jsonObject.get("host");
            port = (String) jsonObject.get("port");
            db = (String) jsonObject.get("db");
            user = (String) jsonObject.get("user");
            passwd = (String) jsonObject.get("passwd");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return DriverManager.getConnection(driver+"://"+host+":"+port+"/"+db, user, passwd);
//0				"jdbc:mysqllocalhost:3306/supermercado?user=root&password=admin");
	}

	public void close(Connection connect, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    public void close(Connection connect, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
