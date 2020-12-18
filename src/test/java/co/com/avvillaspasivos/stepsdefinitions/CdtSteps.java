/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.PerformFlowCdt;
import co.com.avvillaspasivos.tasks.ResumenValidationCdt;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CdtSteps {
    @Cuando("el usuario realiza el flujo")
    public void elUsuarioRealizaElFlujo() {
        theActorInTheSpotlight().attemptsTo(PerformFlowCdt.type());

    }

    @Entonces("se muestra el resumen de la creación del CDT")
    public void seMuestraElResumenDeLaCreaciónDelCDT() {
    theActorInTheSpotlight().attemptsTo(ResumenValidationCdt.perform());
    }
}
