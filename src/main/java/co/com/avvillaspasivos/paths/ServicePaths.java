/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.paths;

import co.com.avvillaspasivos.data.Environment;
import co.com.avvillaspasivos.data.EnvironmentProperties;
import org.aeonbits.owner.ConfigFactory;

public class ServicePaths {
  private ServicePaths() {
    throw new IllegalStateException("Utility class");
  }

  private static Environment environment;

  private static final String BASE_ENDPOINT = "api.baseurl";

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  public static String getEndPointBase() {
    return EnvironmentProperties.getProperty(BASE_ENDPOINT);
  }
  public static String getEndPointBaseMasivian() {

    return "http://athqa.estratec.com.co/Account/Login";
  }

  public static String pathIdentificationProject() {
    return environment.identificationProject();
  }

  public static String pathMasivian(String telefono,String anio,String mes,String dia) {
      String path="%2FSimpleSearch%2FSearchEmailAndCelular%3Fvalor%3D57"+
      telefono+"%26type%3D2%26inicio%3D"+
          anio+"%252F"+mes+"%252F"+dia+"%26fin%3D"+anio+"%252F"+mes+"%252F"+dia+"%26celType%3DMT%26_%3D1580930637721";
    return path;
  }

  public static String passOracle() {
    return environment.psworacle();
  }

  public static String pathCustomerConditions() {
    return pathIdentificationProject().concat(environment.customerConditions());
  }
  public static String pathUserIdentity() {
    return pathIdentificationProject().concat(environment.userIdentity());
  }
}
