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

public class DeclarantePage {
    private DeclarantePage() {
        throw new IllegalStateException("Utility class");
    }


    public static final Target RADIO_SI =
        Target.the("Radio Button SI")
            .located(By.xpath("//mat-radio-button[@value='true']"));

    public static final Target BOTON_CONTINUAR =
        Target.the("Boton continuar declarante")
            .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
