package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class BeneficiosLanding {

  private BeneficiosLanding() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable verMas() {
    return Task.where(
        "{0} ingresa a opcion ver mas beneficios en landing page",
        Click.on(ApplicationHomePage.VERMAS_BUTTON));
  }
}
