package pl.pollub.lab2_app4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    EditText in;
    RadioButton ctf,ftc;
    Button conv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in = (EditText)findViewById(R.id.EditText);
        ctf = (RadioButton) findViewById(R.id.radioButton);
        ftc = (RadioButton) findViewById(R.id.radioButton2);
        conv = (Button) findViewById(R.id.button);
    }

    public void convert(View view) {
        String str;
        float temp=0;
        try{
            str = in.getText().toString();
            temp = Float.parseFloat(str);
        }catch (NumberFormatException e){

        }
        if(ctf.isChecked()){
            float after= temp*9/5+32;
            String res=String.valueOf(after);
            in.setText(res);
        }else if(ftc.isChecked()){
            float after= (temp-32)*5/9;
            String res=String.valueOf(after);
            in.setText(res);
        }
    }
}
