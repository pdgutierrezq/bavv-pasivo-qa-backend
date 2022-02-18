/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ChannelEnrollmentPage {
    private ChannelEnrollmentPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target CONTAINER_MAIN =
        Target.the("Contenedor pantalla enrolamiento").located(By.className("channel-enrollment-container"));

}
