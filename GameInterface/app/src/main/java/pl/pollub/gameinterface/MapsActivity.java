package pl.pollub.gameinterface;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng lublin = new LatLng(51.2465, 22.5684);

        if (mMap != null) {
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(lublin)
                    .title("Lublin")
                    .snippet("Mapa Lublina")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.lubel)));
        }

        // Move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lublin));
        // Zoom in, animating the camera
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lublin, 15.5f));

    }

    public void finish(){
        super.finish();}
}
