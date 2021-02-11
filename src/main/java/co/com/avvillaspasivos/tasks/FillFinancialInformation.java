/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ContactInformationPage;
import co.com.avvillaspasivos.ui.FinancialInformationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFinancialInformation implements Task {

    public static Performable perfom() {
        return instrumented(FillFinancialInformation.class);
    }

    @Step("{0} Diligencia el formulario de informacion financiera")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Check.whether(FinancialInformationPage.TEXT_ASSETS.resolveFor(actor).getValue().isEmpty())
                .andIfSo(
                    Enter.theValue("89797").into(FinancialInformationPage.TEXT_ASSETS)),
            Check.whether(FinancialInformationPage.TEXT_LIABILITIES.resolveFor(actor).getValue().isEmpty())
                .andIfSo(
                    Enter.theValue("89797").into(FinancialInformationPage.TEXT_LIABILITIES)),
            Check.whether(FinancialInformationPage.TEXT_MONTHLY_EXPENSES.resolveFor(actor).getValue().isEmpty())
                .andIfSo(
                    Enter.theValue("89797").into(FinancialInformationPage.TEXT_MONTHLY_EXPENSES)),
            Check.whether(FinancialInformationPage.TEXT_INCOME_AMOUNT.resolveFor(actor).getValue().isEmpty())
                .andIfSo(
                    Enter.theValue("89797").into(FinancialInformationPage.TEXT_INCOME_AMOUNT)),
            Click.on(FinancialInformationPage.LIST_OPERATION_TYPE),
            Click.on(FinancialInformationPage.LIST_OPTION_NONE),
            Click.on(FinancialInformationPage.RADIO_ADITIONAL_DATA_QUESTION_NO),
            Click.on(ContactInformationPage.BUTTON_CONTINUE));
    }
}
