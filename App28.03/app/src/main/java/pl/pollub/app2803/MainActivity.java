package pl.pollub.app2803;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.PopupMenu;


public class MainActivity extends Activity {
    Button gam,opt,ex;
    private String bi = "0";
    Intent about, intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gam=(Button)findViewById(R.id.game);
        opt=(Button)findViewById(R.id.option);
        ex=(Button)findViewById(R.id.exit);

    }

    public void onGame(View view) {
            intent = new Intent(this, CoinFlip.class);

            //Creating the instance of PopupMenu
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, gam, Gravity.RIGHT);
        popupMenu.inflate(R.menu.popup_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                @Override
            public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.one:
                    bi="1";
                    intent.putExtra("wt", bi);
                    startActivity(intent);
                    return true;
                case R.id.two:
                    bi="2";
                    intent.putExtra("wt", bi);
                    startActivity(intent);
                    return true;
                case R.id.three:
                    bi="3";
                    intent.putExtra("wt", bi);
                    startActivity(intent);
                    return true;
                case R.id.four:
                    bi="4";
                    intent.putExtra("wt", bi);
                    startActivity(intent);
                    return true;
            }return true;
        }
    });
        popupMenu.show();
        }

    public void onAbout(View view) {
        about = new Intent(this, About.class);
        startActivity(about);

    }

    public void onExit(View view) {
        super.finish();
    }
}

