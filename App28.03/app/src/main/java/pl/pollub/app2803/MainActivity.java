package pl.pollub.app2803;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button gam,opt,ex;
    private static final int REQUEST_CODE = 1;
    Intent intent, about, intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gam=(Button)findViewById(R.id.game);
        opt=(Button)findViewById(R.id.option);
        ex=(Button)findViewById(R.id.exit);

    }

    public void onGame(View view) {
            intent = new Intent(this, Game.class);
            intent2 = new Intent(this, CoinFlip.class);

            //Creating the instance of PopupMenu
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, gam);
        popupMenu.inflate(R.menu.popup_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                @Override
            public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.one:
                    startActivity(intent);
                    return true;
                case R.id.two:
                    startActivity(intent2);
                    Toast.makeText(getApplicationContext(), "Single Standard", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.three:
                    Toast.makeText(getApplicationContext(), "Multiplayer x3", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.four:
                    Toast.makeText(getApplicationContext(), "Single x3", Toast.LENGTH_SHORT).show();
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
