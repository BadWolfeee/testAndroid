package pl.pollub.app2803;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game1x extends Activity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,back;
    int turn;
    boolean win=false;
    private GameLogicsX logics = new GameLogicsX();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1x);
        b1=(Button)findViewById(R.id.r1k1);
        b2=(Button)findViewById(R.id.r1k2);
        b3=(Button)findViewById(R.id.r1k3);
        b4=(Button)findViewById(R.id.r2k1);
        b5=(Button)findViewById(R.id.r2k2);
        b6=(Button)findViewById(R.id.r2k3);
        b7=(Button)findViewById(R.id.r3k1);
        b8=(Button)findViewById(R.id.r3k2);
        b9=(Button)findViewById(R.id.r3k3);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Aquatico-Regular.otf");
        b1.setTypeface(typeface);
        b2.setTypeface(typeface);
        b3.setTypeface(typeface);
        b4.setTypeface(typeface);
        b5.setTypeface(typeface);
        b6.setTypeface(typeface);
        b7.setTypeface(typeface);
        b8.setTypeface(typeface);
        b9.setTypeface(typeface);

        back=(Button)findViewById(R.id.back);

        turn = 1;

        buttonSet(b1);
        buttonSet(b2);
        buttonSet(b3);
        buttonSet(b4);
        buttonSet(b5);
        buttonSet(b6);
        buttonSet(b7);
        buttonSet(b8);
        buttonSet(b9);

    }

    public void buttonSet(final Button rk){
        rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rk.getText().toString().equals(" ") && turn == 1 && !win  ){
                    turn=2;
                    rk.setText("O");}
                else if(rk.getText().toString().equals(" ") && turn == 2 && !win ){
                    turn=1;
                    rk.setText("X");}
                logics.endGame(b1,b2,b3,b4,b5,b6,b7,b8,b9);
                win = logics.win;

                promptWin();
            }
        });
    }

    private void promptWin() {

        if (turn == 2 && win)
            Toast.makeText(this, "Player O lost", Toast.LENGTH_LONG).show();
        else if (turn == 1 && win)
            Toast.makeText(this, "Player X lost", Toast.LENGTH_LONG).show();
    }

    public void onBack(View view) {

        finish();
    }
}
