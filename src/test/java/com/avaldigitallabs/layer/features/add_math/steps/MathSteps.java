/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.avaldigitallabs.layer.features.add_math.steps;

import com.avaldigitallabs.layer.model.MathsOperation;
import com.avaldigitallabs.layer.model.Operations;
import net.thucydides.core.annotations.Step;

public class MathSteps {


    @Step
    public void addOperationAdd(MathsOperation mathsOperation) {
        mathsOperation.setOperations(Operations.ADD);
    }

    @Step
    public void addOperationLess(MathsOperation mathsOperation) {
        mathsOperation.setOperations(Operations.LESS);
    }

    @Step
    public void addONumberA(MathsOperation mathsOperation, Integer numberA) {
        mathsOperation.setNuma(numberA);
    }

    @Step
    public void addONumberB(MathsOperation mathsOperation, Integer numberB) {
        mathsOperation.setNumb(numberB);
    }

    @Step
    public Integer operartion(MathsOperation mathsOperation) {
        Integer result = 0;
        switch (mathsOperation.getOperations()) {
            case ADD:
                result = mathsOperation.getNuma() + mathsOperation.getNumb();
                break;
            case LESS:
                result = mathsOperation.getNuma() - mathsOperation.getNumb();
                break;
        }
        return result;
    }
}
