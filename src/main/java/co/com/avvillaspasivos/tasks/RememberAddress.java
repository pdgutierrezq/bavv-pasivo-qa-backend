/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.SendingCardPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RememberAddress implements Task {

    public static Performable fromSendCard() {
        return instrumented(RememberAddress.class);
    }

    @Step("{0} recuerda la direccion precargada de Crm")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(String.valueOf(SessionVariables.CRM_ADDRESS), SendingCardPage.TEXT_ADDRESS.resolveFor(actor).getValue());
    }
}
