/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apivalidation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateDeletedResumeCDT implements Task {

  public static Performable perform() {
    return instrumented(ValidateDeletedResumeCDT.class);
  }

  @Override
  @Step("{0} valida la información guardada en base de datos para el resumen de CDT no exista ")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Ensure.that(
            "Se valida que no hay informacion en base de datos",
            response -> response.body("errorMessage", Matchers.is("No existen registros de este documentNumber para CDT en la base de datos"))));
  }
}
