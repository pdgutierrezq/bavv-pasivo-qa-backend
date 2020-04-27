/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallPost implements Task {

  private final String path;
  private final Object body;

  public CallPost(String path, Object body) {
    this.path = path;
    this.body = body;
  }

  public static Performable pathBody(String path, Object body) {
    return instrumented(CallPost.class, path, body);
  }

  @Override
  @Step("{0} llama servicio Post")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(path)
            .with(
                requestSpecification ->
                    requestSpecification
                        .header("Content-Type","application/json")
                        .body(body)));
  }
}
