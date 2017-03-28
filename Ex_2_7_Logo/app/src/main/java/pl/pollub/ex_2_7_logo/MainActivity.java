package pl.pollub.ex_2_7_logo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    Button b;
    ImageView iv;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= (Button) findViewById(R.id.button);
        iv= (ImageView) findViewById(R.id.imageView2);

    }

    public void draw(View view) {
        i++;
        if(i%2==1)
        iv.setImageResource(R.drawable.grass);
        else if(i%2==0)
        iv.setImageResource(R.drawable.dirt);
    }
}
