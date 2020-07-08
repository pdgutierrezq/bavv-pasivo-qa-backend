/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.SmallTasks;
import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.UiAssertions;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ElectronicaSignatureSteps {
  @Dado("que el usuario esta en pantalla de firma electronica")
  public void queElUsuarioEstaEnPantallaDeFirmaElectronica() {
    theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToElectronicSignatureScreen());
  }

  @Cuando("ingrese en la opcion ¿Que es?")
  public void ingreseEnLaOpcionQueEs() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.popUpElectronicSignature());
  }

  @Entonces("se desplegará lo que es firmar electrónicamente")
  public void seDesplegaráLoQueEsFirmarElectrónicamente() {
    theActorInTheSpotlight().attemptsTo(UiAssertions.validatePopUpEs());
  }

  @Cuando("Autorice la firma de documentos")
  public void autoriceLaFirmaDeDocumentos() {
    theActorInTheSpotlight().attemptsTo(
        SmallTasks.authorizeElectronicSignature()
    );
  }

  @Y("seleccione la opcion continuar")
  public void seleccioneLaOpcionContinuar() {
      theActorInTheSpotlight()
          .attemptsTo(
              SmallTasks.continueElectronicSignature()
          );

  }

  @Entonces("pasará a pantalla tips de ahorro")
  public void pasaráAPantallaTipsAhorro() {
    theActorInTheSpotlight()
        .attemptsTo(
            UiAssertions.validateSavingTipsPageCharge()
        );
  }
}
