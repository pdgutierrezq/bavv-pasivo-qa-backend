/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.BdUser;
import co.com.bavv.old.tasks.FormIdentification;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.UiAssertions;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
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

    @Cuando("ingrese el valor de los ingresos mensuales mayores o iguales a 10000")
    public void ingreseElValorDeLosIngresosMensualesMayoresOIgualesA$() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                FormIdentification.fillForm(Constantes.TAG_VALID,false)
            );
    }

    @Entonces("se activará el botón continuar si este y los demás campos están diligenciados correctamente.")
    public void seActivaráElBotónContinuarSiEsteYLosDemásCamposEstánDiligenciadosCorrectamente() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                BdUser.toBlock(false),
                UiAssertions.validateContinueButtonFormIdentificationEnabled()
            );
    }

    @Cuando("ingrese el valor con longitud mayor de diez caracteres numéricos")
    public void ingreseElValorConLongitudMayorDeDiezCaracteresNuméricos() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                FormIdentification.fillForm(Constantes.TAG_EXCEED_MAX,false)
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

    @Cuando("el cliente deje el campo y el valor ingresado en el campo ingresos sea menor a 10000")
    public void elClienteDejeElCampoYElValorIngresadoEnElCampoIngresosSeaMenorA() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                FormIdentification.fillForm(Constantes.TAG_INVALID,false)
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
