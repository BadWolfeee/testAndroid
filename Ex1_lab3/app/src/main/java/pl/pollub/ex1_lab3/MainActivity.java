package pl.pollub.ex1_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText et;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);
        et.setHint("Enter Toast mess.");
    }

    public void toToast(View view) {
        String str = et.getText().toString();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
