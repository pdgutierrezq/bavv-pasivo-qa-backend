/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AutenticacionPage {
    private AutenticacionPage() {
    throw new IllegalStateException("Utility class");
}
    public static final Target LIST_OTP_INPUT =
        Target.the("Campos de texto de codigo OTP").located(By.xpath("(//*[contains(@class,'mat-input-element')])[1]"));

    public static final Target CONTINUAR_BUTTON =
        Target.the("Boton continuar OTP").located(By.xpath("//button[contains(text(),'Continuar')]"));
}
