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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.aeonbits.owner.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

  private DataProvider() {
    throw new IllegalStateException("Utility class");
  }
  //  @Steps(shared = true)
  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  public static String getJsonUsers() {
    return environment.users();
  }

  public static BodyGenerarOtp getBodyIdentification(String tipoUsuario) {
      JsonObject jsonObjectUser= filterUsersList(tipoUsuario, getUsers());

      return BodyGenerarOtp.builder()
          .documentType(jsonObjectUser.get("tipoDoc").getAsString())
          .documentNumber(jsonObjectUser.get("numDoc").getAsString())
          .firstName(jsonObjectUser.get("firstName").getAsString())
          .lastName(jsonObjectUser.get("lastName").getAsString())
          .phone(jsonObjectUser.get("phone").getAsString())
          .build();

  }
  public static ActorData getActorData(String tipoUsuario) {
      JsonObject jsonObjectUser= filterUsersList(tipoUsuario, getUsers());

      return ActorData.builder()
          .documentType(jsonObjectUser.get("tipoDoc").getAsString())
          .documentNumber(jsonObjectUser.get("numDoc").getAsString())
          .firstName(jsonObjectUser.get("firstName").getAsString())
          .lastName(jsonObjectUser.get("lastName").getAsString())
          .phone(jsonObjectUser.get("phone").getAsString())
          .salary(jsonObjectUser.get("salary").getAsString())
          .build();

  }

  public static List<JsonObject> getUsers() {
    JsonParser parser = new JsonParser();
    List<JsonObject> users = new ArrayList<>();
    JsonObject jsonObject = parser.parse(getJsonUsers()).getAsJsonObject();
    JsonArray jsonElements = jsonObject.get("users").getAsJsonArray();
    jsonElements.forEach(je -> users.add(je.getAsJsonObject()));

    return users;
  }
  public static JsonObject filterUsersList(String userType, List<JsonObject> list) {
      return list.stream()
        .filter(e->e.get("tipoUser").getAsString().equals(userType))
        .findFirst().orElse(new JsonObject());
  }
}
