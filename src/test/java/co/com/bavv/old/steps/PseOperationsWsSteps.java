/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.apitask.CreateTransactionPse;
import co.com.bavv.old.tasks.apitask.FinishTransactionPse;
import co.com.bavv.old.tasks.apitask.GetPseStatus;
import co.com.bavv.old.tasks.apitask.GetTokenBy;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class PseOperationsWsSteps {

  @Dado("crea un transaccion correctamente")
  public void creaUnTransaccionCorrectamente() {
    OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(
        GetTokenBy.userIdentity(Constantes.DEV_ENV));
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
