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

public class DeclaringPage {
    private DeclaringPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target DECLARING_FORM =
        Target.the("Formulario declarante")
            .located(By.id("NonDeclaratingQuestionForm"));

    public static final Target POP_UP_BUTTON =
        Target.the("Boton entendido habeas data")
            .located(By.xpath("//button[contains(text(),'ENTENDIDO')]"));

    public static final Target RADIO_SI =
        Target.the("Radio Button SI")
            .located(By.xpath("//mat-radio-button[@value='true']"));

    public static final Target RADIO_NO =
        Target.the("Radio Button SI")
            .located(By.xpath("//mat-radio-button[@value='false']"));

    public static final Target CONTINUE_BUTTON =
        Target.the("Boton continuar declarante")
            .located(By.xpath("//button[contains(text(),' Continuar')]"));

    public static final Target POP_UP_LINK =
        Target.the("Opcion ¿que es?")
            .located(By.xpath("//*[contains(text(),'¿Qué es?')]"));
}
