package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.api.screenplay.data.AnInfo;
import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.model.HTTPResponse;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class InfoSteps extends Start {

    @Dado("(.*) es un usuario con las siguientes caracteristicas")
    public void peterEsUnUsuarioConLasSiguientesCaracteristicas(String name, AnInfo anInfo) {
        actor(name).has(anInfo);
    }

    @Entonces("el obtinene una respuesta (.*)")
    public void elObtineneUnaRespuestaExitosa(HTTPResponse httpResponse) {
        validateResponse(httpResponse);
    }
}

