package cr.ac.ucr.ecci.eseg.miexamen02;
import android.widget.ListView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;


import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertEquals;


public class ComprobacionListaTest {

    public static final String TEST_ID = "TN008";
    public static final String TEST_NOMBRE="Pictionary";
    public static final String TEST_ANIO = "1985";
    public static final String TEST_PUBLISHER = "Hasbro";
    public static int TAMANIO_LISTA = 8;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule(MainActivity.class);
    // Prueba que verifica que el juego Pictionary este en la lista y que el detalle sea el correcto
    @Test
    public void comprobarPictionaryExiste() throws InterruptedException {
        Thread.sleep(5000);
        onView(withText(TEST_NOMBRE)).perform(click());
        onView(withId(R.id.textID)).check(matches(withText(TEST_ID)));
        onView(withId(R.id.textNombre)).check(matches(withText(TEST_NOMBRE)));
        onView(withId(R.id.textAnio)).check(matches(withText(TEST_ANIO)));
        onView(withId(R.id.textPublisher)).check(matches(withText(TEST_PUBLISHER)));
    }

}
