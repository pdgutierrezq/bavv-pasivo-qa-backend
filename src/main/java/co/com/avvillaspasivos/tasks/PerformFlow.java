/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.ui.InsuranceOfferPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.tasks.TasksGroup.navigateToIdentificationForm;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class PerformFlow implements Task {
  private final String accountType;
  private final String insurance;

  public PerformFlow(String accountType, String insurance) {
    this.accountType = accountType;
    this.insurance = insurance;
  }

  public static Performable type(String accountType, String insurance) {
    return instrumented(PerformFlow.class, accountType, insurance);
  }

  @Step("{0} realiza el flujo con  #accountType y #insurance")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData = actor.recall(SessionVariables.DATA_ACTOR.name());
    actor.attemptsTo(GoTo.homePage());
    actor.attemptsTo(
        navigateToIdentificationForm(),
        FormIdentification.fillAndContinue(),
        Waits.loader(),
        PepSelection.option("no"),
        AccountSelection.type(accountType),
        Check.whether(the(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE), isVisible())
            .andIfSo(
                InsuranceSelection.choose(insurance),
                Remember.variable(SessionVariables.INSURANCE.name(), insurance))
            .otherwise(Remember.variable(SessionVariables.INSURANCE.name(), "no acepta")),
        Waits.loader(),
        Autentication.byOtp(),
        Waits.loader(120),
        EditAddress.toSendCard(TAG_NOT_EDIT),
        DeclaringSelection.choose(TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(actorData.isChannels())
            .andIfSo(SavingTips.waitAndGo())
            .otherwise(EnrollmentKey.perform()));

    actor.remember(SessionVariables.ACCOUNT_TYPE.name(), accountType);
  }
}
