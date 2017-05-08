package pl.pollub.app2803;

import android.view.View;

import java.util.Random;

/**
 * Created by admin on 02.05.2017.
 */

public class BearI {
    private static int bNum=0;
    private int numb;
    private String a,b,c,d,e,f,g,h,i;
    private String sin;
    private final static Random RANDOM= new Random();



    public void InitTurn(String bear){
        if(bear.equals("1"))
            sin="O";
        else if(bear.equals("2"))
            sin="X";

        a=" ";
        b=" ";
        c=" ";
        d=" ";
        e=" ";
        f=" ";
        g=" ";
        h=" ";
        i=" ";
    }

    public void setBoard(String a1,String b1,String c1,String d1,String e1,String f1,String g1,String h1,String i1){
        this.a=a1;
        this.b=b1;
        this.c=c1;
        this.d=d1;
        this.e=e1;
        this.f=f1;
        this.g=g1;
        this.h=h1;
        this.i=i1;
    }

    public void PlayTurn(){

            if ( e.equals(" ") ) {
                bNum = 5;
            }
             else if ( e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ")  && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals(" ")) {
                if (RANDOM.nextFloat() < 0.25f) {
                    bNum = 1;
                } else if (RANDOM.nextFloat() > 0.25f && RANDOM.nextFloat() < 0.5f) {
                    bNum = 3;
                } else if (RANDOM.nextFloat() > 0.5f && RANDOM.nextFloat() < 0.75f) {
                    bNum = 4;
                } else if (RANDOM.nextFloat() < 0.75f) {
                    bNum = 9;
                }}
                else if(e.equals("O") && a.equals("X") && b.equals(" ") && c.equals(" ") && d.equals(" ") && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals(" "))
                    bNum=2;
                else if(e.equals("O") && a.equals(" ") && b.equals("X") && c.equals(" ") && d.equals(" ") && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals(" "))
                    bNum=6;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals("X") && d.equals(" ") && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals(" "))
                    bNum=2;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ") && d.equals("X") && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals(" "))
                    bNum=8;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ") && d.equals(" ") && f.equals("X") && g.equals(" ") && h.equals(" ") && i.equals(" "))
                    bNum=8;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ") && d.equals(" ") && f.equals(" ") && g.equals("X") && h.equals(" ") && i.equals(" "))
                    bNum=4;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ") && d.equals(" ") && f.equals(" ") && g.equals(" ") && h.equals("X") && i.equals(" "))
                    bNum=6;
                else if(e.equals("O") && a.equals(" ") && b.equals(" ") && c.equals(" ") && d.equals(" ") && f.equals(" ") && g.equals(" ") && h.equals(" ") && i.equals("X"))
                    bNum=6;
             else if (a.equals(b) && a.equals(sin) && c.equals(" "))
                bNum = 3;
            else if (a.equals(c) && a.equals(sin) && b.equals(" "))
                bNum = 2;
            else if (b.equals(c) && b.equals(sin) && a.equals(" "))
                bNum = 1;
            else if (d.equals(e) && d.equals(sin) && f.equals(" "))
                bNum = 6;
            else if (d.equals(f) && d.equals(sin) && e.equals(" "))
                bNum = 5;
            else if (e.equals(f) && e.equals(sin) && d.equals(" "))
                bNum = 4;
            else if (g.equals(h) && g.equals(sin) && i.equals(" "))
                bNum = 9;
            else if (g.equals(i) && g.equals(sin) && h.equals(" "))
                bNum = 8;
            else if (h.equals(i) && h.equals(sin) && g.equals(" "))
                bNum = 7;
                // all vertical wins
            else if (a.equals(d) && a.equals(sin) && g.equals(" "))
                bNum = 7;
            else if (a.equals(g) && a.equals(sin) && d.equals(" "))
                bNum = 4;
            else if (g.equals(d) && g.equals(sin) && a.equals(" "))
                bNum = 1;
            else if (b.equals(e) && b.equals(sin) && h.equals(" "))
                bNum = 8;
            else if (b.equals(h) && b.equals(sin) && e.equals(" "))
                bNum = 5;
            else if (h.equals(e) && h.equals(sin) && b.equals(" "))
                bNum = 2;
            else if (c.equals(f) && c.equals(sin) && i.equals(" "))
                bNum = 9;
            else if (c.equals(i) && c.equals(sin) && f.equals(" "))
                bNum = 6;
            else if (f.equals(i) && f.equals(sin) && c.equals(" "))
                bNum = 3;
                //all horizontal wins
            else if (a.equals(e) && a.equals(sin) && i.equals(" "))
                bNum = 9;
            else if (a.equals(i) && a.equals(sin) && e.equals(" "))
                bNum = 5;
            else if (e.equals(i) && e.equals(sin) && a.equals(" "))
                bNum = 1;
            else if (c.equals(e) && c.equals(sin) && g.equals(" "))
                bNum = 7;
            else if (c.equals(g) && c.equals(sin) && e.equals(" "))
                bNum = 5;
            else if (g.equals(e) && g.equals(sin) && c.equals(" "))
                bNum = 3;
                //all diagonal wins

