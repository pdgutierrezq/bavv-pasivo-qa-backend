/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.DeclaringPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeclaringSelection implements Task {
    private final String option;

    public DeclaringSelection(String option) {
        this.option = option;
    }

    public static Performable choose(String option) {
        return instrumented(DeclaringSelection.class, option);
    }

    @Step("{0} #option declarante")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Check.whether(TAG_CONFIRM.equalsIgnoreCase(option))
            .andIfSo(Click.on(DeclaringPage.RADIO_SI))
            .otherwise(Click.on(DeclaringPage.RADIO_NO)),
            Click.on(DeclaringPage.CONTINUE_BUTTON), Waits.loader(MAX_WAIT_GET_PDF)
        );
    }
}
