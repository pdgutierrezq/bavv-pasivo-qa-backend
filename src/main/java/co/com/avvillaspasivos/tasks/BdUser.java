/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.data.JsonFile;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.DATA_BLOCK_PROP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BdUser implements Task {
    private final boolean option;

    public BdUser(boolean option) {
        this.option = option;
    }

    public static Performable toBlock(boolean option) {
        return instrumented(BdUser.class, option);
    }

    @Step("{0} selecciona la opcion #confirmation pep")
    public <T extends Actor> void performAs(T actor) {
            JsonFile.setProperty(DATA_BLOCK_PROP, option);
    }
}
