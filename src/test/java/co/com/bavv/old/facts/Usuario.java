/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.facts;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class Usuario implements Fact {
    ActorData actorData;

    public static Usuario informacion() {
        return new Usuario();
    }

    @Override
    public void setup(Actor actor) {
         actorData=actor.recall(String.valueOf(SessionVariables.DATA_ACTOR));
    }

    public String toString() {
        return "Los datos del usuario en el flujo son: " + actorData.toString();
    }
}
