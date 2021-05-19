/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.ui.ResumenCdtPage;
import co.com.avvillaspasivos.ui.ResumenPage;
import co.com.avvillaspasivos.util.Constantes;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Waits {

  private Waits() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable loader() {
    return Task.where(
        "{0} espera elemento de carga",
        Check.whether(the(CommonWebElementsPage.LOADER), isVisible())
            .andIfSo(
                WaitUntil.the(CommonWebElementsPage.LOADER, isNotVisible())
                    .forNoMoreThan(Constantes.MAX_WAIT)
                    .seconds()));
  }

  public static Performable infoAccount() {
    return Task.where(
        "{0} espera informacion de la cuenta",
        loader(),
        WaitUntil.the(ResumenPage.INFO_ACCOUNT, isVisible())
            .forNoMoreThan(Constantes.MAX_WAIT)
            .seconds());
  }

  public static Performable resumenPage() {
    return Task.where(
        "{0} espera carga de la pagina de resumen",
        WaitUntil.the(ResumenCdtPage.TEXT_AMOUNT, isVisible())
            .forNoMoreThan(Constantes.MAX_WAIT)
            .seconds());
  }

  public static Performable loader(int time) {
    return Task.where(
        "{0} espera elemento de carga",
        WaitUntil.the(CommonWebElementsPage.LOADER, isCurrentlyVisible())
            .forNoMoreThan(time)
            .seconds(),
        WaitUntil.the(CommonWebElementsPage.LOADER, isNotVisible()).forNoMoreThan(time).seconds());
  }
}
