package com.example.ttvnpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class timkiem extends AppCompatActivity {
    Toolbar toolbar;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);
        toolbar=findViewById(R.id.toolbarsearch);
        tv1=findViewById(R.id.tv1);

        ActionToolbar();
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(timkiem.this,hienthidanhsachtimkiem.class);
                intent.putExtra("search",tv1.getText().toString());
                startActivity(intent);
            }
        });

    }
//    <?xml version="1.0" encoding="utf-8"?>
//<selector xmlns:android="http://schemas.android.com/apk/res/android">
//    <item>
//        <shape android:shape="rectangle">
//            <solid android:color="#ffffff"/>
//            <corners android:radius="6dp" />
//            <stroke
//    android:width="1dp"
//    android:color="#27000000"
//            />
//        </shape>
//    </item>
//</selector>
      //  @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search,menu);
//        MenuItem item=menu.findItem(R.id.idsearch);
//            SearchView searchView=(SearchView)item.getActionView();
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    return false;
//                }
//            });

            ///
//        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                Toast.makeText(timkiem.this,"ha1",Toast.LENGTH_SHORT).show();
//                return true;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                Toast.makeText(timkiem.this,"ha2",Toast.LENGTH_SHORT).show();
//
//                return true;
//            }
//        };
//        menu.findItem(R.id.idsearch).setOnActionExpandListener(onActionExpandListener);
//            SearchView searchView=(SearchView)menu.findItem(R.id.idsearch).getActionView();
//            searchView.setQueryHint("nhap tu tim kiem...");
//        return true;
//    }

  //  @Override
 //   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()) {
//            case R.id.menugiohang:
//                Intent intent=new Intent(getApplicationContext(),GioHang.class);
//                startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}