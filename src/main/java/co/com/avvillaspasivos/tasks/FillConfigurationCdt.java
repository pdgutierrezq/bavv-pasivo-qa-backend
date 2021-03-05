/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.ResumeCdtData;
import co.com.avvillaspasivos.tasks.uitask.RememberCdtData;
import co.com.avvillaspasivos.ui.ConfigurationCdtPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.EXPIRATION_TAG;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FillConfigurationCdt implements Task {
  private final String period;

  public FillConfigurationCdt(String period) {
    this.period = period;
  }

  public static Performable type(String period) {
    return instrumented(FillConfigurationCdt.class, period);
  }

  @Step("{0} configura el cdt")
  public <T extends Actor> void performAs(T actor) {

    ResumeCdtData cdtData = buildCdtData(period);

    boolean renewal = actor.recall(SessionVariables.RENEWAL.name());

    actor.attemptsTo(
        Enter.theValue(cdtData.getAmount()).into(ConfigurationCdtPage.TEXTBOX_MONTO),
        Enter.theValue(cdtData.getTerm()).into(ConfigurationCdtPage.TEXTBOX_PLAZO),
        Check.whether(the(ConfigurationCdtPage.PERIOD_LIST), isPresent())
            .andIfSo(selectRamdomPeriodItem()),
        Check.whether(renewal)
            .andIfSo(Click.on(ConfigurationCdtPage.RADIO_SI_RENOVAR))
            .otherwise(Click.on(ConfigurationCdtPage.RADIO_NO_RENOVAR)));

    actor.attemptsTo(RememberCdtData.exec(cdtData));

    actor.attemptsTo(Click.on(ConfigurationCdtPage.BOTON_CONTINUAR));
  }

  private ResumeCdtData buildCdtData(String refund) {
    String term = (refund.equals(EXPIRATION_TAG)) ? "100" : "720";
    return ResumeCdtData.builder().amount("10000000").term(term).build();
  }

  public static Performable selectRamdomPeriodItem() {
    return Task.where(
        "{0} selecciona un item de la lista de periodos de forma aleatoria ",
        Click.on(ConfigurationCdtPage.PERIOD_LIST),
        Click.on(ConfigurationCdtPage.PERIOD_LIST_ITEM));
  }
}
