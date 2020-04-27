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

public class PaqueteProPage {
    private PaqueteProPage() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target LISTA_CAJERO =
        Target.the("Lista retiro cajeros").located(By.id("CashWithdrawalInput"));
    public static final Target LISTA_OFICINA =
        Target.the("Lista retiro oficina").located(By.id("OfficeWithdrawalInput"));
    public static final Target LISTA_OPCIONES =
        Target.the("Lista opciones ").located(By.xpath("//*[contains(@id,'mat-option') and @ng-reflect-value='2']"));
    public static final Target  BOTON_CONTINUAR =
        Target.the("Boton continuar Paquete Pro").located(By.xpath("//button[contains(text(),' Continuar')]"));
}