            else if (a.equals(b) && (!a.equals(sin) && !a.equals(" ")) && c.equals(" "))
                bNum = 3;
            else if (a.equals(c) && (!a.equals(sin) && !a.equals(" "))  && b.equals(" "))
                bNum = 2;
            else if (b.equals(c) && (!b.equals(sin) && !b.equals(" "))  && a.equals(" "))
                bNum = 1;
            else if (d.equals(e) && (!d.equals(sin) && !d.equals(" "))  && f.equals(" "))
                bNum = 6;
            else if (d.equals(f) && (!d.equals(sin) && !d.equals(" "))  && e.equals(" "))
                bNum = 5;
            else if (e.equals(f) && (!e.equals(sin) && !e.equals(" "))  && d.equals(" "))
                bNum = 4;
            else if (g.equals(h) && (!g.equals(sin) && !g.equals(" "))  && i.equals(" "))
                bNum = 9;
            else if (g.equals(i) && (!g.equals(sin) && !g.equals(" "))  && h.equals(" "))
                bNum = 8;
            else if (h.equals(i) && (!h.equals(sin) && !h.equals(" "))  && g.equals(" "))
                bNum = 7;
                // all vertical wins for player
            else if (a.equals(d) && (!a.equals(sin) && !a.equals(" "))  && g.equals(" "))
                bNum = 7;
            else if (a.equals(g) && (!a.equals(sin) && !a.equals(" "))  && d.equals(" "))
                bNum = 4;
            else if (g.equals(d) && (!g.equals(sin) && !g.equals(" "))  && a.equals(" "))
                bNum = 1;
            else if (b.equals(e) && (!b.equals(sin) && !b.equals(" "))  && h.equals(" "))
                bNum = 8;
            else if (b.equals(h) && (!b.equals(sin) && !b.equals(" ")) && e.equals(" "))
                bNum = 5;
            else if (h.equals(e) && (!h.equals(sin) && !h.equals(" "))  && b.equals(" "))
                bNum = 2;
            else if (c.equals(f) && (!c.equals(sin) && !c.equals(" "))  && i.equals(" "))
                bNum = 9;
            else if (c.equals(i) && (!c.equals(sin) && !c.equals(" ")) && f.equals(" "))
                bNum = 6;
            else if (f.equals(i) && (!f.equals(sin) && !f.equals(" "))  && c.equals(" "))
                bNum = 3;
                //all horizontal wins for player
            else if (a.equals(e) && (!a.equals(sin) && !a.equals(" "))  && i.equals(" "))
                bNum = 9;
            else if (a.equals(i) && (!a.equals(sin) && !a.equals(" "))  && e.equals(" "))
                bNum = 5;
            else if (e.equals(i) && (!e.equals(sin) && !e.equals(" "))  && a.equals(" "))
                bNum = 1;
            else if (c.equals(e) && (!c.equals(sin) && !c.equals(" "))  && g.equals(" "))
                bNum = 7;
            else if (c.equals(g) && (!c.equals(sin) && !c.equals(" "))  && e.equals(" "))
                bNum = 5;
            else if (g.equals(e) && (!g.equals(sin) && !g.equals(" "))  && c.equals(" "))
                bNum = 3;
            //all diagonal wins for player
            else if(a.equals(" "))
                bNum=1;
            else if(b.equals(" "))
                bNum=2;
            else if(c.equals(" "))
                bNum=3;
            else if(d.equals(" "))
                bNum=4;
            else if(e.equals(" "))
                bNum=5;
            else if(f.equals(" "))
                bNum=6;
            else if(g.equals(" "))
                bNum=7;
            else if(h.equals(" "))
                bNum=8;
            else if(i.equals(" "))
                bNum=9;

        setbNum(bNum);
        }

        private void setbNum(int numb){
            bNum= numb;
        }

    int getBNum(){
        return bNum;
    }
    int getNumb(){
        return numb;
    }


}
