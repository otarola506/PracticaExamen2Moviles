package cr.ac.ucr.ecci.eseg.miexamen02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetallesFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TABLETOP = "tableTop";

    private TableTop juego;


    public DetallesFragment() {
        // Required empty public constructor
    }
    public DetallesFragment(TableTop juego){
        this.juego = juego;
    }


    public static DetallesFragment newInstance(TableTop juego) {
        DetallesFragment fragment = new DetallesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TABLETOP, juego);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            juego = getArguments().getParcelable(ARG_TABLETOP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_detalles, container, false);
        // Inflate the layout for this fragment
        if(juego != null){
            TextView textIdentificacion = (TextView) v.findViewById(R.id.textID);
            textIdentificacion.setText(juego.getIdentificacion());
            TextView textNombre = (TextView) v.findViewById(R.id.textNombre);
            textNombre.setText(juego.getNombre());
            TextView textYear = (TextView) v.findViewById(R.id.textAnio);
            textYear.setText(Integer.toString(juego.getYear()));
            TextView textPublisher = (TextView) v.findViewById(R.id.textPublisher);
            textPublisher.setText(juego.getPublisher());
        }
        return v;

    }
}