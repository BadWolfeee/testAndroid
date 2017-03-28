package pl.pollub.app1_lab3;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

public class RecivedData extends Activity {
    String inputString, inputString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recived_data);
        TextView view = (TextView) findViewById(R.id.displayintentextra);
        Bundle extras = getIntent().getExtras();
        inputString = extras.getString("key");
        view.setText(inputString);
        TextView view1 = (TextView) findViewById(R.id.displayintentextra2);
        inputString2 = extras.getString("key2");
        view1.setText(inputString2);
    }

    public void finish() {
        Intent intent = new Intent();
        float x= Float.parseFloat(inputString);
        float y= Float.parseFloat(inputString2);
        float ad, sub, mul, div;
        ad=x+y;
        sub=x-y;
        mul=x*y;
        div=x/y;
        String a,s,m,d;
        a= String.valueOf(ad);
        s= String.valueOf(sub);
        m= String.valueOf(mul);
        d= String.valueOf(div);

        intent.putExtra("returna", a);
        intent.putExtra("returns", s);
        intent.putExtra("returnm", m);
        intent.putExtra("returnd", d);

        setResult(RESULT_OK, intent);
        super.finish();
    }
}
