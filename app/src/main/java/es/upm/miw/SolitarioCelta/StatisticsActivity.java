package es.upm.miw.SolitarioCelta;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class StatisticsActivity extends Activity {

    public final static String STATITISTICS_FILE = "statistics.txt";

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        listView = (ListView) findViewById(R.id.listViewStatistics);

        FileController fileController = new FileController(STATITISTICS_FILE, this);

        List<Resultado> listOfStatistics = new ArrayList<>();
        if (fileController.existsFilename()) {
            List<String> aux = fileController.readAllFile();
            for (String str : aux){
                Resultado res = new Resultado();
                res.deserialize(str);
                listOfStatistics.add(res);
            }
            Collections.sort(listOfStatistics, new Comparator<Resultado>() {
                @Override
                public int compare(Resultado o1, Resultado o2) {
                    if(o1.get_puntuacion() > o2.get_puntuacion()){
                        return 1;
                    }
                    else if(o1.get_puntuacion() < o2.get_puntuacion()){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            });
        } else {
            Toast.makeText(
                    this,
                    getString(R.string.staToast),
                    Toast.LENGTH_LONG
            ).show();
        }

        View header = getLayoutInflater().inflate(R.layout.header, null);

        listView.addHeaderView(header);

        MyAdapter myAdapter = new MyAdapter(
                this
                , R.layout.statistic_element
                , listOfStatistics
        );

        listView.setAdapter(myAdapter);
    }

}
