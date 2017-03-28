package pl.pollub.popularcontrols;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv;
    RadioButton rb1;
    CheckBox cb1;
    CheckBox cb2;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView5);
        rb1= (RadioButton) findViewById(R.id.radioButton10);
        cb1= (CheckBox) findViewById(R.id.checkBox4);
        cb2= (CheckBox) findViewById(R.id.checkBox3);
        et= (EditText) findViewById(R.id.editText11);

    }

    public void rewriteText(View view) {
        if (rb1.isChecked()) {
            tv.setTextColor(Color.BLUE);
        } else {
            tv.setTextColor(Color.RED);
        }
        if (cb1.isChecked() && cb2.isChecked()) {
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
        } else if (cb1.isChecked() && !cb2.isChecked()) {
            tv.setTypeface(null, Typeface.BOLD);
        } else if (!cb1.isChecked() && cb2.isChecked()) {
            tv.setTypeface(null, Typeface.ITALIC);
        } else {
            tv.setTypeface(null, Typeface.NORMAL);
        }
        
        String str = et.getText().toString();
        tv.setText(str);
    }
}