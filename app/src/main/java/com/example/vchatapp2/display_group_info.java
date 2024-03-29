package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class display_group_info extends AppCompatActivity {
    groups g;
    TextView groupname,members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_group_info);
        g=(groups) getIntent().getSerializableExtra("group");
        groupname=findViewById(R.id.textView3);
        members=findViewById(R.id.textView21);
        groupname.setText(g.getGroupname());
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()) {


                            users u = new users();
                            u.setUid(dataSnapshot.getKey());
                            u.setName(dataSnapshot.child("username").getValue(String.class));
                            u.setCaption(dataSnapshot.child("caption").getValue(String.class));
                            u.setStatus(dataSnapshot.child("status").getValue(String.class));
                            u.setP(dataSnapshot.child("profile").getValue(String.class));
                            if(g.getMembers().contains(u.getUid())) {
                                members.setText(members.getText()+u.getName()+"\n");
                            }



                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}