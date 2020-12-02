package cr.ac.ucr.ecci.eseg.miexamen02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView, AdapterView.OnItemClickListener {
    private ListView mListView;
    private ProgressBar mProgressBar;
    private List<TableTop> juegosMesa;

    private TableTopInteractor tableTopInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        tableTopInteractor = new TableTopInteractor(this);
        tableTopInteractor.iniciarTareaAsyncJuegos(this);
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void setItems(List<TableTop> juegos) {
        this.juegosMesa = juegos;
        mProgressBar.setVisibility(View.INVISIBLE);
        mListView.setAdapter( new LazyAdapter(juegos, this ));
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TableTop juego = juegosMesa.get(i);
        Intent intent = new Intent(view.getContext(),ActivityDetalles.class);
        // En el intent se le pasa el objeto TableTop
        intent.putExtra("tableTop",juego);
        view.getContext().startActivity(intent);

    }




}