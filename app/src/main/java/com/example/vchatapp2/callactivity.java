package com.example.vchatapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoAcceptCallInvitationButton;
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class callactivity extends AppCompatActivity {
    String userid,name;
    ZegoSendCallInvitationButton videocall,voicecall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callactivity);
        name=getIntent().getStringExtra("username");
        userid=getIntent().getStringExtra("userid");


        videocall=findViewById(R.id.videocall);
        videocall.setIsVideoCall(true);
        videocall.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        videocall.setInvitees(Collections.singletonList(new ZegoUIKitUser(userid)));
       voicecall=findViewById(R.id.voicecall);
        voicecall.setIsVideoCall(false);
        voicecall.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        voicecall.setInvitees(Collections.singletonList(new ZegoUIKitUser(userid)));

    }
}