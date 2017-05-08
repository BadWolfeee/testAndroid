package pl.pollub.app2803;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game3x extends Activity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b11,b21,b31,b41,b51,b61,b71,b81,b91,b12,b22,b32,b42,b52,b62,b72,b82,b92,back;
    int turn;
    boolean win=false, win1=false, win2=false;
    private GameLogicsX logics = new GameLogicsX();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3x);

            b1=(Button)findViewById(R.id.r1k111);
            b2=(Button)findViewById(R.id.r1k211);
            b3=(Button)findViewById(R.id.r1k311);
            b4=(Button)findViewById(R.id.r2k111);
            b5=(Button)findViewById(R.id.r2k211);
            b6=(Button)findViewById(R.id.r2k311);
            b7=(Button)findViewById(R.id.r3k111);
            b8=(Button)findViewById(R.id.r3k211);
            b9=(Button)findViewById(R.id.r3k311);

            b11=(Button)findViewById(R.id.r1k112);
            b21=(Button)findViewById(R.id.r1k212);
            b31=(Button)findViewById(R.id.r1k312);
            b41=(Button)findViewById(R.id.r2k112);
            b51=(Button)findViewById(R.id.r2k212);
            b61=(Button)findViewById(R.id.r2k312);
            b71=(Button)findViewById(R.id.r3k112);
            b81=(Button)findViewById(R.id.r3k212);
            b91=(Button)findViewById(R.id.r3k312);

            b12=(Button)findViewById(R.id.r1k113);
            b22=(Button)findViewById(R.id.r1k213);
            b32=(Button)findViewById(R.id.r1k313);
            b42=(Button)findViewById(R.id.r2k113);
            b52=(Button)findViewById(R.id.r2k213);
            b62=(Button)findViewById(R.id.r2k313);
            b72=(Button)findViewById(R.id.r3k113);
            b82=(Button)findViewById(R.id.r3k213);
            b92=(Button)findViewById(R.id.r3k313);

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

            b11.setTypeface(typeface);
            b21.setTypeface(typeface);
            b31.setTypeface(typeface);
            b41.setTypeface(typeface);
            b51.setTypeface(typeface);
            b61.setTypeface(typeface);
            b71.setTypeface(typeface);
            b81.setTypeface(typeface);
            b91.setTypeface(typeface);

            b12.setTypeface(typeface);
            b22.setTypeface(typeface);
            b32.setTypeface(typeface);
            b42.setTypeface(typeface);
            b52.setTypeface(typeface);
            b62.setTypeface(typeface);
            b72.setTypeface(typeface);
            b82.setTypeface(typeface);
            b92.setTypeface(typeface);

            back=(Button)findViewById(R.id.back12);

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

            buttonSet(b11);
            buttonSet(b21);
            buttonSet(b31);
            buttonSet(b41);
            buttonSet(b51);
            buttonSet(b61);
            buttonSet(b71);
            buttonSet(b81);
            buttonSet(b91);

            buttonSet(b12);
            buttonSet(b22);
            buttonSet(b32);
            buttonSet(b42);
            buttonSet(b52);
            buttonSet(b62);
            buttonSet(b72);
            buttonSet(b82);
            buttonSet(b92);

        }

    public void buttonSet(final Button rk){
        rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rk.getText().toString().equals(" ") && turn == 1 && !win ){
                    turn=2;
                    rk.setText("O");}
                else if(rk.getText().toString().equals(" ") && turn == 2 && !win ){
                    turn=1;
                    rk.setText("X");}

                if(rk.getText().toString().equals(" ") && turn == 1 && !win1 ){
                    turn=2;
                    rk.setText("O");}
                else if(rk.getText().toString().equals(" ") && turn == 2 && !win1 ){
                    turn=1;
                    rk.setText("X");}

                if(rk.getText().toString().equals(" ") && turn == 1 && !win2 ){
                    turn=2;
                    rk.setText("O");}
                else if(rk.getText().toString().equals(" ") && turn == 2 && !win2 ){
                    turn=1;
                    rk.setText("X");}

                logics.endGame(b1,b2,b3,b4,b5,b6,b7,b8,b9);
                logics.endGame(b11,b21,b31,b41,b51,b61,b71,b81,b91);
                logics.endGame(b12,b22,b32,b42,b52,b62,b72,b82,b92);
                win = logics.win;
                win1 = logics.win;
                win2 = logics.win;

                promptWin();
            }
        });
    }

    private void promptWin() {

        if (turn == 2 && win && win1 && win2)
            Toast.makeText(this, "Player O lost", Toast.LENGTH_LONG).show();
        else if (turn == 1 && win && win1 && win2)
            Toast.makeText(this, "Player X lost", Toast.LENGTH_LONG).show();
    }

    public void onBack(View view) {

        finish();
    }
}
