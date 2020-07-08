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

public class SavingTipsPage {
    private SavingTipsPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target ANIMATION =
        Target.the("Animacion de tips de ahorro")
            .located(By.className("lottie-animation"));
}
