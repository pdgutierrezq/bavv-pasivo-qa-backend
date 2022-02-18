/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.tasks;

import co.com.bavv.old.data.JsonFile;
import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

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
            JsonFile.setProperty(Constantes.DATA_BLOCK_PROP, option);
    }
}
