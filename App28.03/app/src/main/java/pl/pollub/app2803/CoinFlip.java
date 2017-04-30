package pl.pollub.app2803;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
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
    private TextView p1,p2;
    private boolean who=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
        p1 = (TextView)findViewById(R.id.you1);
        p2 = (TextView)findViewById(R.id.you2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
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
            } else if(RANDOM.nextFloat()>0.5f && !who){
                p2.setVisibility(View.VISIBLE);
                who=true;
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
}
