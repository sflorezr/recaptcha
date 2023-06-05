package co.com.tuya.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class pantalla {
    public static final Target FIRST_NAME = Target.the("First Name").located(By.id("wpforms-3347-field_1"));
    public static final Target LAST_NAME = Target.the("Last Name").located(By.id("wpforms-3347-field_1-last"));
    public static final Target EMAIL = Target.the("Email").located(By.id("wpforms-3347-field_2"));
    public static final Target GOLD_INPUT = Target.the("GOLD").located(By.id("wpforms-3347-field_3_3"));
    public static final Target SESION = Target.the("Secion").located(By.id("wpforms-3347-field_4_2"));
    public static final Target STAY_OPTION = Target.the("Stay").located(By.id("wpforms-3347-field_5_1"));
    public static final Target QUESTION_INPUT = Target.the("Question").located(By.id("wpforms-3347-field_7"));
    public static final Target RECAPTCHAT_CHECK = Target.the("check del recaptcha").located(By.xpath("//div[@class='recaptcha-checkbox-border']"));
    public static final Target  AUDIO_CHECK = Target.the("Audio check").located(By.id("recaptcha-audio-button"));
    public static final Target PLAY_BUTTON =Target.the("Boton de play").located(By.xpath("//button[text()='PLAY']"));

}
