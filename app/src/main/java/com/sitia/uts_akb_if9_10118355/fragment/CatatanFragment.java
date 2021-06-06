package com.sitia.uts_akb_if9_10118355.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sitia.uts_akb_if9_10118355.R;
import com.sitia.uts_akb_if9_10118355.activity.InputActivity;
import com.sitia.uts_akb_if9_10118355.adapter.ListViewAdapter;
import com.sitia.uts_akb_if9_10118355.helper.SQLiteHelper;
import com.sitia.uts_akb_if9_10118355.utils.DataCatatan;

import java.util.ArrayList;

public class CatatanFragment extends Fragment {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    FloatingActionButton fab;
    private ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<DataCatatan> listCatatan = new ArrayList<>();
    private SQLiteHelper helper;
    private SwipeRefreshLayout refresh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_catatan,container,false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        listView = (ListView)view.findViewById(R.id.list_view);
        refresh = (SwipeRefreshLayout)view.findViewById(R.id.refresh);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                menampilkanData();
            }
        });

        helper = new SQLiteHelper(this.getActivity());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InputActivity.class));
            }
        });
        menampilkanData();
        return view;
    }

    public void menampilkanData(){
        listCatatan.clear();
        Cursor res = helper.getDataAll();
        refresh.setRefreshing(true);
        while (res.moveToNext()){
            String id = res.getString(0);
            String tanggal = res.getString(1);
            String judul = res.getString(2);
            String kategori = res.getString(3);
            String catatan = res.getString(4);


            listCatatan.add(new DataCatatan(id,
                    tanggal,
                    judul,
                    kategori,
                    catatan));
        }
        adapter = new ListViewAdapter(listCatatan, getActivity());
        listView.setAdapter(adapter);

        refresh.setRefreshing(false);
    }

}
