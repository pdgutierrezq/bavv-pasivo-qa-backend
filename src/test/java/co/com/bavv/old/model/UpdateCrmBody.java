/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.bavv.old.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCrmBody {

    private String documentType;
    private String documentNumber;
    private String transactionId;
    private String totalSave;
    private String companyTel;
    private String companyAddress;
    private String companyCity;
    private String companyName;
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String telNumber;
    private String phoneNumber;
    private boolean declarant;
    private String address;
    private String city;
    private String neighborhood;
    private Long birthDate;
    private int activityEconomical;
    private int income;
    private String foreignCurrencyType;
    private String foreignBankName;
    private String foreignBankCountry;
    private String foreignBankCity;
    private String balanceAcct;
    private String foreignRefId;
    private String foreignAcctType;
    private String foreignTrnCurrency;
    private String foreignTrnType;
    private String internationalTrnInd;
    private String monthExpenses;
    private String liabilities;
    private String assets;
    private String emailAddr;
    private int codeCIIU;
    private String gender;
    private String birthCity;
    private String documentExpCity;
    private Long documentExpDate;


}
