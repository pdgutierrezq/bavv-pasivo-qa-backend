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
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateInsuranceResume implements Task {

  public static Performable perform() {
    return instrumented(ValidateInsuranceResume.class);
  }

  @Step("{0} valida el resumen de seguro")
  public <T extends Actor> void performAs(T actor) {
    String insurance = theActorInTheSpotlight().recall(String.valueOf(SessionVariables.INSURANCE));

    if (Constantes.TAG_ACCEPT.equalsIgnoreCase(insurance)) {
      actor.attemptsTo(
          Ensure.that(ResumenPage.ARTICLE_INSURANCE).isDisplayed(),
          Ensure.that(
                  ResumenPage.ARTICLE_INSURANCE
                      .resolveFor(theActorInTheSpotlight())
                      .findElement(By.className(Constantes.MONEY_CLASS))
                      .getText())
              .isEqualToIgnoringCase(Constantes.INSURANCE_COST));
    } else {
      actor.attemptsTo(Ensure.that(ResumenPage.ARTICLE_INSURANCE).isNotDisplayed());
    }
  }
}
