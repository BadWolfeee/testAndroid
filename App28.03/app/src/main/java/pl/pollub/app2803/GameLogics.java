package pl.pollub.app2803;

import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 30.04.2017.
 */

public class GameLogics {
    boolean win=false;
    boolean dro=false;
    private String[][] board= new String[3][3];

    public void endGame(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8, Button b9){

        String a,b,c,d,e,f,g,h,i;

        a=b1.getText().toString();
        board[0][0]= a;
        b=b2.getText().toString();
        board[0][1]= b;
        c=b3.getText().toString();
        board[0][2]= c;

        d=b4.getText().toString();
        board[1][0]= d;
        e=b5.getText().toString();
        board[1][1]= e;
        f=b6.getText().toString();
        board[1][2]= f;

        g=b7.getText().toString();
        board[2][0]= g;
        h=b8.getText().toString();
        board[2][1]= h;
        i=b9.getText().toString();
        board[2][2]= i;

        if(a.equals(b) && a.equals(c) && !a.equals(" ") || d.equals(e) && d.equals(f) && !d.equals(" ")  || g.equals(h) && g.equals(i) && !g.equals(" ")  )
            win=true;
        else if(a.equals(d) && a.equals(g) && !a.equals(" ")  || b.equals(e) && b.equals(h) && !b.equals(" ")  || c.equals(f) && c.equals(i) && !c.equals(" ")  )
            win=true;
        else if(a.equals(e) && a.equals(i) && !a.equals(" ")  || c.equals(e) && c.equals(g) && !c.equals(" ")  )
            win=true;
        else if(!win && !a.equals(" ") && !b.equals(" ") && !c.equals(" ") && !d.equals(" ") && !e.equals(" ") && !f.equals(" ") && !g.equals(" ") && !h.equals(" ") && !i.equals(" "))
            dro=true;
    }
    private boolean getWin(){
        return win;
    }
    private boolean getDro(){
        return dro;
    }
    public String[][] getBoard(){
        return board;
    }
}
