/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.facts.Usuario;
import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.util.SessionVariables;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUpdateCrmClient implements Task {

  public static Performable perform() {
    return instrumented(GetUpdateCrmClient.class);
  }

  @Override
  @Step("{0} obtiene cedula para actualizar crm")
  public <T extends Actor> void performAs(T actor) {
    Faker faker = new Faker();

    int numDoc = 1018450000 + faker.number().numberBetween(1, 9999);

    ActorData actorData =
        ActorData.builder().documentType("CC").documentNumber(String.valueOf(numDoc)).build();

    actor.remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    actor.has(Usuario.informacion());
  }
}
