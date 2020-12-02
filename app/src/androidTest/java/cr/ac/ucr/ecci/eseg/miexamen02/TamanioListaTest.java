package cr.ac.ucr.ecci.eseg.miexamen02;
import android.widget.ListView;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class TamanioListaTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule(MainActivity.class);

    // Prueba que verifica que la cantidad de elementos en el list view sea 8
    @Test
    public void verificarCantidadElementosLista() throws InterruptedException {
        Thread.sleep(5000);
        ListView listview = (ListView) activityRule.getActivity().findViewById(R.id.list);

        assertEquals(8,listview.getCount());

    }
}
