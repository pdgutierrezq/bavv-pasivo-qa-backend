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
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.avvillaspasivos.util.Constantes.UI_URL_PATHS;

public class CreateTransactionPseSteps {
    @Cuando("se crea la transacción PSE de forma exitosa")
    public void seCreaLaTransacciónPSEDeFormaExitosa() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                TasksGroup.fillPseCdt()
            );
    }


    @Entonces("se envía al cliente a la URL de {string}")
    public void seEnvíaAlClienteALaURLDe(String screenType) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains(UI_URL_PATHS.get(screenType))
            );
    }
}
