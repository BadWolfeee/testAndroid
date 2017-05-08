package pl.pollub.app2803;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CoinFlip extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private long lastUpdate;
    private final static Random RANDOM= new Random();
    private TextView p1,p2,tx;
    private boolean who=false;
    public String bi= " ";
    private Intent intent;
    private Handler handlerUI= new Handler();
    String i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
        p1 = (TextView)findViewById(R.id.you1);
        p2 = (TextView)findViewById(R.id.you2);
        tx = (TextView)findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        Bundle extras = getIntent().getExtras();
        i = extras.getString("wt");

        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RANDOM.nextFloat()<0.3f && !who){
                    p1.setVisibility(View.VISIBLE);
                    who=true;
                    onResult();

                } else if(RANDOM.nextFloat()>0.3f && !who){
                    p2.setVisibility(View.VISIBLE);
                    who=true;
                    onResult();
                }
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelation = (x * x + y * y + z * z) /
                (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelation >= 2) {
            if (actualTime - lastUpdate < 100) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed",
                    Toast.LENGTH_SHORT).show();

            if(RANDOM.nextFloat()<0.5f && !who){
                p1.setVisibility(View.VISIBLE);
                who=true;
                onResult();

            } else if(RANDOM.nextFloat()>0.5f && !who){
                p2.setVisibility(View.VISIBLE);
                who=true;
                onResult();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    protected void onResume() {
        super.onResume();
        // Register listener
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onResult() {

        if(i.equals("1"))
        intent= new Intent(this, Game.class);
        else if(i.equals("2"))
        intent= new Intent(this, BIGame.class);
        else if(i.equals("3"))
        intent= new Intent(this, Game1x.class);
        else if(i.equals("4"))
        intent= new Intent(this, Game3x.class);

        if(p1.getVisibility()== View.VISIBLE){
            if(i.equals("2"))
                p1.setText("BearI go first!");
            bi="1";}
        else if(p2.getVisibility() == View.VISIBLE)
            bi="2";

        handlerUI.postDelayed(new Runnable() {
        @Override
        public void run() {
        intent.putExtra("bival", bi);
        startActivity(intent);
        }
        }, 1000);
    }
}
