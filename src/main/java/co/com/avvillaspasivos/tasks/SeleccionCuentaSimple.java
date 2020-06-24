/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ProductOffering;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionCuentaSimple {
  private SeleccionCuentaSimple() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable simple() {
    return Task.where(
        "{0} selecciona cuenta simple",
        Click.on(ProductOffering.RADIO_SIMPLE),
        Click.on(ProductOffering.BOTON_CONTINUAR_PRODUCTOS));
  }
  public static Performable pro() {
    return Task.where(
        "{0} selecciona cuenta pro",
        Click.on(ProductOffering.RADIO_PRO),
        Click.on(ProductOffering.BOTON_CONTINUAR_PRODUCTOS));
  }
}
