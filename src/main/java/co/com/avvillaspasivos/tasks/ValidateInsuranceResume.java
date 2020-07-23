/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ResumenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static co.com.avvillaspasivos.util.Constantes.INSURANCE_COST;
import static co.com.avvillaspasivos.util.Constantes.MONEY_CLASS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateInsuranceResume implements Task {

  public static Performable perform() {
    return instrumented(ValidateInsuranceResume.class);
  }

  @Step("{0} valida el resumen de seguro")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Ensure.that(ResumenPage.ARTICLE_INSURANCE).isDisplayed(),
        Ensure.that(
                ResumenPage.ARTICLE_INSURANCE
                    .resolveFor(theActorInTheSpotlight())
                    .findElement(By.className(MONEY_CLASS))
                    .getText())
            .isEqualToIgnoringCase(INSURANCE_COST));
  }
}
