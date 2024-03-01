package com.example.vchatapp2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Chatfrag extends Fragment {

DatabaseReference mdatabase;
ArrayList<users>arrayList;
ArrayList<String>str;
myadapter ad;
RecyclerView recyclerView;
FirebaseUser user;
    public Chatfrag() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_chatfrag,container,false);
        mdatabase= FirebaseDatabase.getInstance().getReference("Users");
        arrayList=new ArrayList<>();
        recyclerView=v.findViewById(R.id.recyclerview);
        ad=new myadapter(getContext(),arrayList);
        user= FirebaseAuth.getInstance().getCurrentUser();
        str=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(ad);
        mdatabase.addValueEventListener(new ValueEventListener() {
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
                //Toast.makeText(getContext(), arrayList.get(0).getName(), Toast.LENGTH_SHORT).show();
                ad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "destroyed", Toast.LENGTH_SHORT).show();
        ad.removealllisteners();
    }
}