package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServiceDataSource implements IServiceDataSource  {

    private static final String  URL_JSON ="https://bitbucket.org/lyonv/ci0161_ii2020_practica_examenii/raw/489a3e15b5cd670b1cab5684bcf892e5c7f80066/Tabletop16.json";
    private Context context;

    public ServiceDataSource (Context context){
        this.context = context;
    }

    // Método que llama a la tarea asincrónica que obtiene los items
    @Override
    public void obtainItems() {
        RecuperarTableTop recuperarDatosAsyncTask = new RecuperarTableTop(context);
        recuperarDatosAsyncTask.execute();

    }
    // Tarea asincrónica que consulta el URL del json y lo guarda en una lista.
    public static class RecuperarTableTop extends AsyncTask<Void, Void, Void> {
        String datos = "";
        Context context;
        public OnFinishTask onFinishTask;
        public RecuperarTableTop(Context context){
            this.context = context;
            onFinishTask = (OnFinishTask) context;

        }

        // En Background procesamos el JSON
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(URL_JSON);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    datos = datos + line;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        // En el onPost llenamos la lista y llamamos al método onFinishedTask de la interfaz onFinish que recibe la lista
        @Override
        protected void onPostExecute(Void Avoid) {
            final List<TableTop> juegos = new ArrayList<>();
            try {
                JSONObject myTableTop = new JSONObject(datos);
                JSONArray jsonArray = myTableTop.getJSONArray("miTabletop");
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject juegoIndividual = (JSONObject) jsonArray.get(i);
                    TableTop juego = new TableTop(juegoIndividual.getString("identificacion"),juegoIndividual.getString("nombre"),Integer.parseInt(juegoIndividual.getString("year")),juegoIndividual.getString("publisher"));
                    juegos.add(juego);
                }
                onFinishTask.onFinishedTask(juegos);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
