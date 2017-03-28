package pl.pollub.explicitintent;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView view = (TextView) findViewById(R.id.displayintentextra);
        Bundle extras = getIntent().getExtras();
        String inputString = extras.getString("key");
        view.setText(inputString);
    }

    public void finish() {
        Intent intent = new Intent();
        EditText editText = (EditText) findViewById(R.id.returnValue);
        String string = editText.getText().toString();
        intent.putExtra("returnkey", string);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}

