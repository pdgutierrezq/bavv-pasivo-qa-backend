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
import co.com.avvillaspasivos.tasks.apitask.GetRates;
import co.com.avvillaspasivos.tasks.apivalidation.ValidateRates;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetRatesWsSteps {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que el {string} esta habilitado para consultar las tasas")
  public void queElEstaHabilitadoParaConsultarLasTasas(String user) {
    OnStage.theActorCalled(user).whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
  }

  @Cuando("realizala consulta de las tasas")
  public void realizalaConsultaDeLasTasas() {
    OnStage.theActorInTheSpotlight().attemptsTo(GetRates.callGet());
  }

  @Entonces("se validará la correcta estructura de la respuesta")
  public void seValidaráLaCorrectaEstructuraDeLaRespuesta() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              ValidateRates.perform()
          );

  }
}
