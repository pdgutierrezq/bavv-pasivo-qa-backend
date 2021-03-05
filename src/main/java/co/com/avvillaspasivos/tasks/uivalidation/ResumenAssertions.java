/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.uivalidation;

import co.com.avvillaspasivos.model.ResumeCdtData;
import co.com.avvillaspasivos.ui.ResumenCdtPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ResumenAssertions {
  private ResumenAssertions() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validateName(String userName) {
    return Task.where(
        "{0} Valida que coincida el nombre del usuario en el resumen",
        Ensure.that(ResumenCdtPage.RESUMEN_TITLE).text().containsIgnoringCase(userName));
  }

  public static Performable validateCdtDetailValues(String uiAmount, ResumeCdtData cdtData) {
    return Task.where(
        "{0} Valida que tasa y periodo coincidan en el resumen",
        Ensure.that(uiAmount).contains(cdtData.getAmount()),
        Ensure.that(ResumenCdtPage.TEXT_RATE).text().contains(cdtData.getRate()),
        Ensure.that(ResumenCdtPage.TEXT_TERM).text().contains(cdtData.getTerm()));
  }

  public static Performable validateIncomeAccount(String incomeAccount) {
    return Task.where(
        "{0} Valida que contenga el numero de cuenta",
        Check.whether(the(ResumenCdtPage.TEXT_INCOME), containsText(incomeAccount))
            .andIfSo(Ensure.that(ResumenCdtPage.TEXT_INCOME).text().contains(incomeAccount)));
  }

  public static Performable validatePeriod(String period) {
    return Task.where(
        "{0} Valida que contenga el periodo para retiro de rendimientos",
        Ensure.that(ResumenCdtPage.TEXT_INCOME).text().containsIgnoringCase(period));
  }

  public static Performable validateRenewal(boolean renewal) {
    return Task.where(
        "{0} Valida el texto de renovacion en el resumen",
        Check.whether(renewal)
            .andIfSo(Ensure.that(ResumenCdtPage.RENEWAL_TEXT).isDisplayed())
            .otherwise(Ensure.that(ResumenCdtPage.RENEWAL_TEXT).isNotDisplayed()));
  }
}
