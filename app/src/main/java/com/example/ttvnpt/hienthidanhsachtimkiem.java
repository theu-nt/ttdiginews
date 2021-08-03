 package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

 public class hienthidanhsachtimkiem extends AppCompatActivity {
Spinner sp;
SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthidanhsachtimkiem);
        sp=findViewById(R.id.spdstk);
        sv=findViewById(R.id.svdstk);
        Intent intent=getIntent();

        String s= intent.getStringExtra("search");

        sv.setQueryHint(s);
        String[]data={"Năm nay","Năm ngoái"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sp.setAdapter(arrayAdapter);


    }
}