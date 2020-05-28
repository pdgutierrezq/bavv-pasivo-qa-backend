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
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import com.google.common.collect.Streams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.aeonbits.owner.ConfigFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.avvillaspasivos.util.Constantes.DATA_USERS_PROP;

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

  public static BodyGenerarOtp getBodyIdentification(String tipoUsuario) {
    JsonObject jsonObjectUser = filterUsersList(tipoUsuario, getUsers());

    return BodyGenerarOtp.builder()
        .documentType(jsonObjectUser.get("tipoDoc").getAsString())
        .documentNumber(jsonObjectUser.get("numDoc").getAsString())
        .firstName(jsonObjectUser.get("firstName").getAsString())
        .lastName(jsonObjectUser.get("lastName").getAsString())
        .phone(jsonObjectUser.get("phone").getAsString())
        .build();
  }

  public static ActorData getActorData(Boolean client,Boolean updated,Boolean channels,Boolean cat)  {
      JsonObject joMain = null;
      try {
          joMain = JsonFile.readJsonFile();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      JsonObject jsonObjectUser=JsonFile.getUser(joMain, client, updated, channels, cat);
      JsonFile.setProperty(joMain,jsonObjectUser,"block",true);

    return ActorData.builder()
        .documentType(jsonObjectUser.get("tipoDoc").getAsString())
        .documentNumber(jsonObjectUser.get("numDoc").getAsString())
        .firstName(jsonObjectUser.get("firstName").getAsString())
        .lastName(jsonObjectUser.get("lastName").getAsString())
        .phone(jsonObjectUser.get("phone").getAsString())
        .salary(jsonObjectUser.get("salary").getAsString())
        .client(jsonObjectUser.get("client").getAsString())
        .updated(jsonObjectUser.get("updated").getAsString())
        .channels(jsonObjectUser.get("hasChannels").getAsString())
        .cat(jsonObjectUser.get("cat").getAsString())
        .jsonObjectDataFlow(joMain)
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
}
