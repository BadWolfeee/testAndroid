package pl.pollub.app2803;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BIGame extends Activity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, bac;
    int turn=1;
    boolean win = false, dro = false;
    private GameLogics logics = new GameLogics();
    private String [][] boa= logics.getBoard();
    private BearI bearI = new BearI();
    private int bNum=0;
    private String i;
    private int y;
    private Handler handlerUI= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigame);

        b1 = (Button) findViewById(R.id.r1k11);
        b2 = (Button) findViewById(R.id.r1k21);
        b3 = (Button) findViewById(R.id.r1k31);
        b4 = (Button) findViewById(R.id.r2k11);
        b5 = (Button) findViewById(R.id.r2k21);
        b6 = (Button) findViewById(R.id.r2k31);
        b7 = (Button) findViewById(R.id.r3k11);
        b8 = (Button) findViewById(R.id.r3k21);
        b9 = (Button) findViewById(R.id.r3k31);

        bac = (Button) findViewById(R.id.back1);

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



        Bundle extras = getIntent().getExtras();
        i = extras.getString("bival");
        bearI.InitTurn(i);

        boa[0][0]=b1.getText().toString();
        boa[0][1]=b2.getText().toString();
        boa[0][2]=b3.getText().toString();
        boa[1][0]=b4.getText().toString();
        boa[1][1]=b5.getText().toString();
        boa[1][2]=b6.getText().toString();
        boa[2][0]=b7.getText().toString();
        boa[2][1]=b8.getText().toString();
        boa[2][2]=b9.getText().toString();

        buttonSet(b1);
        buttonSet(b2);
        buttonSet(b3);
        buttonSet(b4);
        buttonSet(b5);
        buttonSet(b6);
        buttonSet(b7);
        buttonSet(b8);
        buttonSet(b9);

        bearPlay();

    }


    public void buttonSet(final Button rk) {

        y= Integer.parseInt(i);

            rk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View w) {
                    if(!win && !dro) {
                    if (rk.getText().toString().equals(" ") && turn == 1) {
                        if(y!=turn){
                            rk.setText("O");
                            turn = 2;}
                        else if(y==turn){
                            rk.setText("O");
                            turn = 2;}

                    } else if (rk.getText().toString().equals(" ") && turn == 2 ) {
                        if(y!=turn){
                            rk.setText("X");
                            turn = 1;}
                        else if(y==turn){
                            rk.setText("X");
                            turn = 1;}
                    }
                    logics.endGame(b1, b2, b3, b4, b5, b6, b7, b8, b9);
                    dro = logics.dro;
                    win = logics.win;
                        boa=logics.getBoard();
                        bearI.setBoard(boa[0][0],boa[0][1],boa[0][2],boa[1][0],boa[1][1],boa[1][2],boa[2][0],boa[2][1],boa[2][2]);


                        handlerUI.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                bearPlay();
                            }
                        }, 1000);
                    promptWin();
                }
                }
            });
    }

    public void bearPlay() {
        if (y == turn) {

            bearI.setBoard(boa[0][0],boa[0][1],boa[0][2],boa[1][0],boa[1][1],boa[1][2],boa[2][0],boa[2][1],boa[2][2]);

                    bearI.PlayTurn();
                    bNum = bearI.getNumb();

            switch (bearI.getBNum()) {
                case 0:
                    break;
                case 1:
                    buttonSet((Button) findViewById(R.id.r1k11));
                    b1.performClick();
                    break;
                case 2:
                    buttonSet((Button) findViewById(R.id.r1k21));
                    b2.performClick();
                    break;
                case 3:
                    buttonSet((Button) findViewById(R.id.r1k31));
                    b3.performClick();
                    break;
                case 4:
                    buttonSet((Button) findViewById(R.id.r2k11));
                    b4.performClick();
                    break;
                case 5:
                    buttonSet((Button) findViewById(R.id.r2k21));
                    b5.performClick();
                    break;
                case 6:
                    buttonSet((Button) findViewById(R.id.r2k31));
                    b6.performClick();
                    break;
                case 7:
                    buttonSet((Button) findViewById(R.id.r3k11));
                    b7.performClick();
                    break;
                case 8:
                    buttonSet((Button) findViewById(R.id.r3k21));
                    b8.performClick();
                    break;
                case 9:
                    buttonSet((Button) findViewById(R.id.r3k31));
                    b9.performClick();
                    break;
                default:
                    break;
            }
        }
    }

    private void promptWin() {

        if (y!=turn && win)
            Toast.makeText(this, "BearI won", Toast.LENGTH_LONG).show();
        else if (y==turn && win )
            Toast.makeText(this, "Player won", Toast.LENGTH_LONG).show();
        else if (dro)
            Toast.makeText(this, "It's a draw", Toast.LENGTH_LONG).show();
    }

    public void onBack1(View view) {
        finish();
    }
}


