/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static co.com.avvillaspasivos.util.Report.LOGGER;

public class DateManagement {

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

  public static boolean validateDate(Long dateExpected, String dateObtained) {
    Date dateMillisExpected = new Date(dateExpected);

    SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    Date obtained = null;

    try {
      obtained = formatter.parse(dateObtained);
    } catch (ParseException e) {
        LOGGER.error("Fail parsing obtained date->".concat(e.getMessage()));
    }

    return Objects.requireNonNull(obtained)
            .toInstant()
            .plusMillis(18000000)
            .compareTo(dateMillisExpected.toInstant())
        == 0;
  }
}
