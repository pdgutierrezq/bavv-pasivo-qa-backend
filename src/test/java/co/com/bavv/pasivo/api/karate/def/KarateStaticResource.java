/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.karate.def;

import co.com.bavv.pasivo.api.screenplay.data.responses.customer.PostCustomerAccountsResponses;
import co.com.bavv.pasivo.api.screenplay.data.responses.customer.PostCustomerConditionsResponses;
import co.com.bavv.pasivo.api.screenplay.data.responses.product.PostCreatePassiveProductResponses;
import com.peterland.karate.api.screenplay.tasks.Resource;

public enum KarateStaticResource implements Resource {
    CUSTOMER_ACCOUNTS("customer-accounts",
        "classpath:schemas/pasivo/customer-accounts/requests/ok.json",
        PostCustomerAccountsResponses.class),
    CUSTOMER_CONDITIONS("bavv-identification/customer-conditions",
        "classpath:schemas/pasivo/customer-conditions/requests/ok.json",
        PostCustomerConditionsResponses.class),
    USER_IDENTITY("bavv-identification/user-identity",
        "classpath:schemas/pasivo/user-identity/requests/validate-otp.json",
        null),
    CREATE_PASSIVE_PRODUCT("create-passive-product",
        "classpath:schemas/pasivo/create-passive-product/requests/cda.json",
        PostCreatePassiveProductResponses.class),
    EMPTY("", "classpath:schemas/pasivo/empty.json", null);

    private final String id;
    private final String requestFilePath;
    private final Class<?> responsesClass;

    KarateStaticResource(String id, String requestFilePath, Class<?> responsesClass) {
        this.id = id;
        this.requestFilePath = requestFilePath;
        this.responsesClass = responsesClass;
    }

    public String id() {
        return id;
    }

    public String requestFilePath() {
        return requestFilePath;
    }

    public Class<?> responsesClass() {
        return responsesClass;
    }

    @Override
    public Resource staticResource() {
        return this;
    }

}
