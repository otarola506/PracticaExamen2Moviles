package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

// Lazy Adapter que hereda de BaseAdapter, se utiliza para mostrar la lista de juegos
public class LazyAdapter extends BaseAdapter {

    private List<TableTop> mData;
    private Context mContext;
    public LazyAdapter (List<TableTop> data,Context context) {
        mData = data;
        mContext = context;
    }
    public int getCount() {
        return mData.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = null;
        TableTop juego = mData.get(position);
        rowView = inflater.inflate(R.layout.list_row, parent, false);

        TextView nombre = (TextView)rowView.findViewById(R.id.nombre);
        TextView publisher = (TextView)rowView.findViewById(R.id.publisher);
        nombre.setText(juego.getNombre());
        publisher.setText(juego.getPublisher());

        return rowView;
    }

}
