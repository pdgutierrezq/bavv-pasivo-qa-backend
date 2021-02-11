/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SendingCardPage {
  private SendingCardPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar direccion")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
  public static final Target FORM_ADDRESS =
      Target.the("Formulario direccion de entrega").located(By.className("box-delivery-address"));
  public static final Target TEXT_CITY =
      Target.the("Campo de texto de ciudad").located(By.id("DeliveryCity"));
  public static final Target LIST_CITIES =
      Target.the("Lista de ciudades").located(By.xpath("//*[@role='option']"));
  public static final Target LIST_TEXT_CITIES =
      Target.the("Lista de texto de ciudades")
          .located(By.xpath("//div[@role='listbox']/*[@role='option']/span"));
  public static final Target TEXT_ADDRESS =
      Target.the("Campo de texto de ciudad").located(By.id("DeliveryAddress"));
  public static final Target POP_UP =
      Target.the("Pop up de direccion de envio").located(By.xpath("//*[@role='dialog']"));
  public static final Target POP_UP_ACCEPT =
      Target.the("Aceptar cambio de direccion").located(By.id("AcceptChangeDeliveryAddressButton"));
  public static final Target POP_UP_REJECT =
      Target.the("Cancelar cambio de direccion")
          .located(By.id("CancelChangeDeliveryAddressButton"));
}
