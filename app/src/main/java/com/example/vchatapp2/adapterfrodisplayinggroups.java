package com.example.vchatapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterfrodisplayinggroups extends RecyclerView.Adapter<adapterfrodisplayinggroups.ViewHolder> {
    Context context;
    ArrayList<groups>arrayList;
    public adapterfrodisplayinggroups(Context context, ArrayList<groups>arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }
    @NonNull
    @Override
    public adapterfrodisplayinggroups.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.layout_for_groups,parent,false);
       ViewHolder viewHolder=new ViewHolder(v);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterfrodisplayinggroups.ViewHolder holder, int position) {
           holder.t.setText(arrayList.get(position).getGroupname());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i=new Intent(context, GroupChat_activity.class);
                   i.putExtra("group",arrayList.get(holder.getAdapterPosition()));
                   context.startActivity(i);

               }
           });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.textView15);
        }
    }
}
