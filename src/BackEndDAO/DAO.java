package BackEndDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.jdbc.CommunicationsException;

import Excepciones.ErrorConexion;


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
            return DriverManager.getConnection(driver+"://"+host+":"+port+"/"+db, user, passwd);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al interpretar properties.json");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo de configuracion properties.json no existe");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de E/S de properties.json");            
            e.printStackTrace();
        } catch (CommunicationsException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con: "+host);
            //throw new ErrorConexion("Error al conectar con: "+host);
        }
        return null;
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
            e.printStackTrace();
        }
    }

}
