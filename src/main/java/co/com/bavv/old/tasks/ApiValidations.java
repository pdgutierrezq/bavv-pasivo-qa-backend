/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import org.hamcrest.Matchers;
import org.seleniumhq.jetty9.http.HttpStatus;

public class ApiValidations {
  private ApiValidations() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable customerAccounts() {
      ActorData actorData = OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
    return Task.where(
        "{0} valida que coincida los datos de las cuentas con lo esperado",
        Ensure.that("status code is 200", response -> response.statusCode(HttpStatus.OK_200)),
        Ensure.that(
            "Se confirma que el usuario tiene cuenta tipo cat ->"
                .concat(String.valueOf(actorData.isCat())),
            response -> response.body("hasCAT", Matchers.is(actorData.isCat()))));
  }

  public static Performable customerConditions() {
    return Task.where(
        "{0} valida estado correcto",
        Ensure.that("status code is 200", response -> response.statusCode(HttpStatus.OK_200)));
  }
}
