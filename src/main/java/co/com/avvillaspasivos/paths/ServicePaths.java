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

  public static String pathIdentificationProject() {
    return environment.identificationProject();
  }


  public static String passOracle() {
    return environment.psworacle();
  }
  public static String jsonDatapath() {
    return environment.jsonData();
  }
  public static String ipOracle() {
    return environment.iporacle();
  }
  public static String pepPagePath() {
    return environment.pepPage();
  }
  public static String otpPagePath() {
    return environment.otpPage();
  }
  public static String deliveryAddressPagePath() {
    return environment.deliveryAddressPage();
  }
  public static String productOfferingPath() {
    return environment.productOfferingPage();
  }
  public static String insuranceOfferPath() {
    return environment.insuranceOffer();
  }
  public static String accountPackagePath() {
    return environment.accountPackagePath();
  }

  public static String pathCustomerConditions() {
    return environment.customerConditions();
  }
  public static String pathUserIdentity() {
    return pathIdentificationProject().concat(environment.userIdentity());
  }

    public static String declaringPagePath() {
        return environment.declaringPage();

    }
    public static String savingTipsPagePath() {
        return environment.savingTipsPage();

    }
    public static String electronicSignaturePagePath() {
        return environment.electronicSignaturePage();

    }
}
