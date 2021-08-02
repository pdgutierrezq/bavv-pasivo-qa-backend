/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.uitask;

import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.ui.SavingTipsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.tasks.TasksGroup.avoidRetryPopUp;
import static co.com.avvillaspasivos.tasks.TasksGroup.navigateToIdentificationFormCdt;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CreateCdtWithNewAccount implements Task {

  public static Performable exec() {
    return instrumented(CreateCdtWithNewAccount.class);
  }

  @Step("{0} se crea cdt con cuenta nueva para rendimientos")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(PRODUCT_CDT),
        Waits.loader(),
        avoidRetryPopUp(),
        FillConfigurationCdt.type("ANY"),
        Waits.loader(),
        Autentication.byOtp(),
        Waits.loader(120),
        AccountConfigurationCdt.perform(ACCOUNT_FUNDING_TAG, NEW_ACCOUNT_PROFIT_TAG),
        EditAddress.toSendCard(),
        DeclaringSelection.choose(TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(the(SavingTipsPage.CONTINUE_BUTTON), isPresent())
            .andIfSo(SavingTips.waitAndGo())
            .otherwise(EnrollmentKey.perform()));
  }
}
