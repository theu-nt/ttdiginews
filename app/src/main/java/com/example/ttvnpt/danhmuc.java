package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import adapter.danhmuc_adapter;

public class  danhmuc extends AppCompatActivity {
    RecyclerView recy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        recy=findViewById(R.id.rcvdanhmuc);
        ArrayList<String> arr=new ArrayList<>();
        arr.add("Xu hướng");
        arr.add("Xã hội");
        arr.add("Sức Khỏe");
        arr.add("Văn hóa");
        arr.add("Giải trí");
        arr.add("Giáo dục");
        arr.add("Thể thao");
        arr.add("Tâm sự");
        arr.add("Truyện đọc");
        arr.add("Bảng tin");

        danhmuc_adapter adapter=new danhmuc_adapter(getApplicationContext(),arr);
        recy.setHasFixedSize(true);
        recy.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recy.setAdapter(adapter);

    }
}