/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GestionFechas {

  public String getCurrentDateWithFormat(String formato) {
    Date systeDate = getCurrentDate();
    return formatDate(formato, systeDate);
  }

  public Date getCurrentDate() {
    return Calendar.getInstance().getTime();
  }

  public String formatDate(String format, Date fecha) {
    SimpleDateFormat df = new SimpleDateFormat(format);
    return df.format(fecha);
  }
}
