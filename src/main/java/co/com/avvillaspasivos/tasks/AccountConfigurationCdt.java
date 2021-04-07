/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.AccountConfigurationPageCdt;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.ACCOUNT_FUNDING_TAG;
import static co.com.avvillaspasivos.util.Constantes.NEW_ACCOUNT_PROFIT_TAG;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AccountConfigurationCdt implements Task {
  private final String fundingType;
  private final String profit;

  public AccountConfigurationCdt(String fundingType, String profit) {
    this.fundingType = fundingType;
    this.profit = profit;
  }

  public static Performable perform(String fundingType,String profit) {
    return instrumented(AccountConfigurationCdt.class, fundingType,profit);
  }

  @Step("{0} selecciona cuenta #tipocuenta")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Check.whether(fundingType.equals(ACCOUNT_FUNDING_TAG))
            .andIfSo(Click.on(AccountConfigurationPageCdt.RADIO_ACCOUNT_TRANSF))
            .otherwise(Click.on(AccountConfigurationPageCdt.RADIO_PSE_TRANSF)),
        Check.whether(profit.equals(NEW_ACCOUNT_PROFIT_TAG))
        .andIfSo(
            Click.on(AccountConfigurationPageCdt.RADIO_NEW_ACCOUNT_PROFIT)
        ).otherwise(
            Scroll.to(AccountConfigurationPageCdt.RADIO_ACCOUNT_PROFIT),
            Click.on(AccountConfigurationPageCdt.RADIO_ACCOUNT_PROFIT)
        ),
        Scroll.to(AccountConfigurationPageCdt.CONTINUE_BUTTON));

    String incomeAccount =
        Text.of(AccountConfigurationPageCdt.RADIO_ACCOUNT_PROFIT).viewedBy(actor).resolve();

    actor.remember(
        SessionVariables.INCOME_ACCOUNT.name(),
        incomeAccount.substring(incomeAccount.lastIndexOf('*') + 1));

    actor.attemptsTo(
        Click.on(AccountConfigurationPageCdt.CONTINUE_BUTTON),
        Check.whether(fundingType.equals(ACCOUNT_FUNDING_TAG))
            .andIfSo(Click.on(AccountConfigurationPageCdt.BOTON_POPUP_OK)));
  }
}
