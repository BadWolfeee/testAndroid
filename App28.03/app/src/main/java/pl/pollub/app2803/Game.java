package pl.pollub.app2803;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game extends Activity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int turn;
    boolean win=false, dro=false;
    private GameLogics logics = new GameLogics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        b1=(Button)findViewById(R.id.r1k1);
        b2=(Button)findViewById(R.id.r1k2);
        b3=(Button)findViewById(R.id.r1k3);
        b4=(Button)findViewById(R.id.r2k1);
        b5=(Button)findViewById(R.id.r2k2);
        b6=(Button)findViewById(R.id.r2k3);
        b7=(Button)findViewById(R.id.r3k1);
        b8=(Button)findViewById(R.id.r3k2);
        b9=(Button)findViewById(R.id.r3k3);
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
                if(rk.getText().toString().equals(" ") && turn == 1 && !win && !dro ){
                    turn=2;
                    rk.setText("O");}
                else if(rk.getText().toString().equals(" ") && turn == 2 && !win && !dro ){
                    turn=1;
                    rk.setText("X");}
                logics.endGame(b1,b2,b3,b4,b5,b6,b7,b8,b9);
                dro = logics.dro;
                win = logics.win;

                promptWin();
            }
        });
    }

    private void promptWin() {

        if (turn == 2 && win)
            Toast.makeText(this, "Player O won", Toast.LENGTH_LONG).show();
        else if (turn == 1 && win)
            Toast.makeText(this, "Player X won", Toast.LENGTH_LONG).show();
        else if (dro)
            Toast.makeText(this, "It's a draw", Toast.LENGTH_LONG).show();
    }

}