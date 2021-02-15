/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.BankList;
import co.com.avvillaspasivos.tasks.GetToken;
import co.com.avvillaspasivos.tasks.Schema;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.paths.ServicePaths.pathPseGetBankListSchema;
import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;
import static co.com.avvillaspasivos.util.Constantes.BANK_LIST_ACTOR;

public class PseGetBankListSteps {
    @Cuando("se llama al servicio pse get bank list")
    public void seLlamaAlServicioPseGetBankList() {
        OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
        OnStage.theActorCalled(BANK_LIST_ACTOR).attemptsTo(BankList.get());
    }

    @Entonces("se validará el esquema de la respuesta")
    public void seValidaráElEsquemaDeLaRespuesta() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                Schema.validation(pathPseGetBankListSchema())
                );
    }
}
