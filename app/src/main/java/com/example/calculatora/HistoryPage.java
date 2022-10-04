package com.example.calculatora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HistoryPage extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
        listView=findViewById(R.id.listview);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<MyListAdapter.Data> str1=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();

        try {
            FileInputStream fileInputStream=openFileInput("mytxt1");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
            String s="";
            while ((s=bufferedReader.readLine())!=null){
                list.add(s);
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i=i+2){
            str1.add(new MyListAdapter.Data(list.get(i),list.get(i+1)));
        }
        TextView jtext=findViewById(R.id.jtext);
        if(str1.size()>0){
            jtext.setText("Noting happened"+str1.size()+list.size());
        }
        MyListAdapter adapter=new MyListAdapter(this,R.layout.mylist,str1);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}