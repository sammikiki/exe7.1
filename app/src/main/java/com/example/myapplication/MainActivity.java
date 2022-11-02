package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义字符串数组存放用户昵称
        String[] nickName=new String[]{"姓名1","姓名2"};
        String[] nickPhone=new String[]{"电话1","电话2"};
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();//List<T>
        for (int i=0;i<nickPhone.length;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("phone",nickPhone[i]);
            map.put("name",nickName[i]);
            list.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.main,new String[]{"name","phone"},new int[]{R.id.name,R.id.phone});
        ListView listView= (ListView) findViewById(R.id.lv2);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map= (Map<String, Object>) parent.getItemAtPosition(position);
                String str=map.get("name").toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}