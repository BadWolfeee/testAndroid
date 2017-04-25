package pl.pollub.app2803;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class Game extends Activity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int turn;
    boolean win=false, dro=false;

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
                endGame();
            }
        });
    }

    public void endGame(){

        String a,b,c,d,e,f,g,h,i;

        a=b1.getText().toString();
        b=b2.getText().toString();
        c=b3.getText().toString();

        d=b4.getText().toString();
        e=b5.getText().toString();
        f=b6.getText().toString();

        g=b7.getText().toString();
        h=b8.getText().toString();
        i=b9.getText().toString();

        if(a.equals(b) && a.equals(c) && !a.equals(" ") || d.equals(e) && d.equals(f) && !d.equals(" ")  || g.equals(h) && g.equals(i) && !g.equals(" ")  )
            win=true;
        else if(a.equals(d) && a.equals(g) && !a.equals(" ")  || b.equals(e) && b.equals(h) && !b.equals(" ")  || c.equals(f) && c.equals(i) && !c.equals(" ")  )
            win=true;
        else if(a.equals(e) && a.equals(i) && !a.equals(" ")  || c.equals(e) && c.equals(g) && !c.equals(" ")  )
            win=true;
        else if(!win && !a.equals(" ") && !b.equals(" ") && !c.equals(" ") && !d.equals(" ") && !e.equals(" ") && !f.equals(" ") && !g.equals(" ") && !h.equals(" ") && !i.equals(" "))
            dro=true;

        if(turn == 2 && win)
            Toast.makeText(this, "Player O won", Toast.LENGTH_LONG ).show();
        else if (turn == 1 && win)
            Toast.makeText(this, "Player X won", Toast.LENGTH_LONG ).show();
        else if(dro)
            Toast.makeText(this, "It's a draw", Toast.LENGTH_LONG ).show();

    }

}