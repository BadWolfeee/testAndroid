package pl.pollub.lab2_app3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public EditText a, b, c;
    public Button calc;
    public TextView sol, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (EditText) findViewById(R.id.editText5);
        b = (EditText) findViewById(R.id.editText4);
        c = (EditText) findViewById(R.id.editText3);
        TextView labA = (TextView) findViewById(R.id.textView5);
        TextView labB = (TextView) findViewById(R.id.textView4);
        TextView labC = (TextView) findViewById(R.id.textView3);
        calc = (Button) findViewById(R.id.button);
        sol = (TextView) findViewById(R.id.textView2);
        x = (TextView) findViewById(R.id.textView);
    }

    public float numbers(EditText idV) {
        float numV=0;
        String val;
        try{
            val = idV.getText().toString();
            numV = Float.parseFloat(val);
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "Use numbers", Toast.LENGTH_SHORT);
        }
        return numV;
    }

    public float calcDel() {
        float vA = numbers(a);
        float vB = numbers(b);
        float vC = numbers(c);
        float del = vB * vB - 4 * vA * vC;
        return del;
    }

    public void calcX(View view) {
        float vA = numbers(a);
        float vB = numbers(b);
        float vC = numbers(c);
        float x1 = 0, x2 = 0;
        float del = calcDel();

        if (del == 0) {
            x1 = (float)Math.ceil((-vB / (2 * vA))*1000000)/100000;
            String wyn= String.valueOf(x1);
            sol.setText("1 Solution");
            x.setText(wyn);
        } else if (del > 0) {
            x1 = (float)Math.ceil(((-vB + (float) Math.sqrt(del)) / (2 * vA))*1000000)/1000000;
            x2 = (float)Math.ceil(((-vB - (float) Math.sqrt(del)) / (2 * vA))*1000000)/1000000;
            sol.setText("2 Solutions");
            String wyn1= String.valueOf(x1);
            String wyn2= String.valueOf(x2);
            x.setText(wyn1 + "\n" + wyn2);
        } else if (del < 0) {
            sol.setText("Del 0");
            x.setText("NaN");
        }
    }
}

