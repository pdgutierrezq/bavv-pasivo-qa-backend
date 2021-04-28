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
import co.com.avvillaspasivos.model.CityList;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import com.google.common.collect.Streams;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.actors.OnStage;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  static CityList readCitiesFile(String listType) throws FileNotFoundException {
    String jsonPath =
        (listType.equals(DOMINA))
            ? ServicePaths.jsonDominaCitiesDatapath()
            : ServicePaths.jsonCountryCitiesDatapath();

    Reader reader = new FileReader(jsonPath);
    Gson gson = new Gson();
    JsonObject joMain = JsonParser.parseReader(reader).getAsJsonObject();
    return gson.fromJson(joMain.toString(), CityList.class);
  }

  private static void writeJsonFile(JsonObject joMain) {

    try (FileWriter file = new FileWriter(ServicePaths.jsonDatapath()); ) {
      file.write(joMain.toString());
      file.flush();
    } catch (IOException e) {
      LOGGER.error("Fail writing json data file->".concat(e.getMessage()));
    }
  }

  static JsonObject getUser(JsonObject joMain, ClientConditions conditions) {

    List<JsonObject> jsonObjectList = getUsersList(joMain);
    Stream<JsonObject> streamList = jsonObjectList.stream();

    try {
      streamList = filterStreamUser(streamList, conditions);
    } catch (Exception e) {
      LOGGER.error("Fail getting a valid user ->".concat(e.getMessage()));
    }
    return streamList.findAny().orElse(null);
  }

  private static Stream<JsonObject> filterStreamUser(
      Stream<JsonObject> x, ClientConditions conditions) {

    if (Objects.nonNull(conditions.getClient())) {
      x = x.filter(i -> conditions.getClient() == i.get(DATA_CLIENT_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getUpdated())) {
      x = x.filter(i -> conditions.getUpdated() == i.get(DATA_UPDATED_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getChannels())) {
      x = x.filter(i -> conditions.getChannels() == i.get(DATA_CHANNELS_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getCat())) {
      x = x.filter(i -> conditions.getCat() == i.get(DATA_CAT_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getValidOtp())) {
      x = x.filter(i -> conditions.getValidOtp() == i.get(DATA_OTP_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getRestrictiveList())) {
      x =
          x.filter(
              i -> conditions.getRestrictiveList() == i.get(DATA_REST_LIST_PROP).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getFundingAcc())) {
      x =
          x.filter(e -> Objects.nonNull(e.get(DATA_FUNDING_ACC)))
              .filter(i -> conditions.getFundingAcc() == i.get(DATA_FUNDING_ACC).getAsBoolean());
    }
    if (Objects.nonNull(conditions.getInsurance())) {
      x =
          x.filter(e -> Objects.nonNull(e.get(DATA_INSURANCE)))
              .filter(i -> conditions.getInsurance() == i.get(DATA_INSURANCE).getAsBoolean());
    }
    if (conditions.getFundingAccValue()!=0) {
      x =
          x.filter(e -> Objects.nonNull(e.get(DATA_FUNDING_ACC_VALLUE)))
              .filter(
                  i ->
                      conditions.getFundingAccValue() == i.get(DATA_FUNDING_ACC_VALLUE).getAsInt());
    }
    return x.filter(i -> !i.get(DATA_BLOCK_PROP).getAsBoolean());
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
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
    actorData.getJsonObjectUser().addProperty(property, value);
    writeJsonFile(actorData.getJsonObjectDataFlow());
  }
}
