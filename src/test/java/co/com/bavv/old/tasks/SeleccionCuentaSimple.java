/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.ProductOfferingPage;
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
        Click.on(ProductOfferingPage.RADIO_SIMPLE),
        Click.on(ProductOfferingPage.BOTON_CONTINUAR_PRODUCTOS));
  }
  public static Performable pro() {
    return Task.where(
        "{0} selecciona cuenta pro",
        Click.on(ProductOfferingPage.RADIO_PRO),
        Click.on(ProductOfferingPage.BOTON_CONTINUAR_PRODUCTOS));
  }
}
