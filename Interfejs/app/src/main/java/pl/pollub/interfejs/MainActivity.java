package pl.pollub.interfejs;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    RadioGroup rg;
    Button b1, b2;
    TextView tv1, tv2;
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb6 = (RadioButton) findViewById(R.id.radioButton6);
        rb7 = (RadioButton) findViewById(R.id.radioButton7);

        LocationManager service = (LocationManager)         getSystemService(LOCATION_SERVICE);
        boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // Check if enabled and if not send user to the GSP settings. Better
        // solution would be to display a dialog and suggesting to go to the
        // settings
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent); }
    }
    public static float distFrom(float lat1, float lng1, float lat2, float lng2) {

        double earthRadius = 3958.75;

        double dLat = Math.toRadians(lat2-lat1);

        double dLng = Math.toRadians(lng2-lng1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +

                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *

                        Math.sin(dLng/2) * Math.sin(dLng/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double dist = earthRadius * c;

        int meterConversion = 1609;

        return (float) (dist * meterConversion);

    }
    public void OnClick1(View view) {
     //   Intent intent = new Intent(this, MapsActivity.class);
     //   startActivity(intent);
        Intent intent = new Intent(this, MapsActivity.class);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
    public void OnClick2(View view) {
        double x = 0;
        double y = 0;
        String nazwa;
        if (rb1.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Mechaniczny";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb2.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Elektrotechniki i Informatyki";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb3.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Zarządzania";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb4.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Podstaw Techniki";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb5.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Budownictwa i Architekury";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb6.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Wydział Inżynierii Materiałowej";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
        if (rb7.isChecked()) {
            x = 48.853416;
            y = 2.352018;
            nazwa = "Centrum Innowacji i Zaawansowanych Technologii";

            Intent intent = new Intent(this, ResultActivity.class);
            String wynik = String.valueOf(x);
            intent.putExtra("key1", wynik);

        }
    }
}