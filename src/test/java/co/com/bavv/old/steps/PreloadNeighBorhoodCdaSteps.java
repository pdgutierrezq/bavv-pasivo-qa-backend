/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.CrmInfo;
import co.com.bavv.old.tasks.GetToken;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.UiAssertions;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PreloadNeighBorhoodCdaSteps {
    @Cuando("ingrese a la pantalla de datos de contacto en Cda.")
    public void ingreseALaPantallaDeDatosDeContactoEnCda() {

        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                TasksGroup.navigateToContactDataCDa()
            );
        OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
        OnStage.theActorCalled(Constantes.CRM_ACTOR).attemptsTo(CrmInfo.post());
    }

    @Entonces("se pre cargará la información de barrio que tenga en CRM")
    public void sePreCargaráLaInformaciónDeBarrioQueTengaEnCRM() {
        theActor(theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
            .attemptsTo(
                UiAssertions.validateContactPreload()
            );
    }
}
