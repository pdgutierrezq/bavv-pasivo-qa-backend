/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.uitask;

import co.com.bavv.old.tasks.AccountConfigurationCdt;
import co.com.bavv.old.tasks.Autentication;
import co.com.bavv.old.tasks.DeclaringSelection;
import co.com.bavv.old.tasks.EditAddress;
import co.com.bavv.old.tasks.EnrollmentKey;
import co.com.bavv.old.tasks.FillConfigurationCdt;
import co.com.bavv.old.tasks.FormIdentification;
import co.com.bavv.old.tasks.PepSelection;
import co.com.bavv.old.tasks.SavingTips;
import co.com.bavv.old.tasks.SignDocuments;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.Waits;
import co.com.bavv.old.ui.CdtFeaturesPage;
import co.com.bavv.old.ui.SavingTipsPage;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Step;

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
        TasksGroup.navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(Constantes.PRODUCT_CDT),
        Waits.loader(),
        PepSelection.option("no"),
        FillConfigurationCdt.type("ANY"),
        Waits.loader(),
        Autentication.byOtp(),
        Waits.loader(120),
        AccountConfigurationCdt.perform(
            Constantes.ACCOUNT_FUNDING_TAG, Constantes.NEW_ACCOUNT_PROFIT_TAG),
        EditAddress.toSendCard(),
        Click.on(CdtFeaturesPage.CONTINUE_BUTTON),
        DeclaringSelection.choose(Constantes.TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(WebElementQuestion.the(SavingTipsPage.CONTINUE_BUTTON), isPresent())
            .andIfSo(SavingTips.waitAndGo())
            .otherwise(EnrollmentKey.perform()));
  }
}
