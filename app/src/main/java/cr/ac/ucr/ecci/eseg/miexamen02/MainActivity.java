package cr.ac.ucr.ecci.eseg.miexamen02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        ParametroJuegosAsyncTack parametroJuegosAsyncTack = new ParametroJuegosAsyncTack(mListView, getApplicationContext());
        ServiceDataSource serviceDS = new ServiceDataSource();
        serviceDS.obtainItems(parametroJuegosAsyncTack);
        Log.println(Log.ASSERT,"", "Hola");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}