/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.model.*;
import co.com.avvillaspasivos.util.Constantes;
import com.google.common.collect.Streams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.aeonbits.owner.ConfigFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static co.com.avvillaspasivos.util.Constantes.*;
import static co.com.avvillaspasivos.util.Report.LOGGER;

public class DataProvider {

  private DataProvider() {
    throw new IllegalStateException("Utility class");
  }

  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  private static String getJsonUsers() {
    return environment.users();
  }

  public static BodyWs getBodyIdentification(String tipoUsuario) {
    JsonObject jsonObjectUser = filterUsersList(tipoUsuario, getUsers());

    return BodyWs.builder()
        .documentType(jsonObjectUser.get(DATA_TIPODOC_PROP).getAsString())
        .documentNumber(jsonObjectUser.get(DATA_NUMDOC_PROP).getAsString())
        .firstName(jsonObjectUser.get(DATA_FIRST_NAME_PROP).getAsString())
        .lastName(jsonObjectUser.get(DATA_LAST_NAME_PROP).getAsString())
        .phone(jsonObjectUser.get(DATA_PHONE_PROP).getAsString())
        .build();
  }

  public static ActorData getActorData(ClientConditions clientConditions) {

    JsonObject joMain = getDataMain();
    JsonObject jsonObjectUser = JsonFile.getUser(joMain, clientConditions);

    return buildActorData(jsonObjectUser, joMain);
  }

  private static JsonObject getDataMain() {
    JsonObject joMain = null;
    try {
      joMain = JsonFile.readJsonFile();
    } catch (FileNotFoundException e) {
      LOGGER.error("Fail reading json data file->".concat(e.getMessage()));
    }
    return joMain;
  }

  public static String getCompanyCity(String daneCode, String cityListType) {
    CityList cityList = null;
    String city = "";

    if (!daneCode.equals("0")) {
      try {
        cityList = JsonFile.readCitiesFile(cityListType);
      } catch (FileNotFoundException e) {
        LOGGER.error("Fail reading json country cities file->".concat(e.getMessage()));
      }
        daneCode=(daneCode.startsWith("0"))?daneCode.substring(1):daneCode;
        city = filterCity(cityList, daneCode);
    }

    return city;
  }

  private static String filterCity(CityList listCities, String daneCode) {
    return Objects.requireNonNull(listCities).getCity().stream()
        .filter(e -> e.getCodeDANE().equals(daneCode))
        .map(City::getMunicipality)
        .findFirst()
        .orElseGet(() -> "Ciudad no encontrada");
  }

  private static ActorData buildActorData(JsonObject jsonObjectUser, JsonObject joMain) {
    return ActorData.builder()
        .documentType(jsonObjectUser.get(DATA_TIPODOC_PROP).getAsString())
        .documentNumber(jsonObjectUser.get(DATA_NUMDOC_PROP).getAsString())
        .firstName(jsonObjectUser.get(DATA_FIRST_NAME_PROP).getAsString())
        .lastName(jsonObjectUser.get(DATA_LAST_NAME_PROP).getAsString())
        .phone(jsonObjectUser.get(DATA_PHONE_PROP).getAsString())
        .salary(jsonObjectUser.get(DATA_SALARY_PROP).getAsString())
        .client(jsonObjectUser.get(DATA_CLIENT_PROP).getAsBoolean())
        .updated(jsonObjectUser.get(DATA_UPDATED_PROP).getAsBoolean())
        .channels(jsonObjectUser.get(DATA_CHANNELS_PROP).getAsBoolean())
        .cat(jsonObjectUser.get(DATA_CAT_PROP).getAsBoolean())
        .restrictiveList(jsonObjectUser.get(DATA_REST_LIST_PROP).getAsBoolean())
        .jsonObjectDataFlow(joMain)
        .jsonObjectUser(jsonObjectUser)
        .build();
  }

  public static List<JsonObject> getUsers() {

    return Streams.stream(
            JsonParser.parseString(getJsonUsers())
                .getAsJsonObject()
                .get(DATA_USERS_PROP)
                .getAsJsonArray()
                .iterator())
        .map(JsonElement::getAsJsonObject)
        .collect(Collectors.toList());
  }

  private static JsonObject filterUsersList(String userType, List<JsonObject> list) {
    return list.stream()
        .filter(e -> e.get("tipoUser").getAsString().equals(userType))
        .findFirst()
        .orElse(new JsonObject());
  }

  public static String getOtp() {
    return Constantes.VALUE_OTP;
  }
}
