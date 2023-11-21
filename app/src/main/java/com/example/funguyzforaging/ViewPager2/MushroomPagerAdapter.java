package com.example.funguyzforaging.ViewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.funguyzforaging.Fragments.EdibleMushFragment;
import com.example.funguyzforaging.Fragments.MagicMushFragment;
import com.example.funguyzforaging.Fragments.PoisonMushFragment;

public class MushroomPagerAdapter extends FragmentStateAdapter {
    public MushroomPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new EdibleMushFragment();
            case 1:
                return new PoisonMushFragment();
            case 2:
                return new MagicMushFragment();
            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

