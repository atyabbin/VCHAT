package com.example.vchatapp2;

public class GroupMessages {
    String sender;
    String msg;
    String name;
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public GroupMessages(String sender, String msg, String name, String uid, String isliked) {
        this.sender = sender;
        this.msg = msg;
        this.name = name;
        this.uid = uid;
        this.isliked = isliked;
    }

    public String getIsliked() {
        return isliked;
    }

    public void setIsliked(String isliked) {
        this.isliked = isliked;
    }

    public GroupMessages(String sender, String msg, String name, String isliked) {
        this.sender = sender;
        this.msg = msg;
        this.name = name;
        this.isliked = isliked;
    }

    String isliked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupMessages(String sender, String msg, String name) {
        this.sender = sender;
        this.msg = msg;
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public GroupMessages() {
    }

    public GroupMessages(String sender, String msg) {
        this.sender = sender;
        this.msg = msg;
    }
}
