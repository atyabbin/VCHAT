package com.example.vchatapp2;

public class users {
    String name,status,caption,uid;
    String p;

    public users(String name, String status, String caption, String p,String uid) {
        this.name = name;
        this.status = status;
        this.caption = caption;
        this.p = p;
        this.uid=uid;
    }

    public users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
