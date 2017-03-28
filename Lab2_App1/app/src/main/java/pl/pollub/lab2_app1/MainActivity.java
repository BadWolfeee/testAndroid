package pl.pollub.lab2_app1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tx;
    EditText num1;
    EditText num2;
    Button but;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = (TextView)findViewById(R.id.TextView);
        num1 = (EditText)findViewById(R.id.editText3);
        num2 = (EditText)findViewById(R.id.editText4);
        but = (Button)findViewById(R.id.button);
        cb = (CheckBox)findViewById(R.id.checkBox);

    }

    public void sumNum(View view){
        String str = num1.getText().toString();
        String str2 = num2.getText().toString();
        float one= Float.parseFloat(str);
        float two= Float.parseFloat(str2);
        float sum= one+two;
        String suma= String.valueOf(sum);
        String sumar= String.valueOf(Math.round(sum));

        if(cb.isChecked())
            tx.setText(sumar);
        else
            tx.setText(suma);

    }
}
