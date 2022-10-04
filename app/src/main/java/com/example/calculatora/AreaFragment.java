package com.example.calculatora;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Html;
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

public class AreaFragment extends Fragment {

    public AreaFragment() {
        // Required empty public constructor
    }

    String textvalue="1";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText edittext;
    Spinner spinner;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9;

    //for bottom sheet
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,button00,buttonc,buttondel,buttonplusminus,buttondone,buttondot;
    LinearLayout bottomsheet;
    BottomSheetBehavior sheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_area, container, false);
        edittext=view.findViewById(R.id.edittext);
        spinner=view.findViewById(R.id.spinner);
        text1=view.findViewById(R.id.text1);
        text2=view.findViewById(R.id.text2);
        text3=view.findViewById(R.id.text3);
        text4=view.findViewById(R.id.text4);
        text5=view.findViewById(R.id.text5);
        text6=view.findViewById(R.id.text6);
        text7=view.findViewById(R.id.text7);
        text8=view.findViewById(R.id.text8);
        text9=view.findViewById(R.id.text9);

        //for creating a copy context when textview is long pressed
        registerForContextMenu(text1);
        registerForContextMenu(text2);
        registerForContextMenu(text3);
        registerForContextMenu(text4);
        registerForContextMenu(text5);
        registerForContextMenu(text6);
        registerForContextMenu(text7);
        registerForContextMenu(text8);
        registerForContextMenu(text9);

        ArrayList<String> list=new ArrayList<>();
        list.add("square millimeter");
        list.add("square centimeter");
        list.add("square meter");
        list.add("are");
        list.add("hectare");
        list.add("square kilometer");
        list.add("square foot");
        list.add("square yard");;
        list.add("acre");

        TextView tview1,tview2,tview3,tview4,tview5,tview6;
        tview1=view.findViewById(R.id.tview1);
        tview2=view.findViewById(R.id.tview2);
        tview3=view.findViewById(R.id.tview3);
        tview4=view.findViewById(R.id.tview4);
        tview5=view.findViewById(R.id.tview5);
        tview6=view.findViewById(R.id.tview6);
        tview1.setText(Html.fromHtml("mm<sup>2</sup>"));
        tview2.setText(Html.fromHtml("cm<sup>2</sup>"));
        tview3.setText(Html.fromHtml("m<sup>2</sup>"));
        tview4.setText(Html.fromHtml("km<sup>2</sup>"));
        tview5.setText(Html.fromHtml("ft<sup>2</sup>"));
        tview6.setText(Html.fromHtml("yd<sup>2</sup>"));

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
                        Double mm=100*textvalue1;
                        Converter(mm);
                    }
                    else if(position==2){
                        Double mm=1000000*textvalue1;
                        Converter(mm);
                    }
                    else if(position==3){
                        Double mm=100000000*textvalue1;
                        Converter(mm);
                    }
                    else if(position==4){
                        Double mm=10000000000.0*textvalue1;
                        Converter(mm);
                    }
                    else if(position==5){
                        Double mm=1000000000000.0*textvalue1;
                        Converter(mm);
                    }
                    else if(position==6){
                        Double mm=92903.04*textvalue1;
                        Converter(mm);
                    }
                    else if(position==7){
                        Double mm=836127.36*textvalue1;
                        Converter(mm);
                    }
                    else if(position==8){
                        Double mm=4046856422.4*textvalue1;
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
                        Double mm=100*textvalue1;
                        Converter(mm);
                    }
                    else if(position==2){
                        Double mm=1000000*textvalue1;
                        Converter(mm);
                    }
                    else if(position==3){
                        Double mm=100000000*textvalue1;
                        Converter(mm);
                    }
                    else if(position==4){
                        Double mm=10000000000.0*textvalue1;
                        Converter(mm);
                    }
                    else if(position==5){
                        Double mm=1000000000000.0*textvalue1;
                        Converter(mm);
                    }
                    else if(position==6){
                        Double mm=92903.04*textvalue1;
                        Converter(mm);
                    }
                    else if(position==7){
                        Double mm=836127.36*textvalue1;
                        Converter(mm);
                    }
                    else if(position==8){
                        Double mm=4046856422.4*textvalue1;
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

    public void Converter(Double mm2)
    {
        ArrayList<String> list=new ArrayList<>();
        Double x=mm2;
        //for mm
        text1.setText(getperfactvalue(mm2));
        //for cm
        Double cm2=0.01*x;
        text2.setText(getperfactvalue(cm2));
        //for dm
        Double m2=0.000001*x;
        text3.setText(getperfactvalue(m2));

        //for m
        Double a=0.00000001*x;
        text4.setText(getperfactvalue(a));
        //for m
        Double ha=0.0000000001*x;
        text5.setText(getperfactvalue(ha));
        //for m
        Double km=0.000000000001*x;
        text6.setText(getperfactvalue(km));
        //for m
        Double ft2=0.00001076391041671*x;
        text7.setText(getperfactvalue(ft2));
        //for m
        Double yd2=0.000001195990046301*x;
        text8.setText(getperfactvalue(yd2));
        //for m
        //for m
        Double acre=0.000000000247105381467*x;
        text9.setText(getperfactvalue(acre));




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