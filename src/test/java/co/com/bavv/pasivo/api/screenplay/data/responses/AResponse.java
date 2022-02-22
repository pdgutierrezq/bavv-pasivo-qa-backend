/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.screenplay.data.responses;

import co.com.bavv.pasivo.api.karate.def.KarateStaticResource;
import co.com.bavv.pasivo.api.screenplay.data.responses.product.create.PostCreatePassiveProductResponses;
import com.peterland.karate.api.screenplay.facts.ARequest;
import com.peterland.karate.api.screenplay.model.HTTPResponse;

public class AResponse {

    public static HTTPResponse identifiedBy(String identifier) {
        HTTPResponse response = null;
        KarateStaticResource staticResource = KarateStaticResource.NONE;
        try {
            staticResource = (KarateStaticResource) ARequest.loaded().resource().staticResource();
        } catch (Exception e) {
        }
        switch (staticResource) {
            case USER_IDENTITY:
                break;
            case CREATE_PASSIVE_PRODUCT:
                response = PostCreatePassiveProductResponses.identifiedWith(identifier);
                break;
            case NONE:
                break;
        }
        return response;
    }
}
