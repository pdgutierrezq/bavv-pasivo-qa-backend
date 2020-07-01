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

        ActorData actorData = DataProvider.getActorData(clientConditions);

        OnStage.theActorCalled(
            "usuario tipo cliente "
                + client
                + " actualizado "
                + updated
                + " y listas restrictivas "
                + listRest)
            .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

        OnStage.theActorInTheSpotlight().attemptsTo(BdUser.toBlock(true));

        OnStage.theActorInTheSpotlight().has(Usuario.informacion());
    }

    public static void configure(String client, String updated, String listRest, String cat) {
        ClientConditions clientConditions =
            ClientConditions.builder()
                .client(Boolean.valueOf(client))
                .updated(Boolean.valueOf(updated))
                .restrictiveList(Boolean.valueOf(listRest))
                .cat(Boolean.valueOf(cat))
                .build();

        ActorData actorData = DataProvider.getActorData(clientConditions);

        OnStage.theActorCalled(
            "usuario tipo cliente "
                + client
                + " actualizado "
                + updated
                + " y listas restrictivas "
                + listRest)
            .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

        OnStage.theActorInTheSpotlight().attemptsTo(BdUser.toBlock(true));

        OnStage.theActorInTheSpotlight().has(Usuario.informacion());
    }
}
