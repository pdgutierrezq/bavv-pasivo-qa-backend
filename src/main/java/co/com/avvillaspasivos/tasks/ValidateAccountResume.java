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
import co.com.avvillaspasivos.ui.ResumenPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateAccountResume implements Task {

  public static Performable perform() {
    return instrumented(ValidateAccountResume.class);
  }

  @Step("{0} valida el resumen de cuenta")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData =
        theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

    String accountType =
        theActorInTheSpotlight().recall(String.valueOf(SessionVariables.ACCOUNT_TYPE));

    actor.attemptsTo(
        Ensure.that(ResumenPage.RESUMEN_TITLE)
            .text()
            .containsIgnoringCase(actorData.getFirstName()),
        Ensure.that(ResumenPage.ARTICLE_ACCOUNT).isDisplayed(),
        Ensure.that(
                ResumenPage.ARTICLE_ACCOUNT
                    .resolveFor(theActorInTheSpotlight())
                    .thenFind(RESUMEN_TITLE_XPATH)
                    .getText())
            .isEqualToIgnoringCase(accountType),
        Ensure.that(
                ResumenPage.ARTICLE_ACCOUNT
                    .resolveFor(theActorInTheSpotlight())
                    .findElement(By.className(ACCOUNT_NUMBER_CLASS))
                    .isDisplayed())
            .isTrue(),
        Ensure.that(
                ResumenPage.ARTICLE_ACCOUNT
                    .resolveFor(theActorInTheSpotlight())
                    .findElement(By.className(MONEY_CLASS))
                    .getText())
            .isEqualToIgnoringCase(MONTH_COST_VALUE),
        Ensure.that(ResumenPage.ARTICLE_ACCOUNT).text().contains(WITHDRAWALS_TEXT));
  }
}
