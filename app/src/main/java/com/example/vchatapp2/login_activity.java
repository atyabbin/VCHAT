package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class login_activity extends AppCompatActivity {

    EditText email,pass;
    TextView t;
    Button login;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.myloginemail);
        pass=findViewById(R.id.myloginpass);
        t=findViewById(R.id.mysignuptext);
        login=findViewById(R.id.myloginbtn);
        auth= FirebaseAuth.getInstance();

    }
    public void textisclicked(View v){
        Intent i=new Intent(this, Signup_activity.class);
        startActivity(i);
        finish();
    }

    public void loginbtnisclicked(View v){

        if(email.getText().toString().equals("")||
        pass.getText().toString().equals("")){
            FancyToast.makeText(this,"Plzz Enter Valid Information",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
            return;
        }
        progressDialog = ProgressDialog.show(this, "Logging In", "Please wait...", true);

        auth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent i=new Intent(login_activity.this,MainDisplayActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    FancyToast.makeText(login_activity.this,"Failed : "+task.getException().getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                    progressDialog.dismiss();

                }
            }
        });

    }
}