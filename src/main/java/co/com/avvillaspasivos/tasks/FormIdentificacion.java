/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.IdentificacionPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;

import static co.com.avvillaspasivos.util.Constantes.TEXTO_SUPERIOR_LIMITE_TAMANIO;

public class FormIdentificacion {

  private FormIdentificacion() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable diligenciar() {
    return Task.where(
        "{0} diligencia formulario",
        Enter.theValue("79338822").into(IdentificacionPage.DNI_INPUT),
        Enter.theValue("3195214574").into(IdentificacionPage.CELULAR_INPUT).thenHit(Keys.TAB),
        Enter.theValue("3195214574").into(IdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue("EDUARDO").into(IdentificacionPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue("CASTRO").into(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue("1600000").into(IdentificacionPage.INGRESOS_INPUT),
        Click.on(IdentificacionPage.HABEAS_DATA_CHECKBOX));
  }

  public static Performable digitarCelularErrado() {
    return Task.where(
        "{0} diligencia formulario",
        Enter.theValue("31601234567").into(IdentificacionPage.CELULAR_INPUT).thenHit(Keys.TAB));
  }

  public static Performable noDiligenciar() {
    return Task.where(
        "{0}  no diligencia formulario",
        Click.on(IdentificacionPage.DNI_INPUT),
        Click.on(IdentificacionPage.CELULAR_INPUT),
        Click.on(IdentificacionPage.PRIMER_NOMBRE_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.DNI_INPUT));
  }

  public static Performable simularRobot() {
    return Task.where(
        "{0} simulña comportamiento sospechoso tipo robot ",
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(IdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(IdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(IdentificacionPage.CELULAR_CONFIRMACION_INPUT));
  }

  public static Performable validarCargaInicial() {
    return Task.where(
        "{0} valida carga de pagina identificacion",
        Ensure.that(IdentificacionPage.CONTINUAR_BUTTON).isDisabled(),
        Ensure.that(IdentificacionPage.CELULAR_CONFIRMACION_INPUT).isDisabled());
  }

  public static Performable ingresarTextoFueraDelLimite() {
    return Task.where(
        "{0} diligencia campos de texto con mas de 20 caracteres",
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO).into(IdentificacionPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO)
            .into(IdentificacionPage.PRIMER_APELLIDO_INPUT));
  }

  public static Performable copiarPegarTelefono() {
    return Task.where(
        "{0} diligencia campo de telefono , se copia y se pega en confirmacion de telefono",
        Enter.theValue("3167998941").into(IdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "a").into(IdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "c").into(IdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "v").into(IdentificacionPage.CELULAR_INPUT),
        Enter.keyValues(Keys.COMMAND + "v").into(IdentificacionPage.CELULAR_CONFIRMACION_INPUT));
  }
}
