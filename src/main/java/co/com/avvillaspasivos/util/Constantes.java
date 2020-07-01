/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

public class Constantes {

  private Constantes() {
    throw new IllegalStateException("Utility class");
  }

  public static final String TEXT_MODAL_VER_MAS = "Conoce los beneficios que tenemos para ti";
  public static final String TEXTO_ERROR_PROCESO_PRINCIPAL =
      "Lo sentimos, no podemos continuar con tu solicitud";
  public static final String TEXTO_ERROR_PROCESO_SECUNDARIO =
      "Debes acercarte a una oficina AV Villas para abrir tu cuenta.";
  public static final String PATH_FORM_IDENTIFICACION = "user-identification";
  public static final String PATH_OFRECIMIENTO = "account-selection";
  public static final int MAX_WAIT = 60;
  public static final int MAX_WAIT_GET_PDF = 120;
  public static final int DB_WAIT = 3;
  public static final String TEXTO_SUPERIOR_LIMITE_TAMANIO = "sssssqqqqqwwwwweeeeeqqqqq";
  public static final String EXCEED_SIZE_SALARY_TEXT = "12345678901";
  public static final String TEST_DIRECTION = "Direccion de prueba pasivo avvillas";
  public static final int SALARY_SIZE = 10;
  public static final String TAG_OTP = "s1:CustIdNum";
  public static final String VALUE_OTP = "12345678";
  public static final String STG_VALUE = "stg";
  public static final String DEV_VALUE = "dev";
  public static final String DATA_CLIENT_PROP = "client";
  public static final String DATA_UPDATED_PROP = "updated";
  public static final String DATA_CHANNELS_PROP = "hasChannels";
  public static final String DATA_CAT_PROP = "cat";
  public static final String DATA_OTP_PROP = "validOtp";
  public static final String DATA_REST_LIST_PROP = "restrictiveList";
  public static final String DATA_BLOCK_PROP = "block";
  public static final String DATA_USERS_PROP = "users";
  public static final String DATA_NUMDOC_PROP = "numDoc";
  public static final String DATA_TIPODOC_PROP = "tipoDoc";
  public static final String DATA_FIRST_NAME_PROP = "firstName";
  public static final String DATA_LAST_NAME_PROP = "lastName";
  public static final String DATA_PHONE_PROP = "phone";
  public static final String DATA_SALARY_PROP = "salary";
  public static final String VALID_SALARY = "10000";
  public static final String TAG_VALID = "VALID";
  public static final String TAG_EXCEED_MAX = "EXCEED";
  public static final String INVALID_SALARY = "9999";
  public static final String TAG_INVALID = "INVALID";
  public static final String PRO_SALARY = "1800000";
  public static final String TAG_PRO = "PRO";
  public static final String SIMPLE_SALARY = "1799000";
  public static final String TAG_SIMPLE = "SIMPLE";
  public static final String TAG_SIMPLE_ACCOUNT = "cuenta simple";
  public static final String TAG_ACCEPT = "acepta";
  public static final String TAG_NOT_ACCEPT = "no acepta";
  public static final String TAG_EDIT = "modifica";
  public static final String TAG_NOT_EDIT = "no modifica";

  public static final String EXECUTION_TAGS = "@ok";
  public static final String RUTA_STEPS_DEFINITIONS = "co.com.avvillaspasivos.stepsdefinitions";
}
