package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.TasksGroup;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class EnrollmenValidationsteps {



    @Cuando("el usuario inicie el proceso de firma")
    public void elUsuarioInicieElProcesoDeFirma() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                TasksGroup.navigateToDigitalSignatureCdt()
            );
    }

    @Entonces("redirecciona a pantalla de enrolamiento de canales")
    public void redireccionaAPantallaDeEnrolamientoDeCanales(){
        System.out.println("l");

    }

    @Entonces("redirecciona a pantalla de enrolamiento de tips de ahorro")
    public void redireccionaAPantallaDeEnrolamientoDeTipsDeAhorro() {
    }
}
