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
import co.com.avvillaspasivos.ui.ConfigurationCdtPage;
import co.com.avvillaspasivos.util.SessionVariables;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillConfigurationCdt implements Task {

  public static Performable type() {
    return instrumented(FillConfigurationCdt.class);
  }

  @Step("{0} configura el cdt")
  public <T extends Actor> void performAs(T actor) {
    Faker faker = new Faker();
    ResumeCdtData cdtData =
        ResumeCdtData.builder()
            .amount("10000000")
            .term(String.valueOf(faker.number().numberBetween(90, 999)))
            .build();

    boolean renewal = actor.recall(SessionVariables.RENEWAL.name());

    actor.attemptsTo(
        Enter.theValue(cdtData.getAmount()).into(ConfigurationCdtPage.TEXTBOX_MONTO),
        Enter.theValue(cdtData.getTerm()).into(ConfigurationCdtPage.TEXTBOX_PLAZO),
        Check.whether(renewal)
            .andIfSo(Click.on(ConfigurationCdtPage.RADIO_SI_RENOVAR))
            .otherwise(Click.on(ConfigurationCdtPage.RADIO_NO_RENOVAR)));

    cdtData.setRate(Text.of(ConfigurationCdtPage.TEXT_TASA).viewedBy(actor).resolve());

    actor.attemptsTo(Click.on(ConfigurationCdtPage.BOTON_CONTINUAR));
    actor.remember(SessionVariables.CDT_DATA.name(), cdtData);
  }
}
