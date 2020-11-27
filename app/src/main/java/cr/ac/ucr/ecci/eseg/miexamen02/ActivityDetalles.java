package cr.ac.ucr.ecci.eseg.miexamen02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ActivityDetalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        // Recibo el objeto tableTop
        TableTop tableTop = getIntent().getExtras().getParcelable("tableTop");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Inicio el fragmento de detalles con el objeto embajada
        ft.replace(R.id.fragment_placeholder,new DetallesFragment(tableTop));
        ft.commit();
    }
}