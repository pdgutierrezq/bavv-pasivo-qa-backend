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

public class ResumenPage {
    private ResumenPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target BOTON_ENTENDIDO =
        Target.the("Boton entendido resumen")
            .located(By.xpath("//*[contains(text(),'ENTENDIDO')]"));
}