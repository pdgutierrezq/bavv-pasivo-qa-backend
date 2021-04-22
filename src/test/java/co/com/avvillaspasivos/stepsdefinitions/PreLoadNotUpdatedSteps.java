/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PreLoadNotUpdatedSteps {
  @Y("que hay información del usuario en el banco")
  public void queHayInformaciónDelUsuarioEnElBancoClienteDesactualizado() {
    OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
    OnStage.theActorCalled(CRM_ACTOR).attemptsTo(CrmInfo.post());
  }

  @Cuando("ingrese a la pantalla de datos de contacto o información financiera.")
  public void ingreseALaPantallaDeDatosDeContactoOInformaciónFinanciera() {
    theActor(theActor(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
        .attemptsTo(TasksGroup.navigateToContactDataCdt());
  }

  @Entonces("se pre cargarán los datos en la pantalla.")
  public void sePreCargaránLosDatosEnLaPantalla() {
    theActor(theActor(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
        .attemptsTo(ValidateContactPreload.perform());
  }

    @Entonces("se pre cargarán los datos en la pantalla de datos de contacto.")
    public void sePreCargaránLosDatosEnLaPantallaDeDatosDeContacto() {
      theActorInTheSpotlight().attemptsTo(
          UiAssertions.validateContactPreload()
      );
    }
}
