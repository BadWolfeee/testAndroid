package pl.pollub.app1_lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    // Constant to determine which sub-activity returns
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText text = (EditText) findViewById(R.id.first);
        String value = text.getText().toString();
        Intent intent = new Intent(this, RecivedData.class);
        intent.putExtra("key", value);
        EditText text2 = (EditText) findViewById(R.id.sec);
        String value2 = text2.getText().toString();
        intent.putExtra("key2", value2);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returna")) {
                String result = data.getExtras().getString("returna");
                TextView add = (TextView)findViewById(R.id.tx1);
                add.setText(result);
                String result1 = data.getExtras().getString("returns");
                TextView subs = (TextView)findViewById(R.id.tx2);
                subs.setText(result1);
                String result2 = data.getExtras().getString("returnm");
                TextView multi = (TextView)findViewById(R.id.tx3);
                multi.setText(result2);
                String result3 = data.getExtras().getString("returnd");
                TextView divi = (TextView)findViewById(R.id.tx4);
                divi.setText(result3);
            }
        }
    }
}
