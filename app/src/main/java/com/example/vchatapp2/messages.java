package com.example.vchatapp2;

public class messages {
    String sender,reciever,msg,likes,msgid;

    public messages() {
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public messages(String sender, String reciever, String msg, String likes) {
        this.sender = sender;
        this.reciever = reciever;
        this.msg = msg;
        this.likes = likes;
    }
}
