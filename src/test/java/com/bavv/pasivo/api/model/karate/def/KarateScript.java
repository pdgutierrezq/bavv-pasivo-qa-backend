/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.bavv.pasivo.api.model.karate.def;


import com.peterland.karate.api.screenplay.tasks.Operation;
import com.peterland.karate.api.screenplay.tasks.Resource;
import com.peterland.karate.api.screenplay.tasks.Script;

import static com.peterland.karate.api.screenplay.tasks.BaseOperation.POST;

public enum KarateScript implements Script {
    GRAPHQL(POST, KarateStaticResource.GRAPHQL, "classpath:com/bocc/adn/api/model/karate/templates/adn_graphql.feature", true),
    UPDATE_HEADERS(POST, KarateStaticResource.NONE, "classpath:com/bavv/pasivo/api/model/karate/templates/update_headers.feature", true);

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
