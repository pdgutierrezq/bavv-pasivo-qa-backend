/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Remember implements Task {
  private final String variable;
  private final Object value;

  public Remember(String variable, Object value) {
    this.variable = variable;
    this.value = value;
  }

  public static Performable variable(String variable, Object value) {
    return instrumented(Remember.class, variable, value);
  }

  @Step("{0} almacena variable de sesion #variable con valor #value")
  public <T extends Actor> void performAs(T actor) {
    actor.remember(variable, value);
  }
}
