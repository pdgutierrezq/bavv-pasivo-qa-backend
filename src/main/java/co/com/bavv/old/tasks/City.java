/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.SendingCardPage;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class City implements Task {

  public static Performable autoComplete() {
    return instrumented(City.class);
  }

  @Step("{0} digita 3 caracteres para autocompletar la ciudad")
  public <T extends Actor> void performAs(T actor) {
    String chars = Constantes.LIST_CITIES.stream().findAny().orElse("BOG").substring(0, 3);

    actor.attemptsTo(
        Enter.theValue(chars).into(SendingCardPage.TEXT_CITY),
        Enter.keyValues(Keys.TAB).into(SendingCardPage.TEXT_CITY));
  }
}
