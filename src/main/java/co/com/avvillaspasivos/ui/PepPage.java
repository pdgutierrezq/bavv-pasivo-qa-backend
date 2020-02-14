package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PepPage {
    private PepPage() {
        throw new IllegalStateException("Utility class");
    }
  public static final Target TEXT_PEP =
      Target.the("Texto pregunta PEP").located(By.xpath("//*[@class='pep-question']"));
}
