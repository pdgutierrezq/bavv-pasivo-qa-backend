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

import static co.com.avvillaspasivos.util.Constantes.AUX_ENV;
import static co.com.avvillaspasivos.util.Constantes.DEV_ENV;

public class ServicePaths {
  private ServicePaths() {
    throw new IllegalStateException("Utility class");
  }

  private static Environment environment;

  private static final String BASE_ENDPOINT = "api.baseurl";
  private static final String BASE_ENDPOINT_DEV = "api.baseurl.dev";
  private static final String BASE_ENDPOINT_STG = "api.baseurl.stg";
  private static final String BASE_ENDPOINT_AUX = "api.baseurl.aux";
  private static final String BASE_ENDPOINT_CUSTOMER_ACCOUNTS = "api.baseurl.ca";

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  public static String getEndPointBase() {
    return EnvironmentProperties.getProperty(BASE_ENDPOINT);
  }

  public static String getEndPointBase(String env) {
    String endPointBase = EnvironmentProperties.getProperty(BASE_ENDPOINT_STG);
    if (env.equals(DEV_ENV)) {
      endPointBase = EnvironmentProperties.getProperty(BASE_ENDPOINT_DEV);
    } else if (env.equals(AUX_ENV)) {
      endPointBase = EnvironmentProperties.getProperty(BASE_ENDPOINT_AUX);
    }
    return endPointBase;
  }

  public static String getAuxEndPointBase() {
    return EnvironmentProperties.getProperty(BASE_ENDPOINT_AUX);
  }

  public static String getCustomerAccountsEndPointBase() {
    return EnvironmentProperties.getProperty(BASE_ENDPOINT_CUSTOMER_ACCOUNTS);
  }

  public static String pathIdentificationProject() {
    return environment.identificationProject();
  }

  private static String pathjsonSchemaBaseDir() {
    return environment.jsonSchemaBaseDir();
  }

  public static String passOracle() {
    return environment.psworacle();
  }

  public static String jsonDatapath() {
    return environment.jsonData();
  }

  public static String jsonCountryCitiesDatapath() {
    return environment.countryCitiesData();
  }

  public static String jsonDominaCitiesDatapath() {
    return environment.dominaCitiesData();
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

  public static String pathCustomerAccounts() {
    return environment.customerAccounts();
  }

  public static String pathUserIdentity() {
    return pathIdentificationProject().concat(environment.userIdentity());
  }

  public static String pathCustAccountSchema() {
    return pathjsonSchemaBaseDir().concat(environment.custAccountSchema());
  }

  public static String pathPseGetBankListSchema() {
    return pathjsonSchemaBaseDir().concat(environment.pseListBankSchema());
  }

  public static String pathCustConditionsSchema() {
    return pathjsonSchemaBaseDir().concat(environment.custConditiosSchema());
  }

  public static String pathSstSchema() {
    return pathjsonSchemaBaseDir().concat(environment.sstSchema());
  }

  public static String pathGetPdfSchema() {
    return pathjsonSchemaBaseDir().concat(environment.getPdf());
  }

  public static String pathCppSchema() {
    return pathjsonSchemaBaseDir().concat(environment.cppSchema());
  }

  public static String pathClientAccountsSchema() {
    return pathjsonSchemaBaseDir().concat(environment.clientAccounts());
  }

  public static String pathGetChannelsSchema(boolean option) {
    String path = pathjsonSchemaBaseDir().concat(environment.getChannelsFalse());

    if (option) {
      path = pathjsonSchemaBaseDir().concat(environment.getChannelsTrue());
    }
    return path;
  }

  public static String pathGetRatesSchema() {
    return pathjsonSchemaBaseDir().concat(environment.getRates());
  }

  public static String declaringPagePath() {
    return environment.declaringPage();
  }

  public static String savingTipsPagePath() {
    return environment.savingTipsPage();
  }

  public static String channelEnrollmentPagePath() {
    return environment.channelEnrollmentPage();
  }

  public static String electronicSignaturePagePath() {
    return environment.electronicSignaturePage();
  }

  public static String pathCrmInfo() {
    return environment.crmInfo();
  }

  public static String pathCpp() {
    return environment.cpp();
  }
  public static String pathUpdateCrm() {
    return environment.updateCrm();
  }

  public static String pathSst() {
    return environment.sst();
  }

  public static String pathCustomerAccountsCdt() {
    return environment.customerAccountsCdt();
  }
}
