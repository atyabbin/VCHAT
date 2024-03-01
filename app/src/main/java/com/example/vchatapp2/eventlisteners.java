package com.example.vchatapp2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class eventlisteners {
    public DatabaseReference getDb() {
        return db;
    }

    public void setDb(DatabaseReference db) {
        this.db = db;
    }

    public ValueEventListener getVl() {
        return vl;
    }

    public void setVl(ValueEventListener vl) {
        this.vl = vl;
    }

    DatabaseReference db;
    ValueEventListener vl;
    myadapter.ViewHolder holder;

    public eventlisteners(DatabaseReference db, ValueEventListener vl) {
        this.db = db;
        this.vl = vl;
    }

    public myadapter.ViewHolder getHolder() {
        return holder;
    }

    public void setHolder(myadapter.ViewHolder holder) {
        this.holder = holder;
    }

    public eventlisteners(DatabaseReference db, ValueEventListener vl, myadapter.ViewHolder holder) {
        this.db = db;
        this.vl = vl;
        this.holder = holder;
    }


}
