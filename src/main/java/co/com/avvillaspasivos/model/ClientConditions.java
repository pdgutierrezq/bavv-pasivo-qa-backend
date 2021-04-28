/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientConditions {
    private Boolean client;
    private Boolean updated;
    private Boolean channels;
    private Boolean cat;
    private Boolean restrictiveList;
    private Boolean validOtp;
    private Boolean fundingAcc;
    private int fundingAccValue;
    private Boolean renewal;
    private Boolean insurance;
}
