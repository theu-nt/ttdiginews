package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.zip.Inflater;

public class caidat extends AppCompatActivity {
TextView tvtindp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);
        tvtindp=findViewById(R.id.tvtindiaphuong);
        tvtindp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflater inflater=
            }
        });
    }
}