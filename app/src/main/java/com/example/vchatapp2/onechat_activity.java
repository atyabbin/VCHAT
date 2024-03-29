package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class onechat_activity extends AppCompatActivity {

    String friendname,frienduserid;
    TextView t;
    ImageButton send;
    EditText msg;
    FirebaseAuth mauth;
    FirebaseUser user;
    ArrayList<messages>arrayList;
    Toolbar toolbar;
    RecyclerView msgrecyclerview;
    int p=0;

    ArrayList<String >msgid;
messageadapter messageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onechat);
        t=findViewById(R.id.textView11);
        send=findViewById(R.id.imageButton);
        toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        msg=findViewById(R.id.editTextText);
        msgid=new ArrayList<>();
        mauth=FirebaseAuth.getInstance();
        msgrecyclerview=findViewById(R.id.chatsrecyclerview);
        msgrecyclerview.setLayoutManager(new LinearLayoutManager(this));

        arrayList=new ArrayList<>();

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("messages");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    if(!msgid.contains(dataSnapshot.getKey())) {
                        if ((dataSnapshot.child("sender").getValue(String.class).equals(user.getUid())&&dataSnapshot.child("reciever").getValue(String.class).equals(frienduserid))||
                                (dataSnapshot.child("sender").getValue(String.class).equals(frienduserid)&&dataSnapshot.child("reciever").getValue(String.class).equals(user.getUid()))) {
                            messages m = new messages();
                            m.setMsgid(dataSnapshot.getKey());
                            msgid.add(dataSnapshot.getKey());
                            m.setMsg(dataSnapshot.child("message").getValue(String.class));
                            m.setLikes(dataSnapshot.child("likes").getValue(String.class));
                            m.setSender(dataSnapshot.child("sender").getValue(String.class));
                            m.setReciever(dataSnapshot.child("reciever").getValue(String.class));
                            arrayList.add(m);
                        }
                    }

                }
                messageadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        user=mauth.getCurrentUser();
        friendname=getIntent().getStringExtra("friendname");
        frienduserid=getIntent().getStringExtra("friendid");
        p=Integer.parseInt(getIntent().getStringExtra("profile"));

        t.setText(friendname);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msg.getText().toString().equals("")){
                    return;
                }
                sendmsg(msg.getText().toString());
                msg.setText("");
            }
        });
        messageadapter=new messageadapter(this,arrayList);
        msgrecyclerview.setAdapter(messageadapter);


    }
    public void sendmsg(String msg){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("sender",user.getUid());
        hashMap.put("message",msg);
        hashMap.put("reciever",frienduserid);
        hashMap.put("likes","0");
        reference.child("messages").push().setValue(hashMap);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        messageadapter.removeallevents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.location){
            Intent i=new Intent(this,MapsActivity.class);
            DatabaseReference mref=FirebaseDatabase.getInstance().getReference("Location").child(frienduserid);
            mref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        // User ID exists in the database
                        double latitude = snapshot.child("latitude").getValue(Double.class);
                        double longitude = snapshot.child("longitude").getValue(Double.class);
                        i.putExtra("lat",latitude+"");
                        i.putExtra("long",longitude+"");
                        startActivity(i);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            return true;
        }

        else{
           Intent i=new Intent(this, callactivity.class);
           i.putExtra("username",friendname);
           i.putExtra("userid",frienduserid);
           i.putExtra("profile",p+"");
           startActivity(i);
            return true;
        }
    }
}