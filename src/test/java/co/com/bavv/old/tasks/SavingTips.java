/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.SavingTipsPage;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SavingTips implements Task {

    public static Performable waitAndGo() {
        return instrumented(SavingTips.class);
    }

    @Step("{0} espera hasta que se active el boton continuar y sigue el flujo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(SavingTipsPage.CONTINUE_BUTTON, isEnabled()).forNoMoreThan(Constantes.MAX_WAIT).seconds(),
            Click.on(SavingTipsPage.CONTINUE_BUTTON)
        );
    }

}
