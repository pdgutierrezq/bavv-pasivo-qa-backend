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
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeclaringScreenSteps {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Cuando("selecciona la opción cerrar o entendido")
  public void seleccionaLaOpciónCerrarOEntendido() {
      theActorInTheSpotlight()
          .attemptsTo(
              SmallTasks.closeDeclaringPopUp()
          );
  }

  @Y("que el usuario esta en POP-UP de lo que es una persona declarante")
  public void queElUsuarioEstaEnPOPUPDeLoQueEsUnaPersonaDeclarante() {
    theActorInTheSpotlight()
        .attemptsTo(TasksGroup.navigateToDeclaringScreen(false,false), SmallTasks.popUpDeclaring());
  }

  @Entonces("se cierra el POP-UP quedando el cliente en la pantalla de pregunta declarante")
  public void seCierraElPOPUPQuedandoElClienteEnLaPantallaDePreguntaDeclarante() {
      theActorInTheSpotlight()
          .attemptsTo(
              UiAssertions.validateDeclaringPopUpClosed()
          );
  }

    @Y("el usuario esta en pantalla pregunta de declarante")
    public void elUsuarioEstaEnPantallaPreguntaDeDeclarante() {
        theActorInTheSpotlight()
            .attemptsTo(TasksGroup.navigateToDeclaringScreen(false,false));
    }

    @Cuando("selecciona la opcion continuar")
    public void seleccionaLaOpcionContinuar() {
      theActorInTheSpotlight()
          .attemptsTo(
              SmallTasks.declarationSelect()
          );
    }

    @Entonces("pasará a pantalla de firma electrónica")
    public void pasaráAPantallaDeFirmaElectrónica() {
      theActorInTheSpotlight()
          .attemptsTo(
              UiAssertions.validateDigitalSignatureCharge()
          );
    }
}
