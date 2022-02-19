/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.integration;


import co.com.bavv.pasivo.utils.Settings;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(tags = "~@ignore")
public abstract class KarateIntegrationTest {

    public static void configureEnvironment() {
        Settings settings = Settings.getInstance();
        settings.setProperties();
        KarateRunner.setServiceBaseURL(Settings.getInstance().getApiBaseUrl());
    }

    @BeforeClass
    public static void beforeClass() {
        configureEnvironment();
    }

}
