package com.sitia.uts_akb_if9_10118355.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sitia.uts_akb_if9_10118355.R;

public class PageFragment2 extends Fragment {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_2,container,false);


        return rootView;
    }
}