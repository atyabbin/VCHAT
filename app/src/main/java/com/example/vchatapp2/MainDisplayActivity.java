package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager2.widget.ViewPager2;



import java.util.ArrayList;

public class MainDisplayActivity extends AppCompatActivity {
ViewPager viewPager;
TabLayout tb;
FirebaseAuth mauth;
FirebaseUser currentuser;
DatabaseReference mdatabase;

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
FirebaseDatabase.getInstance().getReference("Users").child(currentuser.getUid()).child("status").
        setValue("online").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        });




        setSupportActionBar(toolbar);




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

}