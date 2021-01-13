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
import co.com.avvillaspasivos.model.ResumeCdtData;
import co.com.avvillaspasivos.ui.ResumenCdtPage;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ResumenValidationCdt implements Task {

  public static Performable perform() {
    return instrumented(ResumenValidationCdt.class);
  }

  @Step("{0} valida el resumen de CDT ")
  public <T extends Actor> void performAs(T actor) {
    ResumeCdtData cdtData = theActorInTheSpotlight().recall(SessionVariables.CDT_DATA.name());
    String incomeAccount = theActorInTheSpotlight().recall(SessionVariables.INCOME_ACCOUNT.name());
    ActorData actorData =
        theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));

    boolean renewal=actor.recall(SessionVariables.RENEWAL.name());

      actor.attemptsTo(
          WaitUntil.the(ResumenCdtPage.TEXT_AMOUNT, isVisible())
          .forNoMoreThan(Constantes.MAX_WAIT)
          .seconds()
      );

      String amount=ResumenCdtPage.TEXT_AMOUNT.resolveFor(actor).getText().replace("$","").replace(".","");

      actor.attemptsTo(
        Ensure.that(ResumenCdtPage.RESUMEN_TITLE)
            .text()
            .containsIgnoringCase(actorData.getFirstName()),
        Ensure.that(amount).contains(cdtData.getAmount()),
        Ensure.that(ResumenCdtPage.TEXT_RATE).text().contains(cdtData.getRate()),
        Ensure.that(ResumenCdtPage.TEXT_TERM).text().contains(cdtData.getTerm())


    );
    actor.attemptsTo(
        Check.whether(the(ResumenCdtPage.TEXT_INCOME),containsText(incomeAccount))
            .andIfSo(Ensure.that(ResumenCdtPage.TEXT_INCOME).text().contains(incomeAccount))
    );
    actor.attemptsTo(
        Check.whether(renewal)
            .andIfSo(Ensure.that(ResumenCdtPage.RENEWAL_TEXT).isDisplayed())
            .otherwise(Ensure.that(ResumenCdtPage.RENEWAL_TEXT).isNotDisplayed())
    );

    actor.attemptsTo(BdUser.toBlock(false));
  }
}
