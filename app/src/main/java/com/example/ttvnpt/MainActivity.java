package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adapter.XMLDOMParser;
import adapter.customadapter;
import model.website;

public class MainActivity extends AppCompatActivity {
Button b1,dm;
TextView tv,tv1;
ListView lv;
ArrayList<website> arrayList;
customadapter customadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        arrayList=new ArrayList<website>();

//        b1 = findViewById(R.id.bt);
//        tv = findViewById(R.id.tv);
//        tv1 = findViewById(R.id.tvtinh);
//        dm = findViewById(R.id.danhmuc);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hahaha", Toast.LENGTH_SHORT).show();
////                Intent intent=new Intent(MainActivity.this,timkiem.class);
////                startActivity(intent);
//            }
//        });
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, timkiem.class);
//                startActivity(intent);
//            }
//        });
//
//        dm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, danhmuc.class);
//                startActivity(intent);
//            }
//        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readData().execute("https://vnexpress.net/rss/kinh-doanh.rss");
            }
        });
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("link",arrayList.get(position).link);
            startActivity(intent);
        }
    });
    }
        class readData extends AsyncTask<String, Integer, String> {

            @Override
            protected String doInBackground(String... strings) {
                return docNoiDung_Tu_URL(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                XMLDOMParser parser=new XMLDOMParser();
                Document document=parser.getDocument(s);
                NodeList nodeList=document.getElementsByTagName("item");
                NodeList nodeListDescription=document.getElementsByTagName("description");
                String title="",link="",hinhanh="";
                for(int i=0;i<nodeList.getLength();i++){
                    String cData=nodeListDescription.item(i+1).getTextContent();
                    Pattern p=Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                    Matcher matcher=p.matcher(cData);
                    if(matcher.find()){
                        hinhanh=matcher.group(1);

                    }
                    Element element=(Element) nodeList.item(i);
                    title+=parser.getValue(element,"title");
                    link=parser.getValue(element,"link");
                    arrayList.add(new website(title,link,hinhanh));
//                    Log.d("link",link);
//                    Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();

                }
                customadapter=new customadapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
                lv.setAdapter(customadapter);

        //        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        }

        ///////////////////////////////////////////////////
        private String docNoiDung_Tu_URL(String theUrl){
            StringBuilder content = new StringBuilder();
            try    {
                // create a url object
                URL url = new URL(theUrl);

                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();

                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String line;

                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)    {
                e.printStackTrace();
            }
            return content.toString();

}}