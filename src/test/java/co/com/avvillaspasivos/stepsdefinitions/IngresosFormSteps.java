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

import co.com.avvillaspasivos.tasks.BdUser;
import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.UiAssertions;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class IngresosFormSteps {

    @Dado("que el usuario en pantalla identificación de usuario")
    public void queElEnPantallaIdentificaciónDeUsuario() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                TasksGroup.navigateToIdentificationForm());
    }


    @Entonces("se activará el botón continuar si este y los demás campos están diligenciados correctamente.")
    public void seActivaráElBotónContinuarSiEsteYLosDemásCamposEstánDiligenciadosCorrectamente() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                BdUser.toBlock(false),
                UiAssertions.validateContinueButtonFormIdentificationEnabled()
            );
    }

    @Entonces("se observara que no permite el ingreso en el campo de texto")
    public void seObservaraQueNoPermiteElIngresoEnElCampoDeTexto() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                BdUser.toBlock(false),
                UiAssertions.validateSalaryLimitForm()
                );
    }


    @Entonces("se mostrará el mensaje de error {string}")
    public void seMostraráElMensajeDeError(String msg) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                BdUser.toBlock(false),
                UiAssertions.validateMinIncome(msg)
            );
    }

    @Entonces("la información se visualizara con signo pesos como primer posición y los puntos de miles y o millones")
    public void laInformaciónSeVisualizaraConSignoPesosComoPrimerPosiciónYLosPuntosDeMilesYOMillones() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                BdUser.toBlock(false),
                UiAssertions.validateIncomeFormat()
            );
    }
}
