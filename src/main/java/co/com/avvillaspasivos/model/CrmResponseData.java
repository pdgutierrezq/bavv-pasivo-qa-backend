/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CrmResponseData {
    private String mail;
    private String cityAddress;
    private String phone;
    private String address;
    private String companyName;
    private String companyCity;
    private String companyPhone;
    private String companyAddress;
    private String liabilitiesNumber;
    private String montlyExpenses;
    private String assetsnumber;
    private String incomeAmount;
    private String neighborhood;
}
