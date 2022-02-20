/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.karate.def;


import com.peterland.karate.api.screenplay.tasks.Operation;
import com.peterland.karate.api.screenplay.tasks.Resource;
import com.peterland.karate.api.screenplay.tasks.Script;

import static com.peterland.karate.api.screenplay.tasks.BaseOperation.POST;

public enum KarateScript implements Script {
    PASSIVE_API(POST, KarateStaticResource.CREATE_PASSIVE_PRODUCT, "classpath:co/com/bavv/pasivo/api/karate/templates/send_api_request.feature", true),
    UPDATE_HEADERS(POST, KarateStaticResource.USER_IDENTITY, "classpath:co/com/bavv/pasivo/api/karate/templates/update_headers.feature", true);

    private final String path;
    private final Operation operation;
    private final Resource resource;
    private final Boolean print;

    KarateScript(Operation operation, Resource resource, String path, Boolean print) {
        this.path = path;
        this.operation = operation;
        this.resource = resource;
        this.print = print;
    }

    public String path() {
        return path;
    }

    public Operation operation() {
        return operation;
    }

    public Resource resource() {
        return resource;
    }

    public Boolean print() {
        return print;
    }
}