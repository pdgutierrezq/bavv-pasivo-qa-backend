/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */
package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.BodySaveResumeCdt;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveResumeCdt implements Task {

  public static Performable post() {
    return instrumented(SaveResumeCdt.class);
  }

  @Override
  @Step("{0} almacena informacion en base de datos para el resumen de cdt")
  public <T extends Actor> void performAs(T actor) {

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.DEV_ENV)));

    BodySaveResumeCdt bodySaveResumeCdt = getGenericBody();

    actor.attemptsTo(CallPostWith.token("save-resumes-cdt", bodySaveResumeCdt));

    actor.remember(SessionVariables.CDT_RESUME_DATA.name(),bodySaveResumeCdt);
  }

    public static BodySaveResumeCdt getGenericBody() {
    Faker faker = new Faker();

    return BodySaveResumeCdt.builder()
        .productNumber(Integer.parseInt(faker.number().digits(8)))
        .returnType(faker.pokemon().name())
        .state(faker.number().digits(4))
        .build();
  }
}
