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
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.VariablesDeSession;
import com.google.common.collect.Streams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.actors.OnStage;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.avvillaspasivos.util.Constantes.*;
import static co.com.avvillaspasivos.util.Report.LOGGER;

public class JsonFile {
  private JsonFile() {
    throw new IllegalStateException("Utility class");
  }

  static JsonObject readJsonFile() throws FileNotFoundException {
    Reader reader = new FileReader(ServicePaths.jsonDatapath());
    return JsonParser.parseReader(reader).getAsJsonObject();
  }

  private static void writeJsonFile(JsonObject joMain) {

    try (FileWriter file = new FileWriter(ServicePaths.jsonDatapath()); ) {
      file.write(joMain.toString());
      file.flush();
    } catch (IOException e) {
      LOGGER.error("Fail writing json data file->".concat(e.getMessage()));
    }
  }

  static JsonObject getUser(
      JsonObject joMain,
      Boolean client,
      Boolean updated,
      Boolean channels,
      Boolean cat,
      Boolean listRest) {
    List<JsonObject> jsonObjectList = getUsersList(joMain);

    return jsonObjectList.stream()
        .filter(i -> client == i.get(DATA_CLIENT_PROP).getAsBoolean())
        .filter(i -> updated == i.get(DATA_UPDATED_PROP).getAsBoolean())
        .filter(i -> channels == i.get(DATA_CHANNELS_PROP).getAsBoolean())
        .filter(i -> cat == i.get(DATA_CAT_PROP).getAsBoolean())
        .filter(i -> listRest == i.get(DATA_REST_LIST_PROP).getAsBoolean())
        .filter(i -> !i.get(DATA_BLOCK_PROP).getAsBoolean())
        .findAny()
        .orElse(null);
  }

  static JsonObject getUser(JsonObject joMain, Boolean client, Boolean updated, Boolean listRest) {
    List<JsonObject> jsonObjectList = getUsersList(joMain);

    return jsonObjectList.stream()
        .filter(i -> i.has(DATA_REST_LIST_PROP))
        .filter(i -> client == i.get(DATA_CLIENT_PROP).getAsBoolean())
        .filter(i -> updated == i.get(DATA_UPDATED_PROP).getAsBoolean())
        .filter(i -> listRest == i.get(DATA_REST_LIST_PROP).getAsBoolean())
        .filter(i -> !i.get(DATA_BLOCK_PROP).getAsBoolean())
        .findAny()
        .orElse(null);
  }

  public static JsonObject getUserById(JsonObject joMain, String numDoc) {
    List<JsonObject> jsonObjectList = getUsersList(joMain);

    return jsonObjectList.stream()
        .filter(i -> i.get(DATA_NUMDOC_PROP).getAsString().equalsIgnoreCase(numDoc))
        .findAny()
        .orElse(null);
  }

  public static void setValue(JsonObject joToSet, String property, Boolean value) {
    joToSet.addProperty(property, value);
  }

  private static List<JsonObject> getUsersList(JsonObject joMain) {

    return Streams.stream(joMain.get(DATA_USERS_PROP).getAsJsonArray().iterator())
        .map(JsonElement::getAsJsonObject)
        .collect(Collectors.toList());
  }

  public static void setProperty(
      JsonObject joMain, JsonObject jsonObjectUser, String property, boolean value) {

    jsonObjectUser.addProperty(property, value);
    writeJsonFile(joMain);
  }

  public static void setProperty(String property, boolean value) {
    ActorData actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(VariablesDeSession.DATA_ACTOR));
    actorData.getJsonObjectUser().addProperty(property, value);
    writeJsonFile(actorData.getJsonObjectDataFlow());
  }
}
