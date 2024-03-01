package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Create_group_activity extends AppCompatActivity {
    ArrayList<users>arrayList;
    ArrayList<String>str;
    adapterforgroupingusers ad;
    RecyclerView recyclerView;
    FirebaseAuth mauth;
    FirebaseUser user;
    Button btn;
    EditText edt;
    ArrayList<eventlisteners>allevents;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        arrayList=new ArrayList<>();
        allevents=new ArrayList<>();
        str=new ArrayList<>();
        edt=findViewById(R.id.editTextText3);
        btn=findViewById(R.id.button2);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ad=new adapterforgroupingusers(this,arrayList);
        mauth=FirebaseAuth.getInstance();
        user=mauth.getCurrentUser();
        recyclerView.setAdapter(ad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupname=edt.getText().toString();
                if(groupname.equals("")){
                    Toast.makeText(Create_group_activity.this, "Enter the group Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String,String>hashMap=new HashMap<>();
                hashMap.put("Name",groupname);
                String customname="";
                int i=0;
                for( i=0;i<adapterforgroupingusers.group.size();i++){
                    hashMap.put(i+"",adapterforgroupingusers.group.get(i).getUid());
                    customname+=adapterforgroupingusers.group.get(i).getName();
                }
                hashMap.put(i+"",user.getUid());

                hashMap.put("custoomname",customname);
                DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Groups");
                reference.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Create_group_activity.this, "Group created Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Users");
        valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    if (!str.contains(dataSnapshot.getKey())) {
                        str.add(dataSnapshot.getKey());
                        users u = new users();
                        u.setUid(dataSnapshot.getKey());
                        u.setName(dataSnapshot.child("username").getValue(String.class));
                        u.setCaption(dataSnapshot.child("caption").getValue(String.class));
                        u.setStatus(dataSnapshot.child("status").getValue(String.class));
                        u.setP(dataSnapshot.child("profile").getValue(String.class));
                        if(!u.getUid().equals(user.getUid())) {
                            arrayList.add(u);
                        }


                    }
                }
                ad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        reference.addValueEventListener(valueEventListener);
        allevents.add(new eventlisteners(reference,valueEventListener));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for(int i=0;i<allevents.size();i++)
            allevents.get(i).getDb().removeEventListener(allevents.get(i).getVl());

      //  Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
    }
}