package com.rattle.instawash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    FloatingActionButton fam, fab_interior, fab_total;
    Boolean is_fam_open = false;
    CardView text_interior, text_total;
    DrawerLayout drawer;
    ImageButton imb;
    RelativeLayout rl;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        rl = findViewById(R.id.rel);
        imb = findViewById(R.id.imageButton);
        drawer = findViewById(R.id.drawer_layout);

        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        fam = findViewById(R.id.fam);
        fab_interior = findViewById(R.id.fab_interior);
        fab_total = findViewById(R.id.fab_total);
        text_interior = findViewById(R.id.interior);
        text_total = findViewById(R.id.total);
        is_fam_open = false;
        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_fam_open) {
                    fab_interior.animate().translationY(0.0f).alpha(0.0f);
                    text_interior.animate().translationY(0.0f).alpha(0.0f);
                    fab_total.animate().translationY(0.0f).alpha(0.0f);
                    text_total.animate().translationY(0.0f).alpha(0.0f);
                    rl.animate().alpha(0.0f);

                } else {
                    fab_interior.animate().translationY(-130.0f).alpha(1.0f);
                    text_interior.animate().translationY(-140.0f).alpha(1.0f);
                    fab_total.animate().translationY(-240.0f).alpha(1.0f);
                    text_total.animate().translationY(-250.0f).alpha(1.0f);
                    rl.animate().alpha(0.8f);
                }
                is_fam_open = !is_fam_open;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
