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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.FirebaseDatabaseKtxRegistrar;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.HashMap;

public class Signup_activity extends AppCompatActivity {
    EditText username,email,pass1,pass2;
    Button signup;
    TextView t;
    FirebaseAuth auth;
    DatabaseReference mdb;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=findViewById(R.id.myusername);
        email=findViewById(R.id.myemail);
        pass1=findViewById(R.id.mypassword);
        pass2=findViewById(R.id.mypassword2);
        signup=findViewById(R.id.signupbtn);
        t=findViewById(R.id.logintextvlivked);
        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            Intent i=new Intent(this,MainDisplayActivity.class);
            startActivity(i);
            finish();
        }


    }
    public void loginTextclicked(View view){
        Intent i=new Intent(this,login_activity.class);
        startActivity(i);
        finish();
    }

    public void signupbtnisclicked(View v){
        if(username.getText().toString().equals("")||
        email.getText().toString().equals("")||
        pass1.getText().toString().equals("")||
        pass2.getText().toString().equals("")){
            FancyToast.makeText(this,"Plzz Enter All The Details",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
            return;
        }
        if(!pass1.getText().toString().equals(pass2.getText().toString())){
            FancyToast.makeText(this,"Password not matching :(",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
            return;
        }
         progressDialog = ProgressDialog.show(this, "Signing Up", "Please wait...", true);
        signupfunction(email.getText().toString(),username.getText().toString(),
                pass1.getText().toString());
    }

    private void signupfunction(String email, String name, String password) {
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 FirebaseUser user=auth.getCurrentUser();
                 String userid=user.getUid();
                 mdb= FirebaseDatabase.getInstance().getReference("Users").child(userid);
                 HashMap<String ,String >hmap=new HashMap<>();
                 hmap.put("username",name);
                 hmap.put("status","Online");
                 hmap.put("profile",1+"");
                 hmap.put("caption","");
                 mdb.setValue(hmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {
                         if(task.isSuccessful()){
                          Intent i=new Intent(Signup_activity.this,setprofile_activity.class);
                           i.putExtra("userid",userid);
                           i.putExtra("username",name);
                           startActivity(i);
                           finish();

                         }else{
                             Toast.makeText(Signup_activity.this, "Failed..Plzz try again", Toast.LENGTH_SHORT).show();
                         }
                     }
                 });



}else{
                 Toast.makeText(Signup_activity.this, "Failed to create user: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
             }
            }
        });

    }

}