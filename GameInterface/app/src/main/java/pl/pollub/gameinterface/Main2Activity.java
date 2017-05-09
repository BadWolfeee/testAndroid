package pl.pollub.gameinterface;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    Button next;
    RadioButton but,b1,b2,b3,b4;
    RadioGroup rg;
    TextView textView, sco;

    private Questions mojeQuest= new Questions();
    private String myAns;
    private int scor=0, sta, fin=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        next = (Button) findViewById(R.id.next);
        b1 = (RadioButton) findViewById(R.id.radioButton);
        b2 = (RadioButton) findViewById(R.id.radioButton2);
        b3 = (RadioButton) findViewById(R.id.radioButton3);
        b4 = (RadioButton) findViewById(R.id.radioButton4);

        textView = (TextView) findViewById(R.id.tekst);
        sco = (TextView) findViewById(R.id.score);
        sco.setText("Wynik: " + scor);
        rg = (RadioGroup) findViewById(R.id.gr1);

        sta=0;
        Drawable back = getResources().getDrawable(R.drawable.tapetapytone);
        setActivityBackground(back);

        updatePyt(sta);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sta==0){
                    Drawable back = getResources().getDrawable(R.drawable.tapetapyttwo);
                    setActivityBackground(back);
                }else if(sta==1){
                    Drawable back = getResources().getDrawable(R.drawable.tapetapytthree);
                    setActivityBackground(back);
                }else if(sta==2){
                    Drawable back = getResources().getDrawable(R.drawable.tapetapytfour);
                    setActivityBackground(back);
                }else if(sta==3){
                    Drawable back = getResources().getDrawable(R.drawable.tapetapytfive);
                    setActivityBackground(back);
                }else if(sta==4){
                    Drawable back = getResources().getDrawable(R.drawable.tapetainf);
                    setActivityBackground(back);
                }
                // get selected radio button from radioGroup
                int selectedId = rg.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                but = (RadioButton) findViewById(selectedId);

                if(fin==1)
                    finish();

                if(!b1.isChecked() && !b2.isChecked() && !b3.isChecked() && !b4.isChecked()){
                    sta++;
                    if(sta<=4){
                    updatePyt(sta);}

                        if(sta>4) {
                            if (scor == 0)
                                textView.setText("Wynik końcowy to: " + scor + " punktów");
                            else if (sta == 4 && scor == 1)
                                textView.setText("Wynik końcowy to: " + scor + " punkt");
                            else if (sta == 4 && scor > 1)
                                textView.setText("Wynik końcowy to: " + scor + " punkty");
                            b1.setVisibility(View.INVISIBLE);
                            b2.setVisibility(View.INVISIBLE);
                            b3.setVisibility(View.INVISIBLE);
                            b4.setVisibility(View.INVISIBLE);
                            next.setText("Wyjście");
                            fin = 1;
                        }
                }
                else if(sta<4 && but.getText() == myAns) {
                    scor++;
                    sco.setText("Wynik: " + scor);
                    Toast.makeText(Main2Activity.this,"Prawidłowa odpowiedź: "+myAns, Toast.LENGTH_SHORT).show();
                    sta++;
                    updatePyt(sta);

                } else if(sta<4) {
                    sco.setText("Wynik: " + scor);
                    Toast.makeText(Main2Activity.this,"Prawidłowa odpowiedź: "+myAns, Toast.LENGTH_SHORT).show();
                    sta++;
                    updatePyt(sta);

                } else{
                    Toast.makeText(Main2Activity.this,"Prawidłowa odpowiedź: "+myAns, Toast.LENGTH_SHORT).show();
                    if(but.getText()==myAns)
                        scor++;
                    sco.setText("Wynik: " + scor);

                    if(scor==0)
                        textView.setText("Wynik końcowy to: " +scor+ " punktów");
                    else if(scor==1)
                        textView.setText("Wynik końcowy to: " +scor+ " punkt");
                    else if(scor>1)
                        textView.setText("Wynik końcowy to: " +scor+ " punkty");
                    b1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                    next.setText("Wyjście");
                    fin=1;
                }

            }
        });
    }

    public void setActivityBackground(Drawable back) {
        View view = this.getWindow().getDecorView();
        view.setBackground(back);
    }

    private void updatePyt(int nr){
        textView.setText(mojeQuest.getQuestion(nr));
        b1.setText(mojeQuest.getOpt1(nr));
        b2.setText(mojeQuest.getOpt2(nr));
        b3.setText(mojeQuest.getOpt3(nr));
        b4.setText(mojeQuest.getOpt4(nr));

        myAns = mojeQuest.getCorrAnsw(nr);
    }

}
