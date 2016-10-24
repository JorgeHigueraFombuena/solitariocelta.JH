package es.upm.miw.SolitarioCelta;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileController {

    private String myFile;
    private Activity activity;

    public FileController(String myFile, Activity activity) {
        this.myFile = myFile;
        this.activity = activity;
    }

    public void writeln(String text) {
        try {
            FileOutputStream outputStream = activity.getApplicationContext().openFileOutput(myFile, Context.MODE_APPEND);
            outputStream.write((text + "\n").getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readAllFile() {
        ArrayList<String> textOfFile = new ArrayList<>();
        try {
            BufferedReader fin = new BufferedReader(
                    new InputStreamReader(activity.getApplicationContext().openFileInput(myFile)));
            String linea = fin.readLine();
            while (linea != null) {
                textOfFile.add(linea);
                linea = fin.readLine();
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textOfFile;
    }

    public String readLastLine(){
        ArrayList<String> textOfFile = readAllFile();
        if(textOfFile.isEmpty()){
            return null;
        }
        else {
            return textOfFile.get(textOfFile.size() - 1);
        }
    }
}
