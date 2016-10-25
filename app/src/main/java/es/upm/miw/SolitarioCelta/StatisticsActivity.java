package es.upm.miw.SolitarioCelta;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        List<Puntuation> listOfStatistics = new ArrayList<>();
        if (fileController.existsFilename()) {
            List<String> aux = fileController.readAllFile();
            for (String str : aux){
                String[] splitted = str.split("\\|");
                listOfStatistics.add(new Puntuation(splitted[0],Integer.valueOf(splitted[1])));
            }
            Collections.sort(listOfStatistics, new Comparator<Puntuation>() {
                @Override
                public int compare(Puntuation o1, Puntuation o2) {
                    if(o1.getNumberOfTokens() > o2.getNumberOfTokens()){
                        return 1;
                    }
                    else if(o1.getNumberOfTokens() < o2.getNumberOfTokens()){
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
