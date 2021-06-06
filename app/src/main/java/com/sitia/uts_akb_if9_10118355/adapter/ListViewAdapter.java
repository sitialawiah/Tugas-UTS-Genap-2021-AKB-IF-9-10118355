package com.sitia.uts_akb_if9_10118355.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sitia.uts_akb_if9_10118355.R;
import com.sitia.uts_akb_if9_10118355.activity.EditActivity;
import com.sitia.uts_akb_if9_10118355.helper.SQLiteHelper;
import com.sitia.uts_akb_if9_10118355.utils.DataCatatan;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    private List<DataCatatan> listCatatan;
    private Context context;
    private SQLiteHelper helper;
    TextView tv_tanggal,tv_judul,tv_kategori,tv_catatan;
    LinearLayout linear;
    private ImageView hapus,edit;

    public ListViewAdapter(List<DataCatatan> listCatatan, Context context) {
        this.listCatatan = listCatatan;
        this.context = context;

    }

    @Override
    public int getCount() {
        return listCatatan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_catatan,null);
        tv_tanggal = v.findViewById(R.id.tv_tanggal);
        tv_judul = v.findViewById(R.id.tv_judul);
        tv_kategori = v.findViewById(R.id.tv_kategori);
        tv_catatan = v.findViewById(R.id.tv_catatan);
        linear = v.findViewById(R.id.linear);
        edit = v.findViewById(R.id.edit);
        hapus = v.findViewById(R.id.hapus);

        helper = new SQLiteHelper(context);

        tv_tanggal.setText("Tanggal : "+listCatatan.get(position).getTANGGAL());
        tv_judul.setText("Judul : "+listCatatan.get(position).getJUDUL());
        tv_kategori.setText("Kategori : "+listCatatan.get(position).getJUDUL());
        tv_catatan.setText("Catatan : "+listCatatan.get(position).getCATATAN());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("ID",listCatatan.get(position).getID());
                intent.putExtra("TANGGAL",listCatatan.get(position).getTANGGAL());
                intent.putExtra("JUDUL",listCatatan.get(position).getJUDUL());
                intent.putExtra("KATEGORI",listCatatan.get(position).getKATEGORI());
                intent.putExtra("CATATAN",listCatatan.get(position).getCATATAN());

                context.startActivity(intent);


            }
        });
        /*
        linear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("ID",listCatatan.get(position).getID());
                intent.putExtra("TANGGAL",listCatatan.get(position).getTANGGAL());
                intent.putExtra("JUDUL",listCatatan.get(position).getJUDUL());
                intent.putExtra("KATEGORI",listCatatan.get(position).getKATEGORI());
                intent.putExtra("CATATAN",listCatatan.get(position).getCATATAN());

                context.startActivity(intent);


                return true;
            }
        });

         */

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);


                alertDialog.setMessage("Apakah anda yakin untuk menghapus?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Integer isDelete = helper.deteleData(listCatatan.get(position).getID());
                                if(isDelete>0){
                                    Toast.makeText(context,"Data berhasil dihapus. Silahkan Refresh",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(context,"Data gagal dihapus",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });
        return v;
    }
}
