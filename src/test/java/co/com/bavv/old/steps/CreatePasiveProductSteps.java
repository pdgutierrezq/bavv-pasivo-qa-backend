/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.tasks.Schema;
import co.com.bavv.old.tasks.apitask.CreatePasiveProduct;
import co.com.bavv.old.tasks.apitask.GetTokenBy;
import co.com.bavv.old.tasks.apitask.GetUpdateCrmClient;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreatePasiveProductSteps {
  @Dado("que el {string} se autenticó")
  public void queElSeAutenticó(String userType) {
    theActorCalled(Constantes.SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetUpdateCrmClient.perform());
    theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(
        GetTokenBy.userIdentity(Constantes.DEV_ENV));
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
