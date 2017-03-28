package pl.pollub.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv;
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.my_text);
        et = (EditText) findViewById(R.id.main_input);
        bt = (Button) findViewById(R.id.button);
    }

    public void onClick(View V){
        String str = et.getText().toString();
        tv.setText(str);
    }
}
