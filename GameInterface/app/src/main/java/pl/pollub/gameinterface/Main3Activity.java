package pl.pollub.gameinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main3Activity extends Activity {
    TextView tx1,tx2,tx3,tx4,tx5;
    private InputStream is,is1,is2,is3,is4;
    String str,str1,str2,str3,str4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tx1=(TextView)findViewById(R.id.txt1);
        tx2=(TextView)findViewById(R.id.txt2);
        tx3=(TextView)findViewById(R.id.txt3);
        tx4=(TextView)findViewById(R.id.txt4);
        tx5=(TextView)findViewById(R.id.txt5);

        is = getResources().openRawResource(R.raw.o1);
        try {
            str = fromStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tx1.setText(str);
        is1 = getResources().openRawResource(R.raw.o2);
        try {
            str1 = fromStream(is1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tx2.setText(str1);
        is2 = getResources().openRawResource(R.raw.o3);
        try {
            str2 = fromStream(is2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tx3.setText(str2);
        is3 = getResources().openRawResource(R.raw.o4);
        try {
            str3 = fromStream(is3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tx4.setText(str3);
        is4 = getResources().openRawResource(R.raw.o5);
        try {
            str4 = fromStream(is4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tx5.setText(str4);
    }

    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}
