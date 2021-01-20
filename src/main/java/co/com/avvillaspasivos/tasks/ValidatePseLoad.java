/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.ResumeCdtData;
import co.com.avvillaspasivos.ui.PsePage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidatePseLoad implements Task {

    public static Performable perform() {
        return instrumented(ValidatePseLoad.class);
    }

    @Step("{0} valida la precarga en pantalla Pse")
    public <T extends Actor> void performAs(T actor) {
        String amount= PsePage.AMOUNT_TEXT.resolveFor(actor)
            .getText().replace("$","")
            .replace(".","")
            .replace(",","");

        ResumeCdtData cdtData= actor.recall(SessionVariables.CDT_DATA.name());

        actor.attemptsTo(
            Ensure.that(amount).contains(cdtData.getAmount())
        );
    }
}
