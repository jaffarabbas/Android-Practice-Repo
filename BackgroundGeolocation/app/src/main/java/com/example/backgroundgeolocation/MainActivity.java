package com.example.backgroundgeolocation;//package com.example.backgroundgeolocation;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationCallback;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.location.LocationResult;
//import com.google.android.gms.location.LocationServices;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final int PERMISSION_REQUEST_CODE = 100;
//
//    private FusedLocationProviderClient fusedLocationClient;
//    private LocationRequest locationRequest;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
//        locationRequest = LocationRequest.create();
//        locationRequest.setInterval(10000); // Update interval in milliseconds
//        locationRequest.setFastestInterval(5000); // Fastest update interval in milliseconds
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//        // Check for location permissions
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Request location permissions
//            ActivityCompat.requestPermissions(
//                    this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    PERMISSION_REQUEST_CODE
//            );
//        } else {
//            // Permissions already granted, start location updates
//            startLocationUpdates();
//        }
//    }
//
//    private void startLocationUpdates() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        fusedLocationClient.requestLocationUpdates(
//                locationRequest,
//                locationCallback,
//                null /* Looper */
//        );
//    }
//
//    private LocationCallback locationCallback = new LocationCallback() {
//        @Override
//        public void onLocationResult(LocationResult locationResult) {
//            super.onLocationResult(locationResult);
//            // Handle location updates here
//            Location location = locationResult.getLastLocation();
//            // Do something with the location data
//            Toast.makeText(
//                    MainActivity.this,
//                    "Lat: " + location.getLatitude() + ", Long: " + location.getLongitude(),
//                    Toast.LENGTH_SHORT
//            ).show();
//        }
//    };
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted, start location updates
//                startLocationUpdates();
//            } else {
//                // Permission denied, show a message or handle accordingly
//                Toast.makeText(
//                        this,
//                        "Location permission denied",
//                        Toast.LENGTH_SHORT
//                ).show();
//            }
//        }
//    }
//}
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.LocationRequest;

public class MainActivity extends AppCompatActivity {

    private LocationForegroundService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this, LocationForegroundService.class);
        startService(serviceIntent);
    }
}
