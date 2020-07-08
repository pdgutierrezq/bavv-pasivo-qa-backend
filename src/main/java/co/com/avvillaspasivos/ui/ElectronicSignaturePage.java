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

public class ElectronicSignaturePage {
    private ElectronicSignaturePage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target POP_UP_ES =
        Target.the("Enlace para abrir pop pup")
            .located(By.xpath("//*[@role='dialog']"));
    public static final Target POP_UP_LINK =
        Target.the("Enlace para abrir pop pup")
            .located(By.xpath("//*[contains(text(),'¿Qué es?')]"));
    public static final Target CONTINUE_BUTTON =
        Target.the("Boton continuar direccion")
            .located(By.xpath("//button[contains(text(),' Continuar')]"));
    public static final Target CHECK_AUTORIZATION =
        Target.the("Boton continuar direccion")
            .located(By.id("DigitalSignatureCheck"));
}
