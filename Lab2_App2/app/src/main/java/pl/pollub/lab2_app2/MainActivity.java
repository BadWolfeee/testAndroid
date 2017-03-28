package pl.pollub.lab2_app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tx;
    EditText num1;
    EditText num2;
    Button but;
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = (TextView)findViewById(R.id.textView);
        num1 = (EditText)findViewById(R.id.editText2);
        num2 = (EditText)findViewById(R.id.editText);
        but = (Button)findViewById(R.id.button);
        rb1 = (RadioButton) findViewById(R.id.radioButton5);
        rb2 = (RadioButton) findViewById(R.id.radioButton6);
        rb3 = (RadioButton) findViewById(R.id.radioButton7);
        rb4 = (RadioButton) findViewById(R.id.radioButton8);
        rg = (RadioGroup) findViewById(R.id.radioGroup3);

    }
    public void onClick(View view){
        String str = num1.getText().toString();
        String str2 = num2.getText().toString();
        float one= Float.parseFloat(str);
        float two= Float.parseFloat(str2);
        float sum= one+two;
        float od= one-two;
        float mno=one*two;
        String suma= String.valueOf(sum);
        String ode= String.valueOf(od);
        String mnoz= String.valueOf(mno);

        if(rb1.isChecked())
            tx.setText("Sum ="+suma);
        else if(rb2.isChecked())
            tx.setText("Difference ="+ode);
        else if(rb4.isChecked())
            tx.setText("Product ="+mnoz);
        else if(rb3.isChecked()){
            if(two!=0) {
                float dzi=one/two;
                String dzie= String.valueOf(dzi);
                tx.setText("Quotient ="+dzie);
            } else
                tx.setText("Division by 0");
        }
    }
}
