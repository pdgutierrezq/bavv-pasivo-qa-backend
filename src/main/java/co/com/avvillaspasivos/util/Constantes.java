/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

import com.google.common.collect.ImmutableList;

public class Constantes {

  private Constantes() {
    throw new IllegalStateException("Utility class");
  }

  public static final String EXECUTION_TAGS = "@e2esonar";
  public static final String RUTA_STEPS_DEFINITIONS = "co.com.avvillaspasivos.stepsdefinitions";
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
  public static final String TAG_CONFIRM = "confirma";
  public static final String TAG_NOT_CONFIRM = "no confirma";
  public static final String TAG_EDIT = "modifica";
  public static final String TAG_NOT_EDIT = "no modifica";
  public static final String TRUE_VALUE = "verdadero";
  public static final String FALSE_VALUE = "falso";
  public static final String CLIENT_UPDATED_REST_LIST_CAT_CANALES =
      "cliente actualizado sin lista restrictiva con cuenta cat y que tenga canales";
  public static final String CLIENT_UPDATED_REST_LIST_NOT_CAT_CANALES =
      "cliente actualizado sin lista restrictiva sin cuenta cat y que tenga canales";
  public static final String RESUMEN_TITLE_XPATH = "//h2";
  public static final String ACCOUNT_NUMBER_CLASS = "account-number";
  public static final String MONEY_CLASS = "money";
  public static final String MONTH_COST_VALUE = "$ 0,00";
  public static final String WITHDRAWALS_TEXT = "3 retiros gratis al mes";
  public static final String INSURANCE_COST = "$ 14.600,00";

  public static final ImmutableList<String> LIST_CITIES =
      ImmutableList.of(
          "Acacías - Meta",
          "Aguazul - Casanare",
          "Andalucía - Valle Del Cauca",
          "Apartadó - Antioquia",
          "Armenia - Quindío",
          "Barbosa - Antioquia",
          "Barrancabermeja - Santander",
          "Barranquilla - Atlántico",
          "Bello - Antioquia",
          "Bogotá D.C. - Bogotá D.C.",
          "Bucaramanga - Santander",
          "Buenaventura - Valle Del Cauca",
          "Bugalagrande - Valle Del Cauca",
          "Cajicá - Cundinamarca",
          "Calarcá - Quindío",
          "Caldas - Antioquia",
          "Cali - Valle Del Cauca",
          "Candelaria - Valle Del Cauca",
          "Carepa - Antioquia",
          "Cartagena - Bolívar",
          "Cartago - Valle Del Cauca",
          "Caucasia - Antioquia",
          "Chigorodó - Antioquia",
          "Chinú - Córdoba",
          "Chía - Cundinamarca",
          "Ciénaga - Magdalena",
          "Cogua - Cundinamarca",
          "Copacabana - Antioquia",
          "Cota - Cundinamarca",
          "Cúcuta - Norte De Santander",
          "Dosquebradas - Risaralda",
          "Duitama - Boyacá",
          "El Carmen de Viboral - Antioquia",
          "El Rosal - Cundinamarca",
          "El Santuario - Antioquia",
          "Envigado - Antioquia",
          "Facatativá - Cundinamarca",
          "Florencia - Caquetá",
          "Florida - Valle Del Cauca",
          "Floridablanca - Santander",
          "Funza - Cundinamarca",
          "Fusagasugá - Cundinamarca",
          "Gachancipá - Cundinamarca",
          "Garzón - Huila",
          "Girardota - Antioquia",
          "Girón - Santander",
          "Guadalajara de buga - Valle Del Cauca",
          "Guarne - Antioquia",
          "Guatapé - Antioquia",
          "Ibagué - Tolima",
          "Ipiales - Nariño",
          "Istmina - Chocó",
          "Itagüí - Antioquia",
          "Jamundí - Valle Del Cauca",
          "La Calera - Cundinamarca",
          "La Ceja - Antioquia",
          "La Dorada - Caldas",
          "La Estrella - Antioquia",
          "La Unión - Antioquia",
          "La Unión - Valle Del Cauca",
          "La Victoria - Valle Del Cauca",
          "Las Palmas - Antioquia",
          "Lebrija - Santander",
          "Los Patios - Norte De Santander",
          "Madrid - Cundinamarca",
          "Manizales - Caldas",
          "Marinilla - Antioquia",
          "Medellín - Antioquia",
          "Montelíbano - Córdoba",
          "Montería - Córdoba",
          "Mosquera - Cundinamarca",
          "Neiva - Huila",
          "Nobsa - Boyacá",
          "Paipa - Boyacá",
          "Palmira - Valle Del Cauca",
          "Pasto - Nariño",
          "Pereira - Risaralda",
          "Peñol - Antioquia",
          "Piedecuesta - Santander",
          "Pitalito - Huila",
          "Popayán - Cauca",
          "Pradera - Valle Del Cauca",
          "Puerto Berrío - Antioquia",
          "Puerto Colombia - Atlántico",
          "Puerto Salgar - Cundinamarca",
          "Quibdó - Chocó",
          "Retiro - Antioquia",
          "Rionegro - Antioquia",
          "Roldanillo - Valle Del Cauca",
          "Sabaneta - Antioquia",
          "Sahagún - Córdoba",
          "Sampués - Sucre",
          "San Antonio - Antioquia",
          "San Gil - Santander",
          "Santa Elena - Antioquia",
          "Santa Marta - Magdalena",
          "Sincelejo - Sucre",
          "Soacha - Cundinamarca",
          "Sogamoso - Boyacá",
          "Soledad - Atlántico",
          "Sopó - Cundinamarca",
          "Subachoque - Cundinamarca",
          "Tabio - Cundinamarca",
          "Tenjo - Cundinamarca",
          "Tibasosa - Boyacá",
          "Timaná - Huila",
          "Tocancipá - Cundinamarca",
          "Tuluá - Valle Del Cauca",
          "Tunja - Boyacá",
          "Turbaco - Bolívar",
          "Turbo - Antioquia",
          "Valledupar - Cesar",
          "Villa del Rosario - Norte De Santander",
          "Villamaría - Caldas",
          "Villavicencio - Meta",
          "Yopal - Casanare",
          "Yumbo - Valle Del Cauca",
          "Zarzal - Valle Del Cauca",
          "Zipaquirá - Cundinamarca");
}
