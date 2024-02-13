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

import java.util.ArrayList;

public class adapterforgroupingusers extends RecyclerView.Adapter<adapterforgroupingusers.ViewHolder> {

    ArrayList<users>arrayList;
    Context context;

    public adapterforgroupingusers(Context context, ArrayList<users>arrayList){
        this.context=context;
        this.arrayList=arrayList;


    }
    @NonNull
    @Override
    public adapterforgroupingusers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_for_grouping_users,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterforgroupingusers.ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.isticked){
                    holder.tick.setVisibility(View.VISIBLE);
                    holder.isticked=true;
                }else{
                    holder.tick.setVisibility(View.GONE);
                    holder.isticked=false;
                }


            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img,tick;
        boolean isticked=false;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textView13);
            img=itemView.findViewById(R.id.imageView9);
            tick=itemView.findViewById(R.id.imageView11);
        }
    }
}
