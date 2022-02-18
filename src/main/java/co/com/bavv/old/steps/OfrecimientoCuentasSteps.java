/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.AccountSelection;
import co.com.bavv.old.tasks.BdUser;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.UiAssertions;
import co.com.bavv.old.tasks.ValidateAccountOffering;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class OfrecimientoCuentasSteps {
  @Cuando("el usuario diligencia el formulario con salario {string}")
  public void elUsuarioDiligenciaElFormularioConSalario(String salary) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(TasksGroup.navigateToProductOfferingWithSalary(salary));
  }

  @Entonces(
      "se presentaran las dos cuentas pero sugiriendo la cuenta {string} en lado izquierdo de la pantalla y el texto debe decir {string}")
  public void
      sePresentaranLasDosCuentasPeroSugiriendoLaCuentaEnLadoIzquierdoDeLaPantallaYElTextoDebeDecir(
          String account, String text) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), ValidateAccountOffering.type(account, text));
  }

  @Entonces("solo se muestra la cuenta Pro y el texto debe decir {string}")
  public void soloSeMuestraLaCuentaProYElTextoDebeDecir(String text) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateAccountSelectionWithCat(text));
  }

  @Cuando("el usuario diligencia el formulario con salario igual o superior a {string}")
  public void elUsuarioDiligenciaElFormularioConSalarioIgualOSuperiorA(String salary) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(TasksGroup.navigateToProductOfferingWithSalary(salary));
  }

  @Cuando("que el cliente esta en pantalla Ofrecimiento de cuentas y seleccionó {string}")
  public void queElClienteEstaEnPantallaOfrecimientoDeCuentasYSeleccionó(String account) {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              TasksGroup.navigateToProductOffering(),
              AccountSelection.type(account)
          );
  }

  @Entonces("pasara a pantalla Selección de paquete dinámico Cuenta PRO")
  public void pasaraAPantallaSelecciónDePaqueteDinámicoCuentaPRO() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
             UiAssertions.validateAccoutPackageCharge()
          );
  }

  @Entonces("pasara a pantalla Oferta y aceptación de seguro")
  public void pasaraAPantallaOfertaYAceptaciónDeSeguro() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              UiAssertions.validateInsuranceOffer()
          );
  }
}
