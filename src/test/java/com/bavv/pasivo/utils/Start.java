/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.bavv.pasivo.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


public class Start {
    public static Actor actor;
    public static String DEFAULT_NAME = "Peter";

    public static Actor actor(String name) {
        actor = Actor.named(name).whoCan(CallAnApi.at(Settings.getInstance().getApiBaseUrl()));
        return actor;
    }

    public static void actor() {
        actor = actor(DEFAULT_NAME);
    }

}
