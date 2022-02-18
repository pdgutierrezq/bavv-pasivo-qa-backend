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

import co.com.bavv.old.ui.ProductOfferingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateAccountOffering implements Task {
    private final String accountType;
    private final String text;

    public ValidateAccountOffering(String accountType, String text) {
        this.accountType = accountType;
        this.text = text;
    }

    public static Performable type(String accountType,String text) {
        return instrumented(ValidateAccountOffering.class, accountType,text);
    }

    @Step("{0} selecciona cuenta #accountType y texto #text")
    public <T extends Actor> void performAs(T actor) {
        if ("SIMPLE".equalsIgnoreCase(accountType)) {
            actor.attemptsTo(
                UiAssertions.validateAccountOffering(text,accountType, ProductOfferingPage.RADIO_CIRCLE_SIMPLE)
            );
        } else if ("PRO".equalsIgnoreCase(accountType)) {
            actor.attemptsTo(
                UiAssertions.validateAccountOffering(text,accountType,ProductOfferingPage.RADIO_CIRCLE_PRO)
            );
        }
    }
}
