package pl.pollub.app2803;

import android.widget.Button;

/**
 * Created by admin on 08.05.2017.
 */

public class GameLogicsX {
    boolean win=false;
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

        if(!a.equals(" ") && !b.equals(" ") && !c.equals(" ") || !d.equals(" ") && !e.equals(" ") && !f.equals(" ")  || !g.equals(" ") && !h.equals(" ") && !i.equals(" ")  )
            win=true;
        else if(!a.equals(" ") && !d.equals(" ") && !g.equals(" ")  || !b.equals(" ") && !e.equals(" ") && !h.equals(" ")  || !c.equals(" ") && !f.equals(" ") && !i.equals(" ")  )
            win=true;
        else if(!e.equals(" ") && !i.equals(" ") && !a.equals(" ")  || !e.equals(" ") && !g.equals(" ") && !c.equals(" ")  )
            win=true;
    }

    private boolean getWin(){
        return win;
    }
    public String[][] getBoard(){
        return board;
    }
}
