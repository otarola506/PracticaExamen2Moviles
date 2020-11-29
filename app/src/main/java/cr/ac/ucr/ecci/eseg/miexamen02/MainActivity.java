package cr.ac.ucr.ecci.eseg.miexamen02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        ParametroJuegosAsyncTack parametroJuegosAsyncTack = new ParametroJuegosAsyncTack(mListView, getApplicationContext());
        ServiceDataSource serviceDS = new ServiceDataSource();
        serviceDS.obtainItems(parametroJuegosAsyncTack);
        Log.println(Log.ASSERT,"", "Hola");

    }
}