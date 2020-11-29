package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ParametroJuegosAsyncTack {
    private ListView listView;
    private Context context;
    private ProgressBar progressBar;

    public ParametroJuegosAsyncTack(ListView listView, Context context, ProgressBar progressBar) {
        this.listView = listView;
        this.context = context;
        this.progressBar = progressBar;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
}
