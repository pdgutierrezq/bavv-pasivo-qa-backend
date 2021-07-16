/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})
public interface Environment extends Config {

  String jsonData();

  String countryCitiesData();

  String dominaCitiesData();

  String users();

  String customerConditions();

  String insuranceValidationSchema();

  String userIdentity();

  String crmInfo();

  String cpp();

  String updateCrm();

  String sst();

  String customerAccountsCdt();

  String getPdf();

  String insuranceValidation();

  String cppSchema();

  String clientAccounts();

  String getChannelsFalse();

  String getChannelsTrue();

  String getRates();

  String identificationProject();

  String psworacle();

  String iporacle();

  String pepPage();

  String productOfferingPage();

  String accountPackagePath();

  String insuranceOffer();

  String otpPage();

  String deliveryAddressPage();

  String declaringPage();

  String electronicSignaturePage();

  String savingTipsPage();

  String channelEnrollmentPage();

  String customerAccounts();

  String jsonSchemaBaseDir();

  String custConditiosSchema();

  String sstSchema();

  String custAccountSchema();

  String pseListBankSchema();
}
