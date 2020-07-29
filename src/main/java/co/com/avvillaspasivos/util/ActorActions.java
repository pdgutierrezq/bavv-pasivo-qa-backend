/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.util;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.tasks.BdUser;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.util.Constantes.*;

public class ActorActions {
  private ActorActions() {
    throw new IllegalStateException("Utility class");
  }

  public static void configure(String client, String updated, String listRest) {
    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .restrictiveList(Boolean.valueOf(listRest))
            .build();

    setUp(clientConditions);
  }

  public static ClientConditions buildActorConditions(String userType) {
    ClientConditions conditions;

    switch (userType) {
      case CLIENT_UPDATED_REST_LIST_CAT_CANALES:
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .restrictiveList(false)
                .cat(true)
                .channels(true)
                .build();
        break;
      case CLIENT_UPDATED_REST_LIST_NOT_CAT_CANALES:
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .restrictiveList(false)
                .cat(false)
                .channels(true)
                .build();
        break;
      default:
        conditions = ClientConditions.builder().build();
    }
    return conditions;
  }

  public static void configure(String cat) {
    ClientConditions clientConditions =
        ClientConditions.builder().cat(Boolean.valueOf(cat)).restrictiveList(false).build();

    setUp(clientConditions);
  }

  public static void configure(String client, String updated, String listRest, String cat) {

    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .restrictiveList(Boolean.valueOf(listRest))
            .cat(Boolean.valueOf(cat))
            .build();

    setUp(clientConditions);
  }

  public static void configure(
      String client, String updated, String listRest, String cat, String channels) {

    ClientConditions clientConditions =
        ClientConditions.builder()
            .client(Boolean.valueOf(client))
            .updated(Boolean.valueOf(updated))
            .restrictiveList(Boolean.valueOf(listRest))
            .cat(Boolean.valueOf(cat))
            .channels(Boolean.valueOf(channels))
            .build();

    setUp(clientConditions);
  }

  public static void setUp(ClientConditions conditions) {

    ActorData actorData = DataProvider.getActorData(conditions);

    OnStage.theActorCalled(buildReportNameActor(conditions))
        .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().attemptsTo(BdUser.toBlock(true));

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  private static String concatActorDescription(String base, String firstParam, Boolean condition) {
    return base.concat(firstParam)
        .concat((Boolean.TRUE.equals(condition)) ? TRUE_VALUE : FALSE_VALUE);
  }

  public static String buildReportNameActor(ClientConditions conditions) {
    String actorDesc = "usuario tipo ";

    if (conditions.getClient() != null) {
      actorDesc = concatActorDescription(actorDesc, " -cliente: ", conditions.getClient());
    }
    if (conditions.getUpdated() != null) {
      actorDesc = concatActorDescription(actorDesc, " -actualizado: ", conditions.getUpdated());
    }
    if (conditions.getRestrictiveList() != null) {
      actorDesc =
          concatActorDescription(
              actorDesc, " -listas restrictivas: ", conditions.getRestrictiveList());
    }
    if (conditions.getCat() != null) {
      actorDesc = concatActorDescription(actorDesc, " -cat: ", conditions.getCat());
    }
    if (conditions.getChannels() != null) {
      actorDesc = concatActorDescription(actorDesc, " -canales: ", conditions.getChannels());
    }
    if (conditions.getValidOtp() != null) {
      actorDesc = concatActorDescription(actorDesc, " -valido otp: ", conditions.getValidOtp());
    }

    return actorDesc;
  }
}
