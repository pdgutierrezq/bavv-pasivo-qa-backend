package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DataProvider;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class IdentificacionUsuarioStepsDefinitions {

  @Dado("que tengo el {string}, {string} de documento y demás datos de autenticación de un usuario")
  public void queTengoElDeDocumentoYDemásDatosDeAutenticaciónDeUnUsuario(String arg0, String arg1) {
    DataProvider.getUsersIdentification().forEach(System.out::println);
  }

  @Cuando("consumo el servicio rest de identificación")
  public void consumoElServicioRestDeIdentificación() {}

  @Entonces(
      "el servicio se encarga de enviar OTP al usuario o me informa que no pasó alguna validación")
  public void elServicioSeEncargaDeEnviarOTPAlUsuarioOMeInformaQueNoPasóAlgunaValidación() {}
}
