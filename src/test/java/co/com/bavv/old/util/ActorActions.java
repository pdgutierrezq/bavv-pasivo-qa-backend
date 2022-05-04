/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.util;

import co.com.bavv.old.data.DataProvider;
import co.com.bavv.old.facts.Usuario;
import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.ClientConditions;
import co.com.bavv.old.tasks.BdUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

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
      case Constantes.CLIENT_NO_UPDATED:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), true);
        conditions = ClientConditions.builder().client(true).updated(false).build();
        break;
      case Constantes.CLIENT_UPDATED_FUNDING_ACC_WITHOUT_CHANNELS_RENEWAL:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), true);
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .fundingAcc(true)
                .channels(false)
                .build();
        break;
      case Constantes.CLIENT_WITH_OUT_INSURANCE:
        conditions = ClientConditions.builder().insurance(false).build();
        break;
      case Constantes.CLIENT_WITH_INSURANCE:
        conditions = ClientConditions.builder().insurance(true).build();
        break;
      case Constantes.CLIENT_FUNDING_ACC:
        conditions = ClientConditions.builder().fundingAccValue(36000000).build();
        break;
      case Constantes.CLIENT_WITH_OUT_FUNDING_ACC:
        conditions = ClientConditions.builder().fundingAcc(false).fundingAccValue(1).build();
        break;
      case Constantes.CLIENT_UPDATED_FUNDING_ACC_WITH_CHANNELS_NO_RENEWAL:
      case Constantes.CLIENT_UPDATED_WITH_CHANNELS:
      case Constantes.CLIENT_WITH_CHANNELS:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), false);

        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .fundingAcc(true)
                .channels(true)
                .build();
        break;
      case Constantes.CLIENT_UPDATED_REST_LIST_CAT_WITH_CHANNELS:
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .restrictiveList(false)
                .cat(true)
                .channels(true)
                .build();
        break;
      case Constantes.CLIENT_UPDATED_REST_LIST_NOT_CAT_WITH_CHANNELS:
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .restrictiveList(false)
                .cat(false)
                .channels(true)
                .build();
        break;
      case Constantes.CLIENT_UPDATED_WITHOUT_CHANNELS:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), true);
        conditions =
            ClientConditions.builder()
                .client(true)
                .updated(true)
                .restrictiveList(false)
                .cat(false)
                .channels(false)
                .build();
        break;
      case Constantes.CLIENT_UPDATED:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), true);
        conditions = ClientConditions.builder().client(true).updated(true).build();
        break;
      case Constantes.NO_CLIENT_NO_UPDATED_WITHOUT_CHANNELS:
      case Constantes.CLIENT_WITHOUT_CHANNELS:
      case Constantes.NO_CLIENT:
        OnStage.theActorInTheSpotlight().remember(SessionVariables.RENEWAL.name(), false);

        conditions =
            ClientConditions.builder()
                .client(false)
                .updated(false)
                .restrictiveList(false)
                .cat(false)
                .channels(false)
                .build();
        break;
      default:
        conditions = ClientConditions.builder().client(true).updated(false).build();
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
        .concat((Boolean.TRUE.equals(condition)) ? Constantes.TRUE_VALUE : Constantes.FALSE_VALUE);
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

  public static String getMainActorName() {
    return theActorCalled(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());
  }

  public static ActorData getActorDataFlow(String actorName) {
    return OnStage.theActor(actorName).recall(SessionVariables.DATA_ACTOR.name());
  }

  public static ActorData getActorInTheSpotLightData() {
    return OnStage.theActorInTheSpotlight().recall(SessionVariables.DATA_ACTOR.name());
  }

  public static String getToken() {
    return OnStage.theActor(Constantes.AUTHENTICATION_ACTOR).recall(SessionVariables.TOKEN.name());
  }

  public static String getTextFromTarget(Actor actor, Target target) {
    return Text.of(target).viewedBy(actor).resolve();
  }

  public static String getTextFromPeriodItemList(Actor actor, Target target) {
    return getTextFromTarget(actor, target).split("\n")[0];
  }
}
