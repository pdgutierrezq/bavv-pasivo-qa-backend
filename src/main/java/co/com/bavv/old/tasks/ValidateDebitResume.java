/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.ResumenPage;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateDebitResume implements Task {

  public static Performable perform() {
    return instrumented(ValidateInsuranceResume.class);
  }

  @Step("{0} valida el resumen de debito")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Ensure.that(ResumenPage.ARTICLE_DEBIT).isDisplayed(),
        Ensure.that(
                ResumenPage.ARTICLE_DEBIT
                    .resolveFor(theActorInTheSpotlight())
                    .findElement(By.className(Constantes.MONEY_CLASS))
                    .getText())
            .isEqualToIgnoringCase(Constantes.INSURANCE_COST),
        Ensure.that(ResumenPage.GO_NOW_BUTTON).isDisplayed());
  }
}
