package pl.pollub.interfejs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {
    TextView tv1;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv1 = (TextView) findViewById(R.id.textView3);
        TextView view1 = (TextView) findViewById(R.id.textView4);

        Bundle extras = getIntent().getExtras();
        String wynik = extras.getString("key1");
        view1.setText(wynik);
    }
}
