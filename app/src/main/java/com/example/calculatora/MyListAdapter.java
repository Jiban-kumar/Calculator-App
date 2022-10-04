package com.example.calculatora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<MyListAdapter.Data> {
    ArrayList<Data> list;
    Context context;

    public MyListAdapter(@NonNull Context context, int resource, ArrayList<Data> str2) {
        super(context, resource,str2);
        this.list = str2;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.mylist,null,false);
        TextView text1=view.findViewById(R.id.text1);
        TextView text2=view.findViewById(R.id.text2);
        text1.setText(list.get(position).getS1());
        text2.setText(list.get(position).getS2());
        return view;
    }
    public static class Data{
        String s1;
        String s2;

        public Data(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }
    }
}
