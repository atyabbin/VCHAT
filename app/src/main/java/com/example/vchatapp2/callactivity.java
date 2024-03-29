package com.example.vchatapp2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class callactivity extends AppCompatActivity {
    String userid,name;
    ZegoSendCallInvitationButton videocall;
    ZegoSendCallInvitationButton voicecall;
    int p=0;
    ImageView img;
    int prifles[]={R.drawable.profile10,R.drawable.profile11,R.drawable.profile8,
            R.drawable.profile9,R.drawable.boypic,R.drawable.profile2,R.drawable.profile3,R.drawable.profile4,
            R.drawable.profile5,R.drawable.profile6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callactivity);
        name=getIntent().getStringExtra("username");
        userid=getIntent().getStringExtra("userid");
        p=Integer.parseInt(getIntent().getStringExtra("profile"));
        img=findViewById(R.id.imageView15);
        img.setImageResource(prifles[p]);
        TextView t=findViewById(R.id.textView4);
        t.setText(name.toUpperCase());


        videocall=findViewById(R.id.vidcall);
        videocall.setIsVideoCall(true);
        videocall.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        videocall.setInvitees(Collections.singletonList(new ZegoUIKitUser(userid)));
       voicecall=findViewById(R.id.vcall);
        voicecall.setIsVideoCall(false);
        voicecall.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        voicecall.setInvitees(Collections.singletonList(new ZegoUIKitUser(userid)));

    }
}