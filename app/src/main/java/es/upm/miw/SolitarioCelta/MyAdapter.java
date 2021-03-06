package es.upm.miw.SolitarioCelta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;


public class MyAdapter extends ArrayAdapter {

    private Context context;
    private int resourceId;
    private List objects;

    public MyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects =  objects;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout vista;

        SimpleDateFormat sdf = new SimpleDateFormat(context.getString(R.string.formatDate));

        if(convertView != null){
            vista = (LinearLayout) convertView;
        }
        else {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = (LinearLayout) inf.inflate(resourceId, parent, false);
        }

        Resultado res = (Resultado) objects.get(position);

        ((TextView)vista.findViewById(R.id.position)).setText(String.valueOf(position+1));

        ((TextView)vista.findViewById(R.id.userName)).setText(res.get_nombreJugador());

        ((TextView)vista.findViewById(R.id.numToken)).setText(String.valueOf(res.get_puntuacion()));

        String date = context.getString(R.string.unknown);
        ((TextView)vista.findViewById(R.id.date)).setTextSize(10);
        if(res.get_tiempo() > 0L){
            date = sdf.format(res.get_tiempo());
        }
        ((TextView)vista.findViewById(R.id.date)).setText(date);

        return vista;
    }
}
