package co.com.tuya.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;

import static co.com.tuya.certificacion.userinterfaces.pantalla.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingConstants;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class llenarFormularioTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        SpeechConfig config = SpeechConfig.fromSubscription("c5f183bc0c084b85a9d61e7bb5be626c", "francecentral");
        WebElement iFrame = BrowseTheWeb.as(actor).element(By.xpath("//iframe[@title='reCAPTCHA']"));
        WebElement iFrame2 = BrowseTheWeb.as(actor).element(By.xpath("//iframe[@title='El reCAPTCHA caduca dentro de dos minutos']"));
        actor.attemptsTo(
                Enter.keyValues("Sergio").into(FIRST_NAME),
                Enter.keyValues("Florez").into(LAST_NAME),
                Enter.keyValues("slflorez@gmail.com").into(EMAIL),
                Click.on(GOLD_INPUT),
                Click.on(SESION),
                Click.on(STAY_OPTION),
                Enter.keyValues("algo").into(QUESTION_INPUT)
        );
        actor.attemptsTo(
                Switch.toFrame(iFrame),
                Click.on(RECAPTCHAT_CHECK),
                Switch.toDefaultContext()
        );
         actor.attemptsTo(
            Switch.toFrame(iFrame2),
            Click.on(AUDIO_CHECK)
        );
        AudioProcessingOptions audioProcessingOptions = AudioProcessingOptions.create(AudioProcessingConstants.AUDIO_INPUT_PROCESSING_ENABLE_DEFAULT);
        AudioConfig audioInput = AudioConfig.fromDefaultMicrophoneInput(audioProcessingOptions);
        List<String> recognizedSpeechParts = new ArrayList<>();
        SpeechRecognizer recognizer = new SpeechRecognizer(config, audioInput);
        {
            recognizer.recognized.addEventListener((s, e) -> {
                if (e.getResult().getReason() == ResultReason.RecognizedSpeech) {
                    recognizedSpeechParts.add(e.getResult().getText());
                    System.out.println("RECOGNIZED: Text=" + e.getResult().getText());
                } else if (e.getResult().getReason() == ResultReason.NoMatch) {
                    System.out.println("NOMATCH: Speech could not be recognized.");
                }
            });

            // Starts continuous recognition. Uses stopContinuousRecognitionAsync() to stop recognition.
            try {
                recognizer.startContinuousRecognitionAsync().get();
                actor.attemptsTo(Click.on(PLAY_BUTTON));
                recognizer.stopContinuousRecognitionAsync().get();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
            config.close();
            audioInput.close();
            audioProcessingOptions.close();
            recognizer.close();
            System.out.println(recognizedSpeechParts);
        }

    }
    public static llenarFormularioTask llenarFormularioTask(){
        return Tasks.instrumented(llenarFormularioTask.class);
    }
}
