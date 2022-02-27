/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.screenplay.data;

import co.com.bavv.pasivo.api.karate.def.KarateStaticResource;
import com.peterland.karate.api.screenplay.model.data.info.AnGraphQLInfo;
import com.peterland.karate.api.screenplay.tasks.KarateVars;
import io.cucumber.java.Before;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import org.json.JSONObject;


public class AnInfo implements Fact {

    public static AnInfo anInfo;

    public Map info;

    public AnInfo() {
    }

    @Before
    public void before() {
        AnInfo.reset();
    }

    @Override
    public void setup(Actor actor) {
    }

    public static Fact configuredTo(KarateStaticResource resource) {
        KarateVars.reset();
        AnGraphQLInfo anGraphQLInfo = null;
        switch (resource) {
            case USER_IDENTITY:
                break;
            case CREATE_PASSIVE_PRODUCT:
//                anGraphQLInfo = loaded().toJson();
//                anGraphQLInfo.configured(resource.request());
                break;
            case EMPTY:
                break;
            default:
//                anGraphQLInfo = Configurer.toGraphQLInfo(loaded().info);
//                anGraphQLInfo.configured(resource.request());
                break;
        }
        return loaded();
    }

    public static AnInfo loaded() {
        if (anInfo == null) {
            anInfo = new AnInfo();
            anInfo.info = new HashMap();
        }
        return anInfo;
    }

    public static void reset() {
        anInfo = null;
    }

    public void setInfo(Map info) {
        this.info.putAll(info);
    }

    public Map info() {
        return info;
    }

    public JSONObject toJson() {
        return new JSONObject(info);
    }

    public String toString() {
        return toJson().toString();
    }

}
