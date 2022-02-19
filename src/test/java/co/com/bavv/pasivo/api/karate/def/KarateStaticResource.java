/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.karate.def;

import static com.peterland.karate.api.screenplay.model.EnumUtils.lookupMap;
import com.peterland.karate.api.screenplay.tasks.Resource;

public enum KarateStaticResource implements Resource {
    USER_IDENTITY("/bavv-identification/user-identity", "classpath:schemas/pasivo/user-identity/requests/validate-otp.json"),
    CREATE_PASSIVE_PRODUCT("/create-passive-product", "classpath:schemas/pasivo/create-passive-product/requests/cda.json"),
    COGNITO("/v1/cognito", ""),
    NONE("", "");

    private final String text;
    private final String requestFilePath;

    KarateStaticResource(String text, String requestFilePath) {
        this.text = text;
        this.requestFilePath = requestFilePath;
    }

    public String text() {
        return text;
    }
    public String request(){return requestFilePath;}

    @Override
    public Resource staticResource() {
        return this;
    }

    public static KarateStaticResource identifiedBy(String text) {
        KarateStaticResource resource = lookupMap(KarateStaticResource.class, e -> e.text()).apply(text);
        return resource;
    }
}
