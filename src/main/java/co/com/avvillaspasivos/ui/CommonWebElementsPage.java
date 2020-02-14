package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonWebElementsPage {

  private CommonWebElementsPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target LOADER =
      Target.the("Elemento de carga").located(By.className("loading"));
}
