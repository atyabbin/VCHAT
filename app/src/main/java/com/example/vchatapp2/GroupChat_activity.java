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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class GroupChat_activity extends AppCompatActivity {
    groups g;
    TextView t;
    EditText edt;
    ImageButton send;
    FirebaseUser user;
  static String curruser;
   adapterforgroupchat ad;
   ArrayList<GroupMessages>arrayList;
   ArrayList<String>str;
   RecyclerView recyclerView;
    int f=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        g=(groups) getIntent().getSerializableExtra("group");
        t=findViewById(R.id.textView14);
        t.setText(g.getGroupname());

        edt=findViewById(R.id.editTextText2);
        send=findViewById(R.id.imageButton2);
        user= FirebaseAuth.getInstance().getCurrentUser();
        str=new ArrayList<>();
        arrayList=new ArrayList<>();

        FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                        for(DataSnapshot dataSnapshot:snapshot.getChildren()) {
                            if(!str.contains(dataSnapshot.getKey())){
                                str.add(dataSnapshot.getKey());
                            GroupMessages msg = new GroupMessages();
                            msg.setName(dataSnapshot.child("sender_name").getValue(String.class));
                            msg.setSender(dataSnapshot.child("sender_uid").getValue(String.class));
                            msg.setMsg(dataSnapshot.child("message").getValue(String.class));
                            msg.setIsliked(dataSnapshot.child("liked").getValue(String.class));
                            msg.setUid(dataSnapshot.getKey());
                            arrayList.add(msg);


                        }

                    }
                    ad.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        FirebaseDatabase.getInstance().getReference("Users").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    curruser=snapshot.child("username").getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        ad=new adapterforgroupchat(arrayList,this,g);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ad);



    }

    public void sendmessage(View v){
        if(edt.getText().toString().equals(""))
            return;
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Groups");
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("sender_uid",user.getUid());
        hashMap.put("sender_name",curruser);
        hashMap.put("message",edt.getText().toString());
        hashMap.put("liked","0");

        FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
        edt.setText("");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ad.removeallevents();
    }
}