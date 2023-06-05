package co.com.tuya.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"co.com.tuya.certificacion.stepdefinitions","co.com.tuya.certificacion.setup"},
        features = {"src/test/resources/co.com.tuya.certificacion/features/recaptcha.feature"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class RecaptChaRunner {
}
