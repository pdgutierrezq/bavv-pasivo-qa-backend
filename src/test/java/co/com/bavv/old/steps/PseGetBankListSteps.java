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
import co.com.bavv.old.tasks.BankList;
import co.com.bavv.old.tasks.GetToken;
import co.com.bavv.old.tasks.Schema;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class PseGetBankListSteps {
  @Cuando("se llama al servicio pse get bank list")
  public void seLlamaAlServicioPseGetBankList() {
    OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
    OnStage.theActorCalled(Constantes.BANK_LIST_ACTOR).attemptsTo(BankList.get());
  }

  @Entonces("se validará el esquema de la respuesta")
  public void seValidaráElEsquemaDeLaRespuesta() {
    OnStage.theActorInTheSpotlight().attemptsTo(
        Schema.validation(ServicePaths.pathPseGetBankListSchema()));
  }
}
