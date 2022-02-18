/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Report {
  private Report() {
    throw new IllegalStateException("Utility class");
  }

  public static final Logger LOGGER = LoggerFactory.getLogger(Report.class);

  public static void logListCompared(List<String> expected,List<String> actual){
      LOGGER.info("Expected list->");
      expected.forEach(LOGGER::info);
      LOGGER.info("Actual list->");
      actual.forEach(LOGGER::info);
  }
}
