package com.example.adapter_try;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ArrayList listItems;
    Myadapter myadpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        List<String> list1 = new ArrayList<>();
        for(int i = 1;i<100;i++){
            list1.add("item"+i);
        }
        ListView listView = (ListView)findViewById(R.id.listview);

        ListAdapter a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list1);
        listView.setAdapter(a);
        //setListAdapter(a);
        */
        listItems = new ArrayList<HashMap<String,String>>();
        for(int i = 0;i<10;i++){
            HashMap<String,String > map = new HashMap<>();
            map.put("item_title","Rate: "+i);
            map.put("item_detail","detail: "+i);
            listItems.add(map);
        }
        //SimpleAdapter listitemAdapter = new SimpleAdapter(this,listItems,R.layout.list_item,new String[]{"item_title","item_detail"},new int[]{R.id.item_title,R.id.item_detail});
        myadpater = new Myadapter(this, R.layout.list_item,listItems);
        GridView listView = (GridView)findViewById(R.id.gridview);
        listView.setAdapter(myadpater);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        GridView listView = (GridView)findViewById(R.id.gridview);
        Object itemp = listView.getItemAtPosition(i);
        HashMap<String, String> map = (HashMap<String,String>)itemp;
        String title = map.get("item_title");
        String detail = map.get("item_detail");
        EditText editText = (EditText)findViewById(R.id.editText2);
        editText.setText(title);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        GridView listView = (GridView)findViewById(R.id.gridview);
        final Object itemp = listView.getItemAtPosition(i);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("notice")
                .setMessage("确认删除?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listItems.remove(itemp);
                        myadpater.notifyDataSetChanged();
                    }
                }).setNegativeButton("no",null);
        builder.create().show();



        return true;
    }
}


