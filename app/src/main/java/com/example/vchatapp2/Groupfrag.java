package com.example.vchatapp2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Groupfrag extends Fragment {
ImageView addbtn;
ArrayList<groups>arrayList;
RecyclerView recyclerView;
adapterfrodisplayinggroups ad;
FirebaseAuth mauth;
FirebaseUser user;
    DatabaseReference reference;
ValueEventListener valueEventListener;


    public Groupfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_groupfrag, container, false);
        addbtn=v.findViewById(R.id.imageView8);
        arrayList=new ArrayList<>();
        recyclerView=v.findViewById(R.id.recyclerView);
        mauth=FirebaseAuth.getInstance();
        user=mauth.getCurrentUser();

        ad=new adapterfrodisplayinggroups(getContext(),arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(ad);
         reference= FirebaseDatabase.getInstance().getReference("Groups");
         valueEventListener=new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if(snapshot.exists()){

                     for(DataSnapshot dataSnapshot:snapshot.getChildren()) {

                         groups g = new groups();
                         ArrayList<String >s=new ArrayList<>();
                         g.setGroupname(dataSnapshot.child("Name").getValue(String.class));
                         g.setUid(dataSnapshot.getKey());
                         try {
                             for (int i = 0; i < dataSnapshot.getChildrenCount() - 2; i++) {
                                 s.add(dataSnapshot.child(i + "").getValue(String.class));
                             }
                         }catch (Exception e){

                         }
                         g.setMembers(s);
                         if(!g.ispresent(arrayList,g)&&g.members.contains(user.getUid()))
                             arrayList.add(g);
                         ad.notifyDataSetChanged();

                     }



                 }

             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         };
        reference.addValueEventListener(valueEventListener);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Create_group_activity.class);
                startActivity(i);
            }
        });


        return  v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        reference.removeEventListener(valueEventListener);
    }
}