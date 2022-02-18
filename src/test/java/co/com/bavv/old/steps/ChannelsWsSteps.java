/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.GetToken;
import co.com.bavv.old.tasks.apitask.GetChannels;
import co.com.bavv.old.tasks.apivalidation.ChannelsResponse;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class ChannelsWsSteps {
    @Cuando("el usuario consulta si tiene canales")
    public void elUsuarioConsultaSiTieneCanales() {
        OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
        OnStage.theActorCalled("GET_CHANNELS").attemptsTo(GetChannels.get());
    }

    @Entonces("se validara que el usuario {string} canales")
    public void seValidaraQueElUsuarioCanales(String channelsOption) {
        OnStage.theActorInTheSpotlight().attemptsTo(ChannelsResponse.validate(channelsOption));
    }
}
