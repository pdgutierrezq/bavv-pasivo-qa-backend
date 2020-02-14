package co.com.avvillaspasivos.runners;

import co.com.avvillaspasivos.util.Constantes;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "classpath:features/landing/detalleHabeasData.feature",
    glue = Constantes.RUTA_STEPS_DEFINITIONS,
    tags = Constantes.EXECUTION_TAGS,
    //    tags = {"@TestLive"},
    snippets = SnippetType.CAMELCASE)
public class DetalleHabeasDataTestRunner {}
