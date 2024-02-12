package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

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
    RecyclerView msgrecyclerview;
    ArrayList<String >msgid;
messageadapter messageadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onechat);
        t=findViewById(R.id.textView11);
        send=findViewById(R.id.imageButton);
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
}