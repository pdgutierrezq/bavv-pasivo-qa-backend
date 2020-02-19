package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.OfertaSeguroPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionSeguros {
    private SeleccionSeguros() {
        throw new IllegalStateException("Utility class");
    }

  public static Performable acepta() {
    return Task.where(
        "{0} acepta seguro",
        Click.on(OfertaSeguroPage.RADIO_ACEPTA_SEGURO),
        Click.on(OfertaSeguroPage.BOTON_CONTINUAR_SEGUROS));
  }
}
