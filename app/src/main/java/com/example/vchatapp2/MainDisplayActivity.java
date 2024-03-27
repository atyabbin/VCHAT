package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.tabs.TabLayout;
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

import androidx.viewpager2.widget.ViewPager2;



import java.util.ArrayList;
import java.util.HashMap;

public class MainDisplayActivity extends AppCompatActivity {
ViewPager viewPager;
TabLayout tb;
FirebaseAuth mauth;
FirebaseUser currentuser;
DatabaseReference mdatabase;
String username;
    private static final int REQUEST_CODE = 100;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_display);

        Toolbar toolbar = findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewpager);
        tb=findViewById(R.id.tabs);
        fragmentadapter fragmentadapter=new fragmentadapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentadapter);
tb.setupWithViewPager(viewPager);
mauth=FirebaseAuth.getInstance();
        currentuser=mauth.getCurrentUser();
DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Users").child(currentuser.getUid());
reference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(snapshot.exists()){
            username=snapshot.child("username").getValue(String.class);
           // Toast.makeText(MainDisplayActivity.this, username, Toast.LENGTH_SHORT).show();
            currentuser=mauth.getCurrentUser();

            prepareforcall(currentuser.getUid());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});

FirebaseDatabase.getInstance().getReference("Users").child(currentuser.getUid()).child("status").
        setValue("online").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        });




        setSupportActionBar(toolbar);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    updatemylocationtofirebase(location.getLatitude(),location.getLongitude());

                }
            }
        };
        requestLocationPermission();





    }

    private void prepareforcall(String uid) {
        Application application = getApplication(); // Android's application context
        long appID =171565141 ;   // yourAppID
        String appSign ="e2008998c0f02fe7553312621ec95049ebaa5b6461b40bd21f52d50c7216b332";  // yourAppSign
        String userID =uid; // yourUserID, userID should only contain numbers, English characters, and '_'.
        String userName =username;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        ZegoNotificationConfig zegoNotificationConfig=new ZegoNotificationConfig();
        zegoNotificationConfig.sound="zego_uikit_sound_call";
        zegoNotificationConfig.channelID="CallInvitation";
        zegoNotificationConfig.channelName="CallInvitation";

        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userID, userName,callInvitationConfig);
    }

    public void updatemylocationtofirebase(double lat,double longt){
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Location").child(currentuser.getUid());
        HashMap<String, Object> locationMap = new HashMap<>();
        locationMap.put("latitude", lat);
        locationMap.put("longitude", longt);
        reference.setValue(locationMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
               // Toast.makeText(MainDisplayActivity.this,"Location Created",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void requestLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        } else {
            startLocationUpdates();
        }
    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        } else {


            fusedLocationProviderClient.requestLocationUpdates(LocationRequest.create(), locationCallback, null);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }













    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Intent i=new Intent(this,Signup_activity.class)
                    ;
            FirebaseDatabase.getInstance().getReference().child("Users").child(currentuser.getUid()).child("status").setValue("offline").addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                }
            });

            startActivity(i);
            finish();
            return true;
        }else{
            Intent i=new Intent(this,setprofile_activity.class)
                    ;
            startActivity(i);

            return true;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}