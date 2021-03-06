/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.ValidateSendingCard;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class SendingCardSteps {
  @Cuando("se cargue la pantalla de envio de tarjeta para cdt")
  public void seCargueLaPantallaDeEnvioDeTarjetaParaCdt() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToSendingCardCdt());
  }

  @Entonces(
      "el sistema debe traer la direcci├│n, barrio y ciudad de residencia que tiene en memoria proveniente de crm")
  public void
      elSistemaDebeTraerLaDirecci├│nBarrioYCiudadDeResidenciaQueTieneEnMemoriaProvenienteDeCrm() {
    OnStage.theActorInTheSpotlight().attemptsTo(ValidateSendingCard.perform());
  }

  @Cuando("se cargue la pantalla de envio de tarjeta para cda")
  public void seCargueLaPantallaDeEnvioDeTarjetaParaCda() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToSendingCardCda());
  }

    @Entonces("el sistema debe traer la direcci├│n, barrio y ciudad de residencia que tiene en memoria proveniente de datos de contacto")
    public void elSistemaDebeTraerLaDirecci├│nBarrioYCiudadDeResidenciaQueTieneEnMemoriaProvenienteDeDatosDeContacto() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidateSendingCard.perform());
    }
}
