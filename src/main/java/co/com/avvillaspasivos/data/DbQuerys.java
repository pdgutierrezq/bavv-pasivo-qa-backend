package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.dataconnect.DbConnect;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbQuerys {
  private Connection connection = null;
  private PreparedStatement pstm = null;
  private ResultSet rs = null;
  String xmlResponse = "";

  @SneakyThrows
  public void execQueryGeneric(String param, String sqlQuery) {
    connection = DbConnect.getConnectionToOracle();
    pstm = connection.prepareStatement(sqlQuery);
    pstm.setString(1, param);
    rs = pstm.executeQuery();
  }

  @SneakyThrows
  public void execQueryGeneric(String sqlQuery) {
    connection = DbConnect.getConnectionToOracle();
    pstm = connection.prepareStatement(sqlQuery);
    rs = pstm.executeQuery();
  }

  @SneakyThrows
  public void execQueryGeneric(String sqlQuery, String param1, String param2, String param3) {

    connection = DbConnect.getConnectionToOracle();
    pstm = connection.prepareStatement(sqlQuery);
    pstm.setString(1, param1);
    pstm.setString(2, param2);
    pstm.setString(3, param3);
    rs = pstm.executeQuery();
  }

  @SneakyThrows
  public String getXmlOtp() {
    String sqlQuery =
        "SELECT * FROM ORA12IIB10.MESSAGE_LOG "
            + "WHERE 1=1 "
            + "AND MESSAGE_DATE BETWEEN TO_DATE('10/02/2020 13:00:00', 'DD/MM/YYYY HH24:MI:SS') "
            + "AND TO_DATE('10/02/2020 15:00:00','DD/MM/YYYY HH24:MI:SS') "
            + "AND OPERATION_NAME LIKE '%FRq_SendNotifications%' "
            + "AND SERVICE_NAME LIKE '%MBNotifications%' "
            + "AND BANKID LIKE '%00010524%' "
            + "AND REF3 LIKE '573112452187' "
            + "ORDER BY MESSAGE_DATE DESC";

    try {
      execQueryGeneric(sqlQuery);
      while (rs.next()) {
        xmlResponse = rs.getString(10);
      }
    } finally {
      DbConnect.closeConnection(connection);
    }
    return xmlResponse;
  }

  @SneakyThrows
  public String getXmlOtpP(String numCel) {

    String sqlQuery =
        "SELECT * FROM ORA12IIB10.MESSAGE_LOG "
            + "WHERE 1=1 "
            + "AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS') "
            + "AND TO_DATE(?,'DD/MM/YYYY HH24:MI:SS') "
            + "AND OPERATION_NAME LIKE '%FRq_SendNotifications%' "
            + "AND SERVICE_NAME LIKE '%MBNotifications%' "
            + "AND BANKID LIKE '%00010524%' "
            + "AND REF3 LIKE '57?' "
            + "ORDER BY MESSAGE_DATE DESC";

    try {
      execQueryGeneric(sqlQuery);
      while (rs.next()) {
        xmlResponse = rs.getString(10);
      }
    } finally {
      DbConnect.closeConnection(connection);
    }
    return xmlResponse;
  }
}
