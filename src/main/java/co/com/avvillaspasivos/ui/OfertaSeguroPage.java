package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OfertaSeguroPage {
    private OfertaSeguroPage() {
        throw new IllegalStateException("Utility class");
    }
  public static final Target RADIO_ACEPTA_SEGURO =
      Target.the("Radio Button acepta seguro")
          .located(By.xpath("//mat-radio-button[@value='true']"));
  public static final Target RADIO_RECHAZA_SEGURO =
      Target.the("Radio Button rechaza seguro")
          .located(By.xpath("//mat-radio-button[@value='false']"));
  public static final Target BOTON_CONTINUAR_SEGUROS =
      Target.the("Boton continuar oferta seguros")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
