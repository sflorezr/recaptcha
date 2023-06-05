package co.com.tuya.certificacion.setup;

import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConfiguracionHook {
    public void prepararEscenarioParaPruebas(){
        setTheStage(new OnlineCast());
        theActorCalled("robot");
    }
    
}
