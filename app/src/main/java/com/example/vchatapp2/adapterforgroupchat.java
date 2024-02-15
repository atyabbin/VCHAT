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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adapterforgroupchat extends RecyclerView.Adapter<adapterforgroupchat.ViewHolder> {
    Context context;
    ArrayList<GroupMessages>arrayList;
    groups g;

    public adapterforgroupchat(ArrayList<GroupMessages>arrayList, Context context,groups cu){
        g=cu;
        this.arrayList=arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public adapterforgroupchat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==1) {
            View v = LayoutInflater.from(context).inflate(R.layout.group_chat_right, parent, false);
            ViewHolder viewHolder = new ViewHolder(v,1);
            return viewHolder;
        }
        else {
            View v1 = LayoutInflater.from(context).inflate(R.layout.groupchat_left, parent, false);
            ViewHolder viewHolder1 = new ViewHolder(v1,0);
            return viewHolder1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull adapterforgroupchat.ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.msg.setText(arrayList.get(position).getMsg());


        if(holder.f==0){
            FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").child(arrayList.get(holder.getAdapterPosition()).getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String lik=snapshot.child("liked").getValue(String.class);
                        if(lik.equals("1")){
                            holder.img.setImageResource(R.drawable.heartfilled);
                        }else{
                            holder.img.setImageResource(R.drawable.heartunfilled);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }



        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").child(arrayList.get(holder.getAdapterPosition()).getUid()).child("liked").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String lik=snapshot.getValue(String.class);
                            if(lik.equals("0")){
                                FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").child(arrayList.get(holder.getAdapterPosition()).getUid()).child("liked").setValue("1");
                            }else{
                                FirebaseDatabase.getInstance().getReference("Groups").child(g.getUid()).child("messages").child(arrayList.get(holder.getAdapterPosition()).getUid()).child("liked").setValue("0");

                            }
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
        TextView name,msg;
        ImageView img;
        int f=0;
        public ViewHolder(@NonNull View itemView,int type) {
            super(itemView);
            if(type==1) {
                name = itemView.findViewById(R.id.textView16);
                msg = itemView.findViewById(R.id.textView17);
                img = itemView.findViewById(R.id.imageView12);
            }else{
                name = itemView.findViewById(R.id.textView18);
                msg = itemView.findViewById(R.id.textView19);
                img = itemView.findViewById(R.id.imageView13);
            }

        }
    }

    @Override
    public int getItemViewType(int position) {
if(arrayList.get(position).getName().equals(GroupChat_activity.curruser))
    return 1;

return  0;
    }
}
