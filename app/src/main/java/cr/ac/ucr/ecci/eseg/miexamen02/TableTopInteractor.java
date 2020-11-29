package cr.ac.ucr.ecci.eseg.miexamen02;

public class TableTopInteractor {
    public void obtenerJuegos(ParametroJuegosAsyncTack parametroJuegosAsyncTask){
        ServiceDataSource serviceD = new ServiceDataSource();
        serviceD.obtainItems(parametroJuegosAsyncTask);
    }
}
