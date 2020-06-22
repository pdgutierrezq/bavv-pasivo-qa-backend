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

import co.com.avvillaspasivos.data.JsonFile;
import co.com.avvillaspasivos.tasks.UiAssertions;
import co.com.avvillaspasivos.tasks.Waits;
import co.com.avvillaspasivos.tasks.FormIdentification;
import co.com.avvillaspasivos.tasks.GoTo;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class OfrecimientoCuentasSteps {
    @Cuando("el usuario diligencia el formulario con salario {string}")
    public void elUsuarioDiligenciaElFormularioConSalario(String salary) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                GoTo.homePage(),
                GoTo.startOnLanding(),
                FormIdentification.validatePageLoad(),
                FormIdentification.fillWithSalary(salary),
                Waits.loader());
    }

    @Entonces("la pantalla me debe mostrar la información de las cuentas, resaltando la cuenta simple")
    public void laPantallaMeDebeMostrarLaInformaciónDeLasCuentasResaltandoLaCuentaSimple() {
        JsonFile.setProperty("block", false);

        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                UiAssertions.validateSelectedRadioSimple()
            );
    }

    @Cuando("el usuario diligencia el formulario con salario igual o superior a {string}")
    public void elUsuarioDiligenciaElFormularioConSalarioIgualOSuperiorA(String salary) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                GoTo.homePage(),
                GoTo.startOnLanding(),
                FormIdentification.validatePageLoad(),
                FormIdentification.fillWithSalary(salary),
                Waits.loader());
    }

    @Entonces("la pantalla me debe mostrar la información de las cuentas, resaltando la cuenta PRO")
    public void laPantallaMeDebeMostrarLaInformaciónDeLasCuentasResaltandoLaCuentaPRO() {
        JsonFile.setProperty("block", false);

        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                UiAssertions.validateSelectedRadioPro()
            );
    }
}
