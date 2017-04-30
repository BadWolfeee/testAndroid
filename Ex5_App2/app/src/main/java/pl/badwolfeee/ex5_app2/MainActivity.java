package pl.badwolfeee.ex5_app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView appl,pear,plum;

    TTSManager ttsManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager();
        ttsManager.init(this);

        appl = (ImageView)findViewById(R.id.app) ;
        pear = (ImageView)findViewById(R.id.pea) ;
        plum = (ImageView)findViewById(R.id.plu) ;


        appl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ttsManager.initQueue("jabłko");
            }
        });
        pear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ttsManager.initQueue("gruszka");
            }
        });
        plum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ttsManager.initQueue("śliwka");
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}