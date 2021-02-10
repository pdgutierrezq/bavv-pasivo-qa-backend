/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ForeignValidationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillForeignInformation implements Task {

    public static Performable perfom() {
        return instrumented(FillForeignInformation.class);
    }

    @Step("{0} Diligencia el formulario de informacion del extranjero")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Click.on(ForeignValidationPage.RADIO_FISCAL_NO),
            Click.on(ForeignValidationPage.RADIO_GREEN_CARD_NO),
            Click.on(ForeignValidationPage.RADIO_PERMANENCY_ACTUAL_YEAR_NO),
            Click.on(ForeignValidationPage.RADIO_PERMANENCY_THREE_YEAR_NO),
            Click.on(ForeignValidationPage.BUTTON_CONTINUE)
        );
    }

}

