/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.data;

import co.com.bavv.old.dataconnect.DbConnect;
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
  public String getXmlOtp(String phone) {
    String sqlQuery =
        "SELECT * FROM ORA12IIB10.MESSAGE_LOG "
            + "WHERE  MESSAGE_DATE BETWEEN TO_DATE(TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY')||' 00:00:00','DD/MM/YYYY HH24:MI:SS')\n"
            + "AND TO_DATE(TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY')||' 23:00:00','DD/MM/YYYY HH24:MI:SS')\n"
            + "AND OPERATION_NAME LIKE '%FRq_SendNotifications%' "
            + "AND SERVICE_NAME LIKE '%MBNotifications%' "
            + "AND BANKID LIKE '%00010524%' "
            + "AND REF3 LIKE '57'||? "
            +"AND ROWNUM=1"
            + "ORDER BY MESSAGE_DATE DESC";

    try {
      execQueryGeneric(phone,sqlQuery);
      while (rs.next()) {
        xmlResponse = rs.getString(10);
      }
    } finally {
      DbConnect.closeConnection(connection);
    }
    return xmlResponse;
  }

}
