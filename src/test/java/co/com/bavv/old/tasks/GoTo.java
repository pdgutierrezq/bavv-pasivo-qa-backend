/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.ApplicationHomePage;
import co.com.bavv.old.ui.CdtHomePage;
import co.com.bavv.old.ui.PepPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class GoTo {

    private GoTo() {
        throw new IllegalStateException("Utility class");
    }

    public static Performable homePage() {
        return Task.where("{0} abre landing page", Open.browserOn().the(ApplicationHomePage.class));
    }

    public static Performable homePageCdt() {
        return Task.where("{0} abre landing page CDT", Open.browserOn().the(CdtHomePage.class));
    }

    public static Performable openAccount() {
        return Task.where(
            "{0} ingresa en comenzar solicitud",
            Click.on(ApplicationHomePage.BOTON_ABRIR_MI_CUENTA));
    }

    public static Performable openCdt() {
        return Task.where(
            "{0} ingresa en la opcion abrir Cdt",
            Enter.theValue("500000").into(CdtHomePage.INPUT_AMOUNT),
            Enter.theValue("99").into(CdtHomePage.INPUT_TERM),
            Waits.loader(),
            Click.on(CdtHomePage.OPEN_CDT_BUTTON));
    }

    public static Performable pepContinue() {
        return Task.where(
            "{0} selecciona la opcion continuar pep",
            Click.on(PepPage.CONTINUE_BUTTON));
    }


}
