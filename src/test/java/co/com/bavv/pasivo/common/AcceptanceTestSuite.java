/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.common;

import co.com.bavv.pasivo.integration.KarateIntegrationTest;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber-json-report.json"},
    features = "classpath:features",
    glue = {"classpath:co"},
    tags = "not @sample"
)
public class AcceptanceTestSuite extends KarateIntegrationTest {

}
