package pl.pollub.lab3_app2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle extras = getIntent().getExtras();
        in = extras.getInt("key");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (in == 1){
            LatLng lublin = new LatLng(51.2465, 22.5684);

            // Move the camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lublin));
            // Zoom in, animating the camera
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            if (mMap!=null){
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(lublin)
                        .title("Lublin")
                        .snippet("Znajdujemy sie w Lublinie")
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.drawable.lubel)));
            }
        }else if(in == 2) {
            LatLng paryz = new LatLng(48.85341, 2.3488000);

            // Move the camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(paryz));
            // Zoom in, animating the camera
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            if (mMap != null) {
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(paryz)
                        .title("Paryz")
                        .snippet("Znajdujemy sie w Paryzu")
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.drawable.paris)));
            }
        }else if (in == 3) {
                LatLng warszawa = new LatLng(52.2297700, 21.0117800);

                // Move the camera 52.2297700, 21.0117800
                mMap.moveCamera(CameraUpdateFactory.newLatLng(warszawa));
                // Zoom in, animating the camera
                mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                if (mMap != null) {
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(warszawa)
                            .title("Warszawa")
                            .snippet("Znajdujemy sie w Warszawie")
                            .icon(BitmapDescriptorFactory
                                    .fromResource(R.drawable.warsa)));
                }
            }
        }

    public void finish(){
        super.finish();}
}
