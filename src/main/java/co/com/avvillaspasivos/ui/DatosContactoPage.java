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

public class DatosContactoPage {
    private DatosContactoPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target BOTON_CONTINUAR =
        Target.the("Boton continuar direccion")
            .located(By.xpath("//button[contains(text(),' Continuar')]"));

    public static final Target TEXTBOX_CORREO =
        Target.the("Textbox correo")
            .located(By.id("Email"));

    public static final Target TEXTBOX_COPIA_CORREO =
        Target.the("Textbox confirma correo")
            .located(By.id("EmailConfirm"));

    public static final Target TEXTBOX_TELEFONO =
        Target.the("Textbox telefono")
            .located(By.id("LandlinePhone"));

    public static final Target TEXTBOX_DIRECCION =
        Target.the("Textbox direccion")
            .located(By.id("HomeAddress"));

    public static final Target TEXTBOX_CIUDAD =
        Target.the("Textbox ciudad")
            .located(By.id("HomeCity"));

}
