package shaz.com.newyear;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int rank;
    private ImageView mImage;
    LatLng latLng = new LatLng(-34, 151);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mImage = findViewById(R.id.image);
        rank = getIntent().getExtras().getInt("rank");

        switch (rank) {
            case 0:
                latLng = new LatLng(-29.387428, 79.455316);
                mImage.setImageResource(R.drawable.nainital);
                break;
            case 1:
                mImage.setImageResource(R.drawable.haldwani);
                latLng = new LatLng(29.218264, 79.512977);
                break;
            case 2:
                latLng = new LatLng(29.844527, 79.603884);
                mImage.setImageResource(R.drawable.kausani);
                break;
            case 3:
                latLng = new LatLng(29.665308, 79.470913);
                mImage.setImageResource(R.drawable.ranikhet);
                break;
            case 4:
                latLng = new LatLng(30.275674, 78.074962);
                mImage.setImageResource(R.drawable.dehradun);
                break;
            case 5:
                latLng = new LatLng(28.593681, 77.221834);
                mImage.setImageResource(R.drawable.delh);
                break;

        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
     //   mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.addMarker(new MarkerOptions().position(latLng).title("Rank "+(rank+1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
    }
}
