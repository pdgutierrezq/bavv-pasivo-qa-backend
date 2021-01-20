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

public class PsePage {
    private PsePage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target AMOUNT_TEXT =
        Target.the("Texto  de la inversión")
            .located(By.xpath("//p[@class='info investment']"));

    public static final Target BANK_LIST =
        Target.the("Lista de bancos pse")
            .located(By.xpath("//mat-option"));

    public static final Target BANK_LIST_SELECT =
        Target.the("Select lista de bancos pse")
            .located(By.id("Bank"));

}
