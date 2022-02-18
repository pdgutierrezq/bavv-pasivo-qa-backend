/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.BdUser;
import co.com.bavv.old.tasks.SmallTasks;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.UiAssertions;
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
    theActorInTheSpotlight().attemptsTo(BdUser.toBlock(false), UiAssertions.validatePopUpEs());
  }

  @Cuando("Autorice la firma de documentos")
  public void autoriceLaFirmaDeDocumentos() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.authorizeElectronicSignature());
  }

  @Y("seleccione la opcion continuar")
  public void seleccioneLaOpcionContinuar() {
    theActorInTheSpotlight().attemptsTo(SmallTasks.continueElectronicSignature());
  }

  @Entonces("pasará a pantalla tips de ahorro")
  public void pasaráAPantallaTipsAhorro() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateSavingTipsPageCharge());
  }

  @Entonces("pasará a pantalla de enrolamiento")
  public void pasaráAPantallaDeEnrolamiento() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateChannelEnrollmentPageCharge());
  }

  @Entonces("Se validara la presencia del nombre ingresado en el formulario de identificacion")
  public void seValidaraLaPresenciaDelNombreIngresadoEnElFormularioDeIdentificacion() {
    theActorInTheSpotlight()
        .attemptsTo(BdUser.toBlock(false), UiAssertions.validateNameOnElectronicSign());
  }
}
