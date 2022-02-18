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
public class CppBody {
    private String documentType;
    private String documentNumber;
    private String accountType;
    private int artCode;
    private int atmWithdrawalsNumber;
    private String cdtFundingAcct;
    private String cdtFundingId;
    private String cdtProfitsAcct;
    private String cdtProfitsId;
    private String cdtAmount;
    private String cdtTerm;
    private int cdtTermination;
    private double interestRate;
    private int officeWithdrawalsNumber;
    private int requestCode;
    private boolean documentSignature;
    private boolean requiredGMF;
}
