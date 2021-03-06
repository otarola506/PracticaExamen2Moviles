package cr.ac.ucr.ecci.eseg.miexamen02;

import android.os.Parcel;
import android.os.Parcelable;

// Clase TableTop que implementa parcelable
public class TableTop implements Parcelable {
    private String identificacion;
    private String nombre;
    private int year;
    private String publisher;

    public TableTop() {}

    public TableTop(String identificacion, String nombre, int year, String publisher) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.year = year;
        this.publisher = publisher;
    }


    protected TableTop(Parcel in) {
        identificacion = in.readString();
        nombre = in.readString();
        year = in.readInt();
        publisher = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identificacion);
        dest.writeString(nombre);
        dest.writeInt(year);
        dest.writeString(publisher);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TableTop> CREATOR = new Creator<TableTop>() {
        @Override
        public TableTop createFromParcel(Parcel in) {
            return new TableTop(in);
        }

        @Override
        public TableTop[] newArray(int size) {
            return new TableTop[size];
        }
    };

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
