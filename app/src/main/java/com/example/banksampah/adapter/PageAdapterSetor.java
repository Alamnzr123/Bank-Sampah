package com.example.banksampah.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.banksampah.fragment.MenungguFragmentSetor;
import com.example.banksampah.fragment.SetorFragment;

public class PageAdapterSetor extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapterSetor(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SetorFragment();
            case 1:
                return new MenungguFragmentSetor();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
