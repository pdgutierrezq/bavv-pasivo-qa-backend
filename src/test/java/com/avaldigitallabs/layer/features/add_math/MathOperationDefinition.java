/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.avaldigitallabs.layer.features.add_math;

import com.avaldigitallabs.layer.features.add_math.steps.MathSteps;
import com.avaldigitallabs.layer.model.MathsOperation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MathOperationDefinition {

    @Steps
    MathSteps anna;

    MathsOperation math = new MathsOperation();


    @Given("^the user want to add")
    public void givenTheUserWannnaAdd() {
        anna.addOperationAdd(math);
    }

    @Given("^the user want to less")
    public void givenTheUserWannnaLess() {
        anna.addOperationLess(math);
    }

    @When("^the number a '([0-9]*)'")
    public void whenTheUserAddNumberA(Integer numberA) {
        anna.addONumberA(math, numberA);
    }

    @When("^the number b '([0-9]*)'")
    public void whenTheUserAddNumberB(Integer numberB) {
        anna.addONumberB(math, numberB);
    }

    @Then("^they should see '([0-9]*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(Integer result) {
        assertThat(result).isEqualTo(anna.operartion(math));
    }


}
