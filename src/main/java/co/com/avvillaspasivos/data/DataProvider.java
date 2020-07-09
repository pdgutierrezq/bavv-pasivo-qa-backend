/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.BodyWs;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import co.com.avvillaspasivos.util.Xml;
import com.google.common.collect.Streams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import org.aeonbits.owner.ConfigFactory;

import java.io.FileNotFoundException;
import java.util.List;
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

    public  static String getOtp(){
        ActorData actorData =
            OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

        String url= Serenity.getWebdriverManager().getWebdriver().getCurrentUrl();
        String otp ="";

        if (url.contains(Constantes.DEV_VALUE)) {
            otp= Constantes.VALUE_OTP;
        } else if (url.contains(Constantes.STG_VALUE)) {
            DbQuerys dbQuerys = new DbQuerys();
            String dataTagOtp = dbQuerys.getXmlOtp(actorData.getPhone());
            otp= Xml.getDataTextString(dataTagOtp, Constantes.TAG_OTP).substring(8);
        }

        return otp;
    }
}
