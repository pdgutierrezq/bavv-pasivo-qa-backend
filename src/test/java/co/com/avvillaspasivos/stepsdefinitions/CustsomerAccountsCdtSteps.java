/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.GetFlowDataActor;
import co.com.avvillaspasivos.tasks.apitask.ClientAccountsApi;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.interactions.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class CustsomerAccountsCdtSteps {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que se obtiene un usuario {string}")
  public void queSeObtieneUnUsuario(String customerType) {
    theActorCalled(customerType).attemptsTo(GetFlowDataActor.type(customerType));
  }

  @Cuando("consulta las cuentas del cliente con monto {int}")
  public void consultaLasCuentasDelClienteConMonto(int amount) {
    OnStage.theActorInTheSpotlight().attemptsTo(ClientAccountsApi.post(amount));
  }

  @Entonces("se validara que no hay cuentas con saldo disponibles para fondear")
  public void seValidaraQueNoHayCuentasConSaldoDisponiblesParaFondear() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(
                "Se valida que no hay cuentas para fondear",
                response -> response.body("accounts.fundingAcc", not(hasItem(true)))));
  }

  @Entonces("se validara que si hay cuentas con saldo disponibles para fondear")
  public void seValidaraQueSiHayCuentasConSaldoDisponiblesParaFondear() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(
                "Se valida que si hay cuentas para fondear",
                response -> response.body("accounts.fundingAcc", hasItem(true))));
  }

  @Cuando("consulta las cuentas del cliente")
  public void consultaLasCuentasDelCliente() {
      OnStage.theActorInTheSpotlight().attemptsTo(ClientAccountsApi.post(10000));
  }

  @Entonces("se validara que no tiene cuentas disponibles")
  public void seValidaraQueNoTieneCuentasDisponibles() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(
                "Se valida que el usuario no tiene cuentas ",
                response -> response.body("accounts.fundingAcc", hasSize(0))));
  }
}
