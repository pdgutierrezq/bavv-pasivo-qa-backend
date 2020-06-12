/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

public class GeneralSteps {
  private ActorData actorData;

  @Dado(
      "que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos")
  public void
      queElUsuarioEstaInteresadoEnAdquirirElProductoYEnPantallaSeMuestraElFormularioDeDatos() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            NavegarA.homePage(),
            NavegarA.comenzarSolicitud(),
            FormIdentificacion.validarCargaInicial());
  }

  @Dado("que se obtiene un usuario tipo valido otp {string}")
  public void queSeObtieneUnUsuarioTipoValidoOtp(String otp) {
    ClientConditions clientConditions =
        ClientConditions.builder().validOtp(Boolean.valueOf(otp)).build();

    actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled("usuario tipo " + clientConditions.getValidOtp())
        .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }
}
