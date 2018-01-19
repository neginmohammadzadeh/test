package com.example.negin.mapapplication.Map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.negin.mapapplication.DAL.location;
import com.example.negin.mapapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_maps)
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback , MapContract.View,GoogleMap.OnCameraIdleListener,GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnMarkerClickListener {


    @ViewById
    EditText et_address;

    @ViewById
    ImageView imageView;

    private GoogleMap mMap;
    LocationManager locationManager;
    double lat;
    double lng;

    MapContract.Presenter presenter;
    @AfterViews
    void init(){

        presenter= new MapPresenter();
        presenter.attachview(this);
        presenter.attachContext(MapsActivity.this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1058);
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        et_address.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    presenter.sendAddressText(et_address.getText().toString());

                    return true;
                }
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = mMap.getCameraPosition().target.latitude + "";
                String lng = mMap.getCameraPosition().target.longitude + "";
                et_address.setText(lat+","+lng);
            }
        });



    }




    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        mMap.setMyLocationEnabled(true);
        mMap.setOnCameraIdleListener(this);
        mMap.setOnCameraMoveStartedListener(this);
        mMap.setOnMarkerClickListener(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        LatLng ll=null;
        if(location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
        }
        ll = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 18));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomGesturesEnabled(true);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSearchResult(location location) {
        MarkerOptions options = new MarkerOptions();
        options.position(new LatLng( Double.parseDouble(location.getLat()),Double.parseDouble(location.getLng())));
        options.title("selected address");
        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng( Double.parseDouble(location.getLat()),Double.parseDouble(location.getLng())), 18));
    }

    @Override
    public void onSearchError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCameraIdle() {

        String lat = mMap.getCameraPosition().target.latitude + "";
        String lng = mMap.getCameraPosition().target.longitude + "";
//        et_address.setText(lat+","+lng);
    }


    @Override
    public void onCameraMoveStarted(int i) {
        et_address.setText("");

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        String lat = mMap.getCameraPosition().target.latitude + "";
        String lng = mMap.getCameraPosition().target.longitude + "";
        et_address.setText(lat+","+lng);
        return false;
    }

}
