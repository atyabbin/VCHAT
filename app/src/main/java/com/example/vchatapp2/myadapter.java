package com.example.vchatapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder>{

    private final ArrayList<users> arrayList;

    private final Context context;

    public myadapter(Context context, ArrayList<users>arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View v= LayoutInflater.from(context).inflate(R.layout.my_layout,parent,false);
ViewHolder viewHolder=new ViewHolder(v);
return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.ViewHolder holder, int position) {
        holder.namestr.setText(arrayList.get(position).getName());
        if(holder.f==0){
            holder.f=1;
            DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users").child(arrayList.get(holder.getAdapterPosition()).getUid()).child("status");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String status=snapshot.getValue(String.class);
                        holder.statusstr.setText(status);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        holder.captionstr.setText(arrayList.get(position).getCaption());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(context, onechat_activity.class);
        i.putExtra("friendid",arrayList.get(position).getUid());
        i.putExtra("friendname",arrayList.get(position).getName());
        context.startActivity(i);
    }
});


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namestr,statusstr,captionstr;
        ImageView img;
        ValueEventListener valueEventListener;
        DatabaseReference dbs;
        int f=0;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namestr=itemView.findViewById(R.id.textView7);
            captionstr=itemView.findViewById(R.id.textView8);
            statusstr=itemView.findViewById(R.id.textView9);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
