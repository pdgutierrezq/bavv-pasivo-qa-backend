/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

public class Util {
  private Util() {
    throw new IllegalStateException("Utility class");
  }

  public static String cleanMoneyFormat(String frontValue) {
    return frontValue.replace("$", "").replace(" ", "").replace(",", "").replace(".", "");
  }
}
