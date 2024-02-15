package com.example.vchatapp2;

import java.io.Serializable;
import java.util.ArrayList;

public class groups implements Serializable {
    String groupname,uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public boolean ispresent(ArrayList<groups>arrayList,groups g){
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).getUid().equals(g.getUid()))
                return true;
        }
        return false;
    }

    public groups(String groupname, String uid, ArrayList<String> members) {
        this.groupname = groupname;
        this.uid = uid;
        this.members = members;
    }

    ArrayList<String>members;

    public groups() {
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public groups(String groupname, ArrayList<String> members) {
        this.groupname = groupname;
        this.members = members;
    }
}
