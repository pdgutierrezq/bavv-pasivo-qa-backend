/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.apitask.CreateTransactionPse;
import co.com.avvillaspasivos.tasks.apitask.FinishTransactionPse;
import co.com.avvillaspasivos.tasks.apitask.GetPseStatus;
import co.com.avvillaspasivos.tasks.apitask.GetTokenBy;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;
import static co.com.avvillaspasivos.util.Constantes.DEV_ENV;

public class PseOperationsWsSteps {

  @Dado("crea un transaccion correctamente")
  public void creaUnTransaccionCorrectamente() {
    OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetTokenBy.userIdentity(DEV_ENV));
    OnStage.theActorCalled("CREATE_PSE_TRANSACTION").attemptsTo(CreateTransactionPse.post());
  }

  @Cuando("se valida el estado con operacion exitosa")
  public void seValidaElEstadoConOperacionExitosa() {
    OnStage.theActorCalled("STATUS_PSE_TRANSACTION").attemptsTo(GetPseStatus.get());
  }

  @Entonces("finaliza la transaccion y se confirma el exito de la operacion")
  public void finalizaLaTransaccionYSeConfirmaElExitoDeLaOperacion() {
    OnStage.theActorCalled("FINISH_PSE_TRANSACTION").attemptsTo(FinishTransactionPse.put());
  }
}
