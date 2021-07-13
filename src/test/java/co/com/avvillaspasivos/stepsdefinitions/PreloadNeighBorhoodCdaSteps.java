/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.CrmInfo;
import co.com.avvillaspasivos.tasks.GetToken;
import co.com.avvillaspasivos.tasks.UiAssertions;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.tasks.TasksGroup.navigateToContactDataCDa;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PreloadNeighBorhoodCdaSteps {
    @Cuando("ingrese a la pantalla de datos de contacto en Cda.")
    public void ingreseALaPantallaDeDatosDeContactoEnCda() {

        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                navigateToContactDataCDa()
            );
        OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
        OnStage.theActorCalled(CRM_ACTOR).attemptsTo(CrmInfo.post());
    }

    @Entonces("se pre cargará la información de barrio que tenga en CRM")
    public void sePreCargaráLaInformaciónDeBarrioQueTengaEnCRM() {
        theActor(theActor(SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
            .attemptsTo(
                UiAssertions.validateContactPreload()
            );
    }
}
