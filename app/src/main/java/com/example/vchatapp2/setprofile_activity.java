package com.example.vchatapp2;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class setprofile_activity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setprofile);
        img1=findViewById(R.id.imageView2);

        img2=findViewById(R.id.imageView3);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));

            }
        });
    }

    public void btnisclicked(View v){
        finish();
    }


}