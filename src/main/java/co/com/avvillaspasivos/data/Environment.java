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

  String users();

  String customerConditions();

  String userIdentity();

  String identificationProject();

  String psworacle();

  String iporacle();

  String pepPage();

  String productOfferingPage();
}
