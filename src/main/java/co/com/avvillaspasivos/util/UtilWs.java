/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.util;

import co.com.avvillaspasivos.model.HeaderData;

import java.util.HashMap;
import java.util.Map;

public class UtilWs {
    private UtilWs() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Object> getHeaders(HeaderData headerData){
        Map<String, Object> mapHeaders = new HashMap<>();
        mapHeaders.put("Content-Type", "application/json");
        mapHeaders.put("transaction-id", headerData.getTransactionId());
        mapHeaders.put("x-adl-document-type", headerData.getDocumentType());
        mapHeaders.put("x-adl-document-number", headerData.getDocumentNumber());

        return mapHeaders;
    }
}
