package accounting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlHelper {
  
  public static Connection getMysqlConnection(final String database,
                                              String userName,
                                              String password)
    throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.jdbc.Driver");
    //Class.forName("oracle.jdbc.OracleDriver");
    
    String url = "jdbc:mysql://localhost:3306/" + database;
    Connection con = DriverManager.getConnection(url, userName, password);
    return con;
  }

}
