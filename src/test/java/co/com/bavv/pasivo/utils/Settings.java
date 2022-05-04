/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.pasivo.utils;

import com.peterland.karate.api.screenplay.tasks.KarateVars;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource("classpath:setup.properties")
@Service("settings")
public class Settings {

    @Value("${api.host}")
    private String apiHost;

    @Value("${api.baseUrl}")
    private String apiBaseUrl;

    public static Settings instance;

    public static Settings getInstance() {
        if (instance == null) {
            AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(Settings.class);
            instance = (Settings) annotationContext.getBean("settings");
        }
        return instance;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void setProperties() {
        setProperty("api.host", this.apiHost);
        setProperty("api.baseUrl", this.apiBaseUrl);
        setProperty("environment", System.getProperty("environment"));
    }

    public static void setSerenityProperty(String name, String value) {
        EnvironmentVariables environmentVariables = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        environmentVariables.setProperty(name, value);
    }

    public static void setProperty(String name, String value) {
        KarateVars.setVar(name.replaceAll("\\.","_"), value);
        System.setProperty(name, value);
    }
}
