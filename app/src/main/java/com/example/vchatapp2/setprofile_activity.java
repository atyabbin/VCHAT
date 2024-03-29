package com.example.vchatapp2;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.HashMap;

public class setprofile_activity extends AppCompatActivity {
    ImageView img1;
    ImageView img2,img3,img4,img5,img6,img7,img8,img9,img10;
    int f=0;
    EditText edt;
    Button save;
    FirebaseAuth mauth;
    FirebaseUser user;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setprofile);
        img1=findViewById(R.id.imageView2);
        mauth=FirebaseAuth.getInstance();
        user=mauth.getCurrentUser();
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username=snapshot.child("username").getValue(String.class);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        img2=findViewById(R.id.imageView3);
        edt=findViewById(R.id.editTextText4);
        save=findViewById(R.id.button);
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
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("caption",edt.getText().toString());
        hashMap.put("username",username);
        hashMap.put("status","online");
        hashMap.put("profile",f+"");
        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                FancyToast.makeText(setprofile_activity.this,"Changes Saved!!!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                finish();

            }
        });





    }


}