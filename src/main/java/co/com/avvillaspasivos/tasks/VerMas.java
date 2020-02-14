package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerMas implements Task {

  private final String text;

  public VerMas(String text) {
    this.text = text;
  }

  public static Performable validate(String text) {
    return instrumented(VerMas.class, text);
  }

  @Step("{0} Se valida pop up de ver mas beneficios")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Ensure.that(ApplicationHomePage.BENEFICIOS_DIALOG).text().contains(text));
  }
}
