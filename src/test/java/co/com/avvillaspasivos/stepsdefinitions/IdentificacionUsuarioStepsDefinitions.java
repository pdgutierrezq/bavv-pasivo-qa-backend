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
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class IdentificacionUsuarioStepsDefinitions {

  @Dado("que tengo el {string}, {string} de documento y demas datos de autenticacion de un usuario")
  public void queTengoElDeDocumentoYDemasDatosDeAutenticacionDeUnUsuario(String arg0, String arg1) {
    DataProvider.getUsersIdentification().forEach(System.out::println);
  }

  @Cuando("consumo el servicio rest de identificacion")
  public void consumoElServicioRestDeIdentificacion() {}

  @Entonces(
      "el servicio se encarga de enviar OTP al usuario o me informa que no paso alguna validacion")
  public void elServicioSeEncargaDeEnviarOTPAlUsuarioOMeInformaQueNoPasoAlgunaValidacion() {}

}
