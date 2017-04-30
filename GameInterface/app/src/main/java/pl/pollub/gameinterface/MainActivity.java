package pl.pollub.gameinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a= (Button) findViewById(R.id.Q1);
        b= (Button) findViewById(R.id.Q2);
        c= (Button) findViewById(R.id.Q3);
        d= (Button) findViewById(R.id.Q4);

    }

    public void Q1(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void Q2(View view) {
        Intent intent2 = new Intent(this, Main3Activity.class);
        startActivity(intent2);
    }


    public void Q3(View view) {
    }

    public void Q4(View view) {
        super.finish();
    }
}
