package com.sitia.uts_akb_if9_10118355.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sitia.uts_akb_if9_10118355.R;
import com.sitia.uts_akb_if9_10118355.adapter.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = view.findViewById(R.id.pager);

        pagerAdapter = new SliderPagerAdapter(getActivity().getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);

        return view;
    }
}
