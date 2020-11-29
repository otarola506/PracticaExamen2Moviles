package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;
import android.widget.ListView;

public class ParametroJuegosAsyncTack {
    private ListView listView;
    private Context context;

    public ParametroJuegosAsyncTack(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
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
}
