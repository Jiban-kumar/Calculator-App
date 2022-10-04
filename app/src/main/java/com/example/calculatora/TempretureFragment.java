package com.example.calculatora;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;

public class TempretureFragment extends Fragment {

    public TempretureFragment() {
        // Required empty public constructor
    }

    String textvalue="1";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText edittext;
    Spinner spinner;
    TextView text1,text2,text3,text4,text5;

    //for bottom sheet
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,button00,buttonc,buttondel,buttonplusminus,buttondone,buttondot;
    LinearLayout bottomsheet;
    BottomSheetBehavior sheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tempreture, container, false);
        edittext=view.findViewById(R.id.edittext);
        spinner=view.findViewById(R.id.spinner);
        text1=view.findViewById(R.id.text1);
        text2=view.findViewById(R.id.text2);
        text3=view.findViewById(R.id.text3);
        text4=view.findViewById(R.id.text4);
        text5=view.findViewById(R.id.text5);

        //for creating a copy context when textview is long pressed
        registerForContextMenu(text1);
        registerForContextMenu(text2);
        registerForContextMenu(text3);
        registerForContextMenu(text4);
        registerForContextMenu(text5);
        ArrayList<String> list=new ArrayList<>();
        list.add("K");
        list.add("C");
        list.add("F");
        list.add("R");
        list.add("Re");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Double textvalue1=Double.parseDouble(textvalue);
                    if(position==0){
                        Converter(textvalue1);
                    }
                    else if(position==1){
                        Double mm=274.15*textvalue1;
                        Converter(mm);
                    }
                    else if(position==2){
                        Double mm=255.927777777778*textvalue1;
                        Converter(mm);
                    }
                    else if(position==3){
                        Double mm=0.55555555555556*textvalue1;
                        Converter(mm);
                    }
                    else if(position==4){
                        Double mm=274.4*textvalue1;
                        Converter(mm);
                    }
                }
                catch (Exception ee){

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        edittext.setText("1");
        edittext.setSelection(edittext.getText().length());
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    String a=edittext.getText().toString();
                    if(a==""){
                        textvalue="1";
                    }
                    else {
                        //Toast.makeText(getContext(), a+"", Toast.LENGTH_SHORT).show();
                        textvalue=a;
                    }
                    int position=spinner.getSelectedItemPosition();
                    Double textvalue1=Double.parseDouble(textvalue);
                    if(position==0){
                        Converter(textvalue1);
                    }
                    else if(position==1){
                        Double mm=274.15*textvalue1;
                        Converter(mm);
                    }
                    else if(position==2){
                        Double mm=255.927777777778*textvalue1;
                        Converter(mm);
                    }
                    else if(position==3){
                        Double mm=0.55555555555556*textvalue1;
                        Converter(mm);
                    }
                    else if(position==4){
                        Double mm=274.4*textvalue1;
                        Converter(mm);
                    }
                }
                catch (Exception ee){

                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                edittext.setSelection(edittext.getText().length());

            }
        });
//for Bottom sheet
        bottomsheet=view.findViewById(R.id.bottomsheet);
        sheetBehavior=BottomSheetBehavior.from(bottomsheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                InputMethodManager imm =(InputMethodManager)getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        getnumpad(view);


        sb.append("1");
        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        TextView textView=v.findViewById(v.getId());

        menu.add(0,v.getId(),0,"Copy");
        ClipboardManager clipboardManager=(ClipboardManager) getContext().getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("text",textView.getText());
        if(clipboardManager!=null){
            clipboardManager.setPrimaryClip(clipData);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    public void getnumpad(View view){
        button0=view.findViewById(R.id.button0);
        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button2);
        button3=view.findViewById(R.id.button3);
        button4=view.findViewById(R.id.button4);
        button5=view.findViewById(R.id.button5);
        button6=view.findViewById(R.id.button6);
        button7=view.findViewById(R.id.button7);
        button8=view.findViewById(R.id.button8);
        button9=view.findViewById(R.id.button9);
        button00=view.findViewById(R.id.button00);
        buttonc=view.findViewById(R.id.buttonc);
        buttondel=view.findViewById(R.id.buttondel);
        buttondot=view.findViewById(R.id.buttondot);
        buttondone=view.findViewById(R.id.buttondone);
        buttonplusminus=view.findViewById(R.id.buttonplusminus);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("9");
            }
        });
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("00");
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate(".");
            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("del");
            }
        });
        buttondone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
        buttonplusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("+-");
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate("c");
            }
        });

    }


    StringBuilder sb=new StringBuilder();
    private void Calculate(String str) {

        try{
            if(str=="0"){
                sb.append("0");
            }
            else if(str=="1"){
                sb.append("1");
            }
            else if(str=="2"){
                sb.append("2");
            }
            else if(str=="3"){
                sb.append("3");
            }
            else if(str=="4"){
                sb.append("4");
            }
            else if(str=="5"){
                sb.append("5");
            }
            else if(str=="6"){
                sb.append("6");
            }
            else if(str=="7"){
                sb.append("7");
            }
            else if(str=="8"){
                sb.append("8");
            }
            else if(str=="9"){
                sb.append("9");
            }
            else if(str=="."){
                sb.append(".");
            }
            else if(str=="00"){
                sb.append("00");
            }
            else if(str=="+-"){
                if(sb.charAt(0)=='-'){
                    sb.deleteCharAt(0);
                }
                else {
                    sb.insert(0,'-');
                }
            }
            else if(str=="del"){
                sb.deleteCharAt(sb.length()-1);
            }
            else if(str=="c"){
                sb=new StringBuilder();
            }

            edittext.setText(sb.toString());
        }
        catch (Exception ee){
            edittext.setText("Error");
        }
    }

    public void Converter(Double mm)
    {
        ArrayList<String> list=new ArrayList<>();
        Double x=mm;
        //for mm
        text1.setText(getperfactvalue(mm));
        //for cm
        Double cm=(-272.15)*x;
        text2.setText(getperfactvalue(cm));
        //for dm
        Double dm=(-457.87)*x;
        text3.setText(getperfactvalue(dm));

        //for m
        Double m=1.8*x;
        text4.setText(getperfactvalue(m));
        //for m
        Double km=(-217.72)*x;
        text5.setText(getperfactvalue(km));




    }

    public String getperfactvalue(Double x){
        ArrayList<String> num=new ArrayList<>();
        String result=x+"";
        if(result!="")
            if(result.contains(".")){
                int c1=result.length();
                String a1=result.substring(result.indexOf('.'), c1);
                if(!(Double.parseDouble(a1)>0)){
                    num.add(0,result.substring(0,result.indexOf('.'))+"");
                }
                else {
                    num.add(result);
                }

            }
            else{
                num.add(result);
            }
        return num.get(0);
    }
}