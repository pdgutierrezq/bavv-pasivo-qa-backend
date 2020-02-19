package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.OfertaProductosPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionCuenta {
    private SeleccionCuenta() {
        throw new IllegalStateException("Utility class");
    }
  public static Performable simple() {
    return Task.where(
        "{0} selecciona cuenta simple",
        Click.on(OfertaProductosPage.RADIO_SIMPLE),
        Click.on(OfertaProductosPage.BOTON_CONTINUAR_PRODUCTOS));
  }
}
