package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.api.screenplay.data.AnInfo;
import co.com.bavv.pasivo.utils.Start;
import io.cucumber.java.es.Dado;

public class InfoSteps extends Start {

    @Dado("(.*) es un usuario con las siguientes caracteristicas")
    public void peterEsUnUsuarioConLasSiguientesCaracteristicas(String name, AnInfo anInfo) {
        actor(name).has(anInfo);
    }
}
