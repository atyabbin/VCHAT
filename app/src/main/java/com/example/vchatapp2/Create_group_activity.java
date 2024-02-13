package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Create_group_activity extends AppCompatActivity {
    ArrayList<users>arrayList;
    ArrayList<String>str;
    adapterforgroupingusers ad;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        arrayList=new ArrayList<>();
        str=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ad=new adapterforgroupingusers(this,arrayList);
        recyclerView.setAdapter(ad);

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
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
                        arrayList.add(u);


                    }
                }
                //Toast.makeText(getContext(), arrayList.get(0).getName(), Toast.LENGTH_SHORT).show();
                ad.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}