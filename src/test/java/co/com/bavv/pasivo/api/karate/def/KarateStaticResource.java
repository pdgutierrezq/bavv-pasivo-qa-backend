/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.api.karate.def;

import com.peterland.karate.api.screenplay.tasks.Resource;

public enum KarateStaticResource implements Resource {
    CUSTOMER_ACCOUNTS("customer-accounts",
        "classpath:schemas/pasivo/customer-accounts/requests/ok.json",
        "classpath:schemas/pasivo/customer-accounts/responses/ok.json"),
    CUSTOMER_CONDITIONS("bavv-identification/customer-conditions",
        "classpath:schemas/pasivo/customer-conditions/requests/ok.json",
        "classpath:schemas/pasivo/customer-conditions/responses/ok.json"),
    USER_IDENTITY_GENERATE("bavv-identification/user-identity",
        "classpath:schemas/pasivo/user-identity/requests/generate.json",
        "classpath:schemas/pasivo/user-identity/responses/generate.json"),
    USER_IDENTITY_VALIDATE("bavv-identification/user-identity",
        "classpath:schemas/pasivo/user-identity/requests/validate.json",
        "classpath:schemas/pasivo/user-identity/responses/validate.json"),
    UPDATE_DATA_CRM("update-data-crm",
        "classpath:schemas/pasivo/update-data-crm/requests.csv",
        "classpath:schemas/pasivo/update-data-crm/responses.csv"),
    CREATE_PASSIVE_PRODUCT("create-passive-product",
        "classpath:schemas/pasivo/create-passive-product/requests/cda.json",
        "classpath:schemas/pasivo/create-passive-product/responses/ok.json"),
    EMPTY("", "classpath:schemas/pasivo/empty.json", ""),
    PRODUCT_CONFIGURATION("get-product-configuration",
        "classpath:schemas/pasivo/empty.json",
        "classpath:schemas/pasivo/get-initial-parameters/responses/ok.json"),
    ELECTRONIC_SIGNATURE("electronic-signature",
        "classpath:schemas/pasivo/electronic-signature/requests/cdt.json",
        "classpath:schemas/pasivo/electronic-signature/responses/ok_cdt.json"),
    PUBLIC_KEY("enrollment/get-public-key",
        "classpath:schemas/pasivo/empty.json",
        "classpath:schemas/pasivo/get-public-key/responses/ok.json"),
    CREATE_INSURANCE("create-insurance",
        "classpath:schemas/pasivo/create-insurance/requests/cda.json",
        "classpath:schemas/pasivo/create-insurance/responses/ok.json"),
    GET_DOCUMENTS_TO_CHARGE("get-documents-to-charge",
        "classpath:schemas/pasivo/get-documents-to-charge/requests/cda.json",
        "classpath:schemas/pasivo/get-documents-to-charge/responses/ok.json"),
    UPLOAD_BANK_DOCUMENTS("upload-bank-documents",
        "classpath:schemas/pasivo/upload-bank-documents/requests/cda.json",
        "classpath:schemas/pasivo/upload-bank-documents/responses/ok.json"),
    SAVE_DOCUMENT("save-document",
        "classpath:schemas/pasivo/save-document/requests/ok.json",
        "classpath:schemas/pasivo/save-document/responses/ok.json"),
    VALIDATE_DOCUMENT("validate-document",
        "classpath:schemas/pasivo/validate-document/requests/ok.json",
        "classpath:schemas/pasivo/validate-document/responses/ok.json");

    private final String id;
    private String requestFilePath;
    private String responseFilePath;
    private Class<?> responsesClass;

    KarateStaticResource(String id, String requestFilePath, Class<?> responsesClass) {
        this.id = id;
        this.requestFilePath = requestFilePath;
        this.responsesClass = responsesClass;
    }

    KarateStaticResource(String id, String requestFilePath, String responseFilePath) {
        this.id = id;
        this.requestFilePath = requestFilePath;
        this.responseFilePath = responseFilePath;

    }

    public String id() {
        return id;
    }

    public String requestFilePath() {
        return requestFilePath;
    }

    public String responseFilePath() {
        return responseFilePath;
    }

    public Class<?> responsesClass() {
        return responsesClass;
    }

    @Override
    public Resource staticResource() {
        return this;
    }

}
