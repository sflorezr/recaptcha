package co.com.tuya.certificacion.stepdefinitions;


import co.com.tuya.certificacion.tasks.llenarFormularioTask;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class recaptChaSteps {
@Dado("Abro la pagina")
public void abroLaPagina() {
    setTheStage(new OnlineCast());
    theActorCalled("robot");
    theActorInTheSpotlight().wasAbleTo(Open.url("https://demos.bellatrix.solutions/contact-form/"));
}
@Cuando("diligencio datos del formulario")
public void diligencioDatosDelFormulario() {
    theActorInTheSpotlight().attemptsTo(llenarFormularioTask.llenarFormularioTask());
}
@Entonces("valido exitoso")
public void validoExitoso() {

}

    
}
