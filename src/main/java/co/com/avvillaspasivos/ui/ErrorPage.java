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

public class ErrorPage {

    private ErrorPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target BTN_DONDE_ENCONTRARNOS =
        Target.the("Boton error de proceso").located(By.xpath("//*[contains(text(),'¿DÓNDE ENCONTRARNOS?')]"));

    public static final Target TEXT_MENSAJE_PRINCIPAL =
        Target.the("Texto mensaje pricipal de error de proceso").located(By.xpath("//*[contains(text(),'Lo sentimos, no podemos continuar con tu solicitud')]"));

    public static final Target TEXT_MENSAJE_SECUNDARIO =
        Target.the("Texto mensaje secundario de error de proceso").located(By.xpath("//*[contains(text(),'Debes acercarte a una oficina AV Villas para abrir tu cuenta')]"));
}
