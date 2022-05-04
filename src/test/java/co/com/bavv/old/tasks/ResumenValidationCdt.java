/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.ResumeCdtData;
import co.com.bavv.old.ui.ResumenCdtPage;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.SessionVariables;
import co.com.bavv.old.tasks.uivalidation.ResumenAssertions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ResumenValidationCdt implements Task {

  public static Performable perform() {
    return instrumented(ResumenValidationCdt.class);
  }

  @Step("{0} valida el resumen de CDT ")
  public <T extends Actor> void performAs(T actor) {
    ResumeCdtData cdtData = getResumenData();
    String incomeAccount = getIncomeAccount();
    ActorData actorData = ActorActions.getActorInTheSpotLightData();
    boolean renewal = actor.recall(SessionVariables.RENEWAL.name());

    actor.attemptsTo(Waits.resumenPage());

    String uiAmount = getResumenUiAmount(actor);

    actor.attemptsTo(
        ResumenAssertions.validateName(actorData.getFirstName()),
        ResumenAssertions.validateCdtDetailValues(uiAmount, cdtData));

    actor.attemptsTo(
        ResumenAssertions.validateIncomeAccount(incomeAccount),
        ResumenAssertions.validatePeriod(cdtData.getPeriod()));

    actor.attemptsTo(ResumenAssertions.validateRenewal(renewal));

    actor.attemptsTo(BdUser.toBlock(false));
  }

  private static ResumeCdtData getResumenData() {
    return theActorInTheSpotlight().recall(SessionVariables.CDT_DATA.name());
  }

  private static String getResumenUiAmount(Actor actor) {
    return ResumenCdtPage.TEXT_AMOUNT.resolveFor(actor).getText().replace("$", "").replace(".", "");
  }

  private static String getIncomeAccount() {
    return theActorInTheSpotlight().recall(SessionVariables.INCOME_ACCOUNT.name());
  }
}
