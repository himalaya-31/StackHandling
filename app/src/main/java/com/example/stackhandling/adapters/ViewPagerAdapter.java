package com.example.stackhandling.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.stackhandling.views.FragmentOneRootView;
import com.example.stackhandling.views.FragmentThreeRootView;
import com.example.stackhandling.views.FragmentTwoRootView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments.add(FragmentOneRootView.newInstance());
        fragments.add(FragmentTwoRootView.newInstance());
        fragments.add(FragmentThreeRootView.newInstance());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
