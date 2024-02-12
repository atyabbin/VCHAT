package com.example.vchatapp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragmentadapter extends FragmentPagerAdapter {
    public fragmentadapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new Chatfrag();
        else
            return new Groupfrag();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Chats";
            else
                return "Groups";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
