package pl.pollub.gameinterface;

import android.app.Activity;
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
    private int scor=0, sta=0;

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
        sco.setText("Score: " + scor);
        rg = (RadioGroup) findViewById(R.id.gr1);

        updatePyt(sta);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = rg.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                but = (RadioButton) findViewById(selectedId);

                if (sta<=5 && but.getText() == myAns) {
                    scor++;
                    sco.setText("Score: " + scor);
                    updatePyt(sta++);
                } else if(sta<=5) {
                    sco.setText("Score: " + scor);
                    updatePyt(sta++);
                } else{
                    sta=0;
                }

                Toast.makeText(Main2Activity.this, but.getText(), Toast.LENGTH_SHORT).show();
            }

        });
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
