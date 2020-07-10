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

import co.com.avvillaspasivos.tasks.EnrollmentKey;
import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.UiAssertions;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EnrollmentScreenSteps {
    @Dado("el cliente está en la pantalla de enrolamiento")
    public void elClienteEstáEnLaPantallaDeEnrolamiento() {
        theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToEnrollmentScreen());

    }

    @Cuando("ingrese un numero de cuatro digitos y existan {string}")
    public void ingreseUnNumeroDeCuatroDigitosYExistan(String condition) {
        theActorInTheSpotlight()
            .attemptsTo(
                EnrollmentKey.option(condition)
            );
    }

    @Entonces("se mostrará un mensaje que diga {string}")
    public void seMostraráUnMSJQueDiga(String msj) {
        theActorInTheSpotlight()
            .attemptsTo(
                UiAssertions.validateAlert(msj)
            );
    }

    @Y("no se activará el botón")
    public void noSeActivaráElBotón() {
        theActorInTheSpotlight()
            .attemptsTo(
                UiAssertions.validateContinueAddressDisabled()
            );
    }
}
