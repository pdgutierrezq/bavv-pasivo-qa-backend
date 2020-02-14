package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Esperas {

  private Esperas() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable loader() {
    return Task.where(
        "{0} espera elemento de carga",
        WaitUntil.the(CommonWebElementsPage.LOADER, isVisible()),
        WaitUntil.the(CommonWebElementsPage.LOADER, isNotVisible()));
  }

  public static Performable captchaReady() {
    return Task.where(
        "{0} espera que el captcha este listo en el formulario de identificacion",
        WaitUntil.angularRequestsHaveFinished());
  }
}
