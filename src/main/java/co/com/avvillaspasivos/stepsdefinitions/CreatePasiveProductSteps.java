/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.tasks.apitask.CreatePasiveProduct;
import co.com.avvillaspasivos.tasks.apitask.GetTokenBy;
import co.com.avvillaspasivos.tasks.apitask.GetUpdateCrmClient;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreatePasiveProductSteps {
  @Dado("que el {string} se autenticó")
  public void queElSeAutenticó(String userType) {
    theActorCalled(SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetUpdateCrmClient.perform());
    theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetTokenBy.userIdentity(DEV_ENV));
  }

  @Cuando("el usuario radica el producto pasivo")
  public void elUsuarioRadicaElProductoPasivo() {
    theActorCalled("RADICAR_PASIVO").attemptsTo(CreatePasiveProduct.post());
  }

  @Entonces("se validará que la estructura de la respuesta es correcta")
  public void seValidaráQueLaEstructuraDeLaRespuestaEsCorrecta() {
    theActorInTheSpotlight().attemptsTo(Schema.validation(ServicePaths.pathCppSchema()));
  }
}
