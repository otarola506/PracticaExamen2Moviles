package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServiceDataSource implements IServiceDataSource {
    private static final String  URL_JSON ="https://bitbucket.org/lyonv/ci0161_ii2020_practica_examenii/raw/489a3e15b5cd670b1cab5684bcf892e5c7f80066/Tabletop16.json";
    // Se obtiene los items de la lista y los retorna
    // En este método hay que recuperar mediante una tarea asíncronica el archivo json con la clase TableTop.
    // Necesito ver como manejo la sincronización de los hilos para que no tire que no recupero nada.
    @Override
    public void obtainItems(ParametroJuegosAsyncTack parametroJuegosAsyncTack) {
        new recuperarTableTop().execute(parametroJuegosAsyncTack);

    }

    // Hay que implementar una tarea asincrónica que reciba el URL y devuelva la lista de TableTop
    private class recuperarTableTop extends AsyncTask<ParametroJuegosAsyncTack, Void, Void> {
        String datos = "";
        ParametroJuegosAsyncTack parametroJuegos;
        @Override
        protected Void doInBackground(ParametroJuegosAsyncTack... parametroJuegosAsyncTacks) {
            parametroJuegos = parametroJuegosAsyncTacks[0];
            try {
                URL url = new URL(URL_JSON);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null){
                    line = bufferedReader.readLine();
                    datos = datos + line;

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  null;
        }

        @Override
        protected void onPostExecute(Void Avoid) {
            List<TableTop> juegos = new ArrayList<>();
            try {
                JSONObject myTableTop = new JSONObject(datos);
                JSONArray jsonArray = myTableTop.getJSONArray("miTabletop");
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject juegoIndividual = (JSONObject) jsonArray.get(i);
                    TableTop juego = new TableTop(juegoIndividual.getString("identificacion"),juegoIndividual.getString("nombre"),Integer.parseInt(juegoIndividual.getString("year")),juegoIndividual.getString("publisher"));
                    juegos.add(juego);
                }
                parametroJuegos.getListView().setAdapter(new LazyAdapter(juegos,parametroJuegos.getContext()));


            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
