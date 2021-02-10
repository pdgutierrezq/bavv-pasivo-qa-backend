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

public class ForeignValidationPage {
    private ForeignValidationPage   () {
        throw new IllegalStateException("Utility class");
    }

    public static final Target BUTTON_CONTINUE =
        Target.the("Boton continuar validacion del extranjero")
            .located(By.xpath("//button[contains(text(),' Continuar')]"));

    public static final Target RADIO_FISCAL_NO =
        Target.the("Radio button con opcion No").located(By.xpath("(//mat-radio-button[@value='false'])[1]"));

    public static final Target RADIO_GREEN_CARD_NO =
        Target.the("Radio green con opcion No").located(By.xpath("(//mat-radio-button[@value='false'])[2]"));

    public static final Target RADIO_PERMANENCY_ACTUAL_YEAR_NO =
        Target.the("Radio permanencia ultimo año con opcion No").located(By.xpath("(//mat-radio-button[@value='false'])[3]"));

    public static final Target RADIO_PERMANENCY_THREE_YEAR_NO =
        Target.the("Radio permanencia ultimos tres años con opcion No").located(By.xpath("(//mat-radio-button[@value='false'])[4]"));
}
