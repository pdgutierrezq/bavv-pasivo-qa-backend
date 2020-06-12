/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.facts;

import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class CondicionesCliente implements Fact {
  private String condiciones;

  public static CondicionesCliente consultar() {
    return new CondicionesCliente();
  }

  @Override
  public void setup(Actor actor) {
    BodyGenerarOtp bodyCustCond = BodyGenerarOtp.builder().documentType("CC").documentNumber("8765789").build();
    actor.attemptsTo(CallPost.pathBody(ServicePaths.pathCustomerConditions(), bodyCustCond));
    condiciones = SerenityRest.lastResponse().asString();
    actor.remember("Condiciones", condiciones);
  }

  public String toString() {
    return "Los planes son: " + condiciones;
  }
}
