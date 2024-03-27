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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class setprofile_activity extends AppCompatActivity {
    ImageView img1;
    ImageView img2,img3,img4,img5,img6,img7,img8,img9,img10;
    int f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setprofile);
        img1=findViewById(R.id.imageView2);

        img2=findViewById(R.id.imageView3);
        img3=findViewById(R.id.imageView5);
        img4=findViewById(R.id.imageView6);
        img5=findViewById(R.id.imageView16);
        img6=findViewById(R.id.imageView17);
        img7=findViewById(R.id.imageView18);
        img8=findViewById(R.id.imageView19);
        img9=findViewById(R.id.imageView20);
        img10=findViewById(R.id.imageView21);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=7;
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=8;
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=9;
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=4;
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=5;
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=2;
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=3;
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=0;
               // Toast.makeText(setprofile_activity.this, "rkmf4r", Toast.LENGTH_SHORT).show();
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=1;
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=6;
                img1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.myback));
                img2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img10.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img9.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img8.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img7.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img6.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
                img3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mybackdefault));
            }
        });
    }

    public void btnisclicked(View v){

        finish();

    }


}