package co.com.avvillaspasivos.dataconnect;

import co.com.avvillaspasivos.paths.ServicePaths;
import lombok.SneakyThrows;
import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
  private DbConnect() {
    throw new IllegalStateException("Utility class");
  }

  private static final String HOST = "10.130.4.182";
  private static final String PORT = "1528";
  private static final String SERVICE = "wsrrqa";
  private static final String USER = "CONSULTA";

  @SneakyThrows
  public static void closeConnection(Connection conn) {
    if (conn != null) {
      conn.close();
    }
  }

  public static Connection getConnectionToOracle() throws SQLException {
    DriverManager.registerDriver(new OracleDriver());
    String urlConnection = "jdbc:oracle:thin:@" + HOST + ":" + PORT + "/" + SERVICE;
    return DriverManager.getConnection(urlConnection, USER, ServicePaths.passOracle());
  }
}
