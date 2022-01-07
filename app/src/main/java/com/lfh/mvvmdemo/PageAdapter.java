package com.lfh.mvvmdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lfh.mvvmdemo.fragment.FirstFragment;
import com.lfh.mvvmdemo.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter  extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.fragmentList.add(new FirstFragment());
        this.fragmentList.add(new SecondFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
