package cr.ac.ucr.ecci.eseg.miexamen02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceDataSource serviceDS = new ServiceDataSource();
        serviceDS.obtainItems(getApplicationContext());
        Log.println(Log.ASSERT,"", "Hola");

    }
}