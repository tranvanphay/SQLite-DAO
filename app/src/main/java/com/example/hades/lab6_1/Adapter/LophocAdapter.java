package com.example.hades.lab6_1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hades.lab6_1.R;
import com.example.hades.lab6_1.model.Lophoc;

import java.util.ArrayList;

public class LophocAdapter extends BaseAdapter {
    ArrayList<Lophoc> ds=new ArrayList<Lophoc>();
    Context c;
    public LophocAdapter(Context c,ArrayList<Lophoc> ds){
        this.c=c;
        this.ds=ds;
    }
    @Override
    public int getCount() {

        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // gan layout
        LayoutInflater inf=((Activity)c).getLayoutInflater();
        view=inf.inflate(R.layout.one_item_lophoc,null);
        TextView tv_id=view.findViewById(R.id.tv_id);
        TextView tv_tenlop=view.findViewById(R.id.tv_tenlop);
        Lophoc lh= ds.get(i);
        tv_id.setText(lh._id+" ");
        tv_tenlop.setText(lh.tenlop);
        return view;
    }
}
