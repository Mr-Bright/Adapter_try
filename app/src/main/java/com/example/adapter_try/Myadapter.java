package com.example.adapter_try;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adapter_try.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Myadapter extends ArrayAdapter {

    public Myadapter(Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource, list);
    }

    public View getView(int position, View converView, ViewGroup parent){
        View itemView = converView;
        if(itemView==null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Map<String, String> map = (Map<String, String>) getItem(position);
        TextView title = (TextView)itemView.findViewById(R.id.item_title);
        TextView detail = (TextView)itemView.findViewById(R.id.item_detail);

        title.setText("Title: "+map.get("item_title"));
        detail.setText("detail: "+map.get("item_detail"));

        return itemView;

    }
}
