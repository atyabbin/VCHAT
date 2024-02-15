package com.example.vchatapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class messageadapter extends RecyclerView.Adapter<messageadapter.ViewHolder> {
    Context context;
    public static int msg_right=1;
    public static int msg_left=0;
    ArrayList<messages>arrayList;

    public  messageadapter(Context context, ArrayList<messages>arrayList){
        this.context=context;
        this.arrayList=arrayList;



    }



    @NonNull
    @Override
    public messageadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==msg_right){
            View v= LayoutInflater.from(context).inflate(R.layout.message_on_right,parent,false);
            return new messageadapter.ViewHolder(v,msg_right);
        }else{
            View v1= LayoutInflater.from(context).inflate(R.layout.message_on_left,parent,false);
            return new messageadapter.ViewHolder(v1,msg_left);
        }
    }



    @Override
    public void onBindViewHolder(@NonNull messageadapter.ViewHolder holder, int position) {
        messages message = arrayList.get(position);
        holder.msg.setText(message.getMsg());

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("messages");
        if (holder.f == 0) {
            holder.f=1;
            holder.listener= new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String likes=snapshot.getValue(String.class);
                        if(likes!=null){
                            if(likes.equals("1")) {
                                holder.liked.setImageResource(R.drawable.heartfilled);
                            }
                            else {
                                holder.liked.setImageResource(R.drawable.heartunfilled);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            };
            reference.child(arrayList.get(holder.getAdapterPosition()).getMsgid()).child("likes").addValueEventListener(holder.listener);

        }


        holder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref=FirebaseDatabase.getInstance().getReference("messages");
                ref.child(arrayList.get(holder.getAdapterPosition()).getMsgid()).child("likes").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String likes=snapshot.getValue(String.class);
                            if(likes!=null && likes.equals("0"))
                                ref.child(arrayList.get(holder.getAdapterPosition()).getMsgid()).child("likes").setValue("1");
                            else if(likes!=null && likes.equals("1"))
                                ref.child(arrayList.get(holder.getAdapterPosition()).getMsgid()).child("likes").setValue("0");

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView msg;
        ImageView liked,profile;
        int type;
        int f=0;
        ValueEventListener listener;

        public ViewHolder(@NonNull View itemView,int type) {
            super(itemView);

            if(type==1){
                liked=itemView.findViewById(R.id.imageView7);
                msg=itemView.findViewById(R.id.textView10);
            }else{
                liked=itemView.findViewById(R.id.imageView10);
                msg=itemView.findViewById(R.id.textView12);

            }


        }


    }

    @Override
    public int getItemViewType(int position){

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        if(arrayList.get(position).getSender().equals(user.getUid()))
            return msg_right;
        else
            return msg_left;
    }


}
