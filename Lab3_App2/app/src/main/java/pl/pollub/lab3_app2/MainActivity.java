package pl.pollub.lab3_app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button lub, par, waw;
    Intent intent;
    private static final int REQUEST_CODE = 1;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lub = (Button)findViewById(R.id.lublin);
        par = (Button)findViewById(R.id.paryz);
        waw = (Button)findViewById(R.id.warszawa);
        intent = new Intent(this, MapsActivity.class);
    }


    public void lubl(View view) {
        i=1;
        intent.putExtra("key", i);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void pary(View view) {
        i=2;
        intent.putExtra("key", i);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void wars(View view) {
        i=3;
        intent.putExtra("key", i);
        startActivityForResult(intent, REQUEST_CODE);
    }
}
