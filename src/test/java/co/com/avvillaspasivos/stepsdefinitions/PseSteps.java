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

public class PseSteps {
  @Cuando("cargue la pantalla")
  public void cargueLaPantalla() {
    OnStage.theActorInTheSpotlight().attemptsTo(UiAssertions.validatePseCharge());
  }

  @Cuando("se llama el servicio de PSE lista bancos con respuesta exitosa")
  public void seLlamaElServicioDePSEListaBancosConRespuestaExitosa() {
    OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
    OnStage.theActorCalled(BANK_LIST_ACTOR).attemptsTo(BankList.get());
  }

  @Y("que llegúe a la pantalla de PSE")
  public void queLlegúeALaPantallaDePSE() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToPseCdt());
  }

  @Entonces("se mostrará precargada la información del número del CDT y el monto a invertir")
  public void seMostraráPrecargadaLaInformaciónDelNúmeroDelCDTYElMontoAInvertir() {
    OnStage.theActorInTheSpotlight().attemptsTo(ValidatePseLoad.perform());
  }

  @Entonces(
      "se cargarà el listado de bancos como opciones para la pregunta ¿De qué banco traerás tu plata?")
  public void seCargaràElListadoDeBancosComoOpcionesParaLaPreguntaDeQuéBancoTraerásTuPlata() {
    theActor(theActor(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
        .attemptsTo(TasksGroup.openBankListPse(), ValidateBankList.front());
  }
}
