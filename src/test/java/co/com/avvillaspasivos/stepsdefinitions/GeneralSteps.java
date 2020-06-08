/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

public class GeneralSteps {
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
}
