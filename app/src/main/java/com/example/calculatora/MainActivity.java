package com.example.calculatora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    Toolbar toolbar;
    NavigationView navigationview;

    ActionBarDrawerToggle toggle;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnadd,btnminus,btnmul,
            btndivider,btnc,btndel,btndot,btnplusminus,btnpercentaile,btnequal,btnx2,btnxy,btnn,btnxqy;
    EditText edittext;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerlayout=(DrawerLayout) findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.toolbar);
        navigationview=findViewById(R.id.navigationview);

        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //btn initialization
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnadd=findViewById(R.id.btnadd);
        btnminus=findViewById(R.id.btnminus);
        btnmul=findViewById(R.id.btnmul);
        btndivider=findViewById(R.id.btndivider);
        btnc=findViewById(R.id.btnc);
        btnplusminus=findViewById(R.id.btnplusminus);
        btnpercentaile=findViewById(R.id.btnpercentaile);
        btndot=findViewById(R.id.btndot);
        btndel=findViewById(R.id.btndel);
        btnequal=findViewById(R.id.btnequal);
        btnx2=findViewById(R.id.btnx2);
        btnxy=findViewById(R.id.btnxy);
        btnn=findViewById(R.id.btnn);
        btnxqy=findViewById(R.id.btnxqy);

        edittext=findViewById(R.id.edittext);
        textview=findViewById(R.id.textview);

        btnx2.setText(Html.fromHtml("x<sup>2</sup>"));
        btnxy.setText(Html.fromHtml("x<sup>y</sup>"));
        btnxqy.setText(Html.fromHtml(" x &radic y"));

        buttonpress();

        navigationview.setCheckedItem(R.id.calculatermenu);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.calculatermenu){
                    //item.setChecked(true);
                }
                else if(item.getItemId()==R.id.unitmenu){
                    Intent intent=new Intent(MainActivity.this,UnitActivity.class);
                    startActivity(intent);

                }
                else if(item.getItemId()==R.id.currencymenu){
                }

                //change the navigation menu title color
//                SpannableString spannableString=new SpannableString(item.getTitle().toString());
//                spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,spannableString.length(),0);
//                item.setTitle(spannableString);

                return true;
            }
        });

    }

    public void buttonpress() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("9");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("+");
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("-");
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("*");
            }
        });
        btndivider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("/");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation(".");
            }
        });
        btnplusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("+-");
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("=");
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.deleteCharAt(sb.length()-1);
                edittext.setText(sb.toString());
            }
        });
        btnpercentaile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation("%");
            }
        });
        btnplusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder s= new StringBuilder(sb.toString());
                if(!s.toString().equals("")){
                    if(s.charAt(0)!='-'){
                        s.insert(0, "-");
                    }
                    else {
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<s.length();i++){
                            list.add(s.charAt(i)+"");
                        }
                        list.remove(0);
                        s = new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            s.append(list.get(i));
                        }
                    }
                }
                edittext.setText("");
                sb=new StringBuilder();
                sb.append(s);
                edittext.setText(s.toString());
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb=new StringBuilder();
                edittext.setText("");
                textview.setText("");
            }
        });
        btnx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                if(!sb.toString().contains("*")&&!sb.toString().contains("/")&&!sb.toString().contains("%")){
                    result=(Double.parseDouble(sb.toString())*Double.parseDouble(sb.toString())) +"";
                }
                if(result.contains(".")){
                    int c=result.length();
                    String a=result.substring(result.indexOf('.'), c);
                    if(!(Double.parseDouble(a)>0)){
                        result=result.substring(0,result.indexOf('.'));
                    }

                }
                edittext.setText(result);
                textview.setText(sb.toString()+"^2");
                sb=new StringBuilder();
                sb.append(result);
            }
        });
        btnxy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   calculation("xy");
                }
            });
        btnn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String result="";
                    if(!sb.toString().contains("*")&&!sb.toString().contains("/")&&!sb.toString().contains("%")){
                        result=sb.toString();
                        for(double i=Double.parseDouble(result)-1;i<Double.parseDouble(result);i--){
                            if(i > 0){
                                result=Double.parseDouble(result)*(i) +"";
                            }
                        }
                    }
                    if(result.contains(".")){
                        int c=result.length();
                        String a=result.substring(result.indexOf('.'), c);
                        if(!(Double.parseDouble(a)>0)){
                            result=result.substring(0,result.indexOf('.'));
                        }

                    }
                    edittext.setText(result);
                    textview.setText(sb.toString()+"!");
                    sb=new StringBuilder();
                    sb.append(result);
                }
            });
        btnxqy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "This feature will come in next update", Toast.LENGTH_SHORT).show();
                }
            });



        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for not to show keyboard
                InputMethodManager imm =(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                //imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edittext.setSelection(edittext.getText().length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    StringBuilder sb=new StringBuilder();
    String x="";
    int f1=0;
    public void calculation(String str) {
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
            else if(str=="+"){
                //if op in last
                String a=sb.toString();
                if(a!=""){
                    if(a.charAt(a.length()-1)=='+'||a.charAt(a.length()-1)=='-'||a.charAt(a.length()-1)=='*'||a.charAt(a.length()-1)=='/'||a.charAt(a.length()-1)=='%'){
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<a.length();i++){
                            list.add(a.charAt(i)+"");
                        }
                        list.remove(list.size()-1);

                        sb=new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            sb.append(list.get(i));
                        }
                    }
                }
                edittext.setText(sb.toString());
                sb.append("+");
            }
            else if(str=="-"){
                //if op in last
                String a=sb.toString();
                if(a!=""){
                    if(a.charAt(a.length()-1)=='+'||a.charAt(a.length()-1)=='-'||a.charAt(a.length()-1)=='*'||a.charAt(a.length()-1)=='/'||a.charAt(a.length()-1)=='%'){
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<a.length();i++){
                            list.add(a.charAt(i)+"");
                        }
                        list.remove(list.size()-1);

                        sb=new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            sb.append(list.get(i));
                        }
                    }
                }
                edittext.setText(sb.toString());
                sb.append("-");
            }
            else if(str=="*"){
                //if op in last
                String a=sb.toString();
                if(a!=""){
                    if(a.charAt(a.length()-1)=='+'||a.charAt(a.length()-1)=='-'||a.charAt(a.length()-1)=='*'||a.charAt(a.length()-1)=='/'||a.charAt(a.length()-1)=='%'){
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<a.length();i++){
                            list.add(a.charAt(i)+"");
                        }
                        list.remove(list.size()-1);

                        sb=new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            sb.append(list.get(i));
                        }
                    }
                }
                edittext.setText(sb.toString());
                sb.append("*");
            }
            else if(str=="/"){
                //if op in last
                String a=sb.toString();
                if(a!=""){
                    if(a.charAt(a.length()-1)=='+'||a.charAt(a.length()-1)=='-'||a.charAt(a.length()-1)=='*'||a.charAt(a.length()-1)=='/'||a.charAt(a.length()-1)=='%'){
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<a.length();i++){
                            list.add(a.charAt(i)+"");
                        }
                        list.remove(list.size()-1);

                        sb=new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            sb.append(list.get(i));
                        }
                    }
                }
                edittext.setText(sb.toString());
                sb.append("/");
            }
            else if(str=="%"){
                //if op in last
                String a=sb.toString();
                if(a!=""){
                    if(a.charAt(a.length()-1)=='+'||a.charAt(a.length()-1)=='-'||a.charAt(a.length()-1)=='*'||a.charAt(a.length()-1)=='/'||a.charAt(a.length()-1)=='%'){
                        ArrayList<String> list=new ArrayList<>();
                        for(int i=0;i<a.length();i++){
                            list.add(a.charAt(i)+"");
                        }
                        list.remove(list.size()-1);

                        sb=new StringBuilder();
                        for(int i=0;i<list.size();i++){
                            sb.append(list.get(i));
                        }
                    }
                }
                edittext.setText(sb.toString());
                sb.append("%");
            }
            else if(str=="xy"){
                x=sb.toString();
                sb=new StringBuilder();
                edittext.setText("");
                f1=1;
            }

            else if(str=="="){
                ArrayList<String> num=new ArrayList<>();
                ArrayList<String> op1=new ArrayList<>();
                ArrayList<Integer> index=new ArrayList<Integer>();


                if(sb.charAt(0)=='*'||sb.charAt(0)=='/'||sb.charAt(0)=='%'){
                    if(sb.length()>1){
                        for(int i=0;i<sb.length();i++){
                            num.add(sb.charAt(i)+"");
                        }
                        num.remove(0);
                        sb=new StringBuilder();
                        for(int i=0;i<num.size();i++){
                            sb.append(num.get(i));
                        }
                        num=new ArrayList<>();
                    }

                }
                if(sb.length()>0){



                    for(int i=0;i<=sb.length()-1;i++){

                        if(sb.charAt(i)=='+'||sb.charAt(i)=='-'||sb.charAt(i)=='*'||sb.charAt(i)=='/'||sb.charAt(i)=='%'){
                            if(i==0&&(sb.charAt(0)=='+'||sb.charAt(0)=='-')){

                            }
                            else {
                                op1.add(sb.charAt(i)+"");
                                index.add(i);
                            }

                        }
                    }

                    for(int i=0;i<index.size();i++){

                        if(i==0){
                            if(sb.indexOf("+")==0||sb.indexOf("-")==0){

                            }
                            num.add(sb.substring(0,index.get(i)));
                            if(index.size()==1){
                                num.add(sb.substring(index.get(0)+1,sb.length()));
                            }
                        }
                        else if(i==index.size()-1&&index.size()!=1){
                            num.add(sb.substring(index.get(i-1)+1,index.get(i)));
                            num.add(sb.substring(index.get(i)+1,sb.length()));
                        }
                        else {
                            num.add(sb.substring(index.get(i-1)+1,index.get(i)));
                        }
                        //num.add(sb);
                        //num.add(sb.substring(index.get(i),index.get(i+1)));
                        //else if(num1.substring())
                    }
                    if(op1.contains("/")){
                        for(int i=0;i<op1.size()+1;i++){
                            if(op1.contains("/")){
                                int o=op1.indexOf("/");
                                double w=Double.parseDouble(num.get(o))/Double.parseDouble(num.get(o+1));
                                op1.remove(o);
                                num.remove(o+1);
                                num.remove(o);
                                num.add(o,w+"");
                                i=0;
                            }
                        }
                    }
                    if(op1.contains("*")){
                        for(int i=0;i<op1.size()+1;i++){
                            if(op1.contains("*")){
                                int o=op1.indexOf("*");
                                double w=Double.parseDouble(num.get(o))*Double.parseDouble(num.get(o+1));
                                op1.remove(o);
                                num.remove(o+1);
                                num.remove(o);
                                num.add(o,w+"");
                                i=0;
                            }
                        }
                    }
                    if(op1.contains("%")){
                        for(int i=0;i<op1.size()+1;i++){
                            if(op1.contains("%")){
                                int o=op1.indexOf("%");
                                double w=Double.parseDouble(num.get(o))%Double.parseDouble(num.get(o+1));
                                op1.remove(o);
                                num.remove(o+1);
                                num.remove(o);
                                num.add(o,w+"");
                                i=0;
                            }
                        }
                    }

                    if(op1.contains("+")){
                        for(int i=0;i<op1.size()+1;i++){
                            if(op1.contains("+")){
                                int o=op1.indexOf("+");
                                double w=Double.parseDouble(num.get(o))+Double.parseDouble(num.get(o+1));
                                op1.remove(o);
                                num.remove(o+1);
                                num.remove(o);
                                num.add(o,w+"");
                                i=0;
                            }
                        }
                    }
                    if(op1.contains("-")){
                        for(int i=0;i<op1.size()+1;i++){
                            if(op1.contains("-")){
                                int o=op1.indexOf("-");
                                double w=Double.parseDouble(num.get(o))-Double.parseDouble(num.get(o+1));
                                op1.remove(o);
                                num.remove(o+1);
                                num.remove(o);
                                num.add(o,w+"");
                                i=0;
                            }
                        }

                    }
                    if(f1==1){
                        double a=Double.parseDouble(x);
                        String c=a+"";
                        for(int i=0;i<Double.parseDouble(sb.toString())-1;i++){
                            a=a*Double.parseDouble(c);
                        }
                        f1=0;
                        String f=sb.toString();
                        sb=new StringBuilder();
                        String result=a+"";
                        if(result.contains(".")){
                            int c1=result.length();
                            String a1=result.substring(result.indexOf('.'), c1);
                            if(!(Double.parseDouble(a1)>0)){
                                num.add(0,result.substring(0,result.indexOf('.'))+"");
                            }

                        }
                        if(c.contains(".")){
                            int c1=c.length();
                            String a1=c.substring(c.indexOf('.'), c1);
                            if(!(Double.parseDouble(a1)>0)){
                                c=c.substring(0,c.indexOf('.'))+"";
                            }

                        }
                        if(f.contains(".")){
                            int c1=f.length();
                            String a1=f.substring(f.indexOf('.'), c1);
                            if(!(Double.parseDouble(a1)>0)){
                                f=f.substring(0,f.indexOf('.'))+"";
                            }

                        }

                        sb.append(c+"^"+f);
                        edittext.setText(num.get(0)+"");
                        textview.setText(sb.toString()+"");
                        sb=new StringBuilder();
                        sb.append(num.get(0));
                        num.remove(0);

                        ArrayList<String> lil=new ArrayList<>();
                        try{
                            FileInputStream fileInputStream=openFileInput("mytxt1");
                            InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream);
                            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                            while (bufferedReader.readLine()!=null){
                                lil.add(bufferedReader.readLine());
                            }

                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                        }catch (Exception ee){

                        }
                        try{
                            FileOutputStream fileOutputStream=openFileOutput("mytxt1",MODE_PRIVATE);
                            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                            if(lil.size()>0){
                                for(int i=0;i<lil.size();i++){
                                    outputStreamWriter.append(lil.get(i)+"\n");
                                }

                            }
                            outputStreamWriter.append(textview.getText().toString()+"=\n");
                            outputStreamWriter.append(edittext.getText().toString()+"\n");
                            outputStreamWriter.close();
                        }
                        catch(Exception ee) {

                        }

                    }
                    if(num.size()>0) {
                        String result=num.get(0);
                        if(result.contains(".")){
                            int c=result.length();
                            String a=result.substring(result.indexOf('.'), c);
                            if(!(Double.parseDouble(a)>0)){
                                num.add(0,result.substring(0,result.indexOf('.'))+"");
                            }

                        }
                        edittext.setText(num.get(0)+"");
                        textview.setText(sb.toString()+"");
                        sb=new StringBuilder();
                        sb.append(num.get(0));
                        num.remove(0);
                        ArrayList<String> lil=new ArrayList<>();
                        try{
                            FileInputStream fileInputStream1=openFileInput("mytxt1");
                            InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream1);
                            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                            while (bufferedReader.readLine()!=null){
                                lil.add(bufferedReader.readLine());
                            }

                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream1.close();
                        }catch (Exception ee){

                        }
                        try{
                            FileOutputStream fileOutputStream=openFileOutput("mytxt1",MODE_PRIVATE);
                            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                            if(lil.size()>0){
                                for(int i=0;i<lil.size();i++){
                                    outputStreamWriter.append(lil.get(i)+"\n");
                                }

                            }
                            outputStreamWriter.append(textview.getText().toString()+"=\n");
                            outputStreamWriter.append(edittext.getText().toString()+"\n");
                            outputStreamWriter.close();
                        }
                        catch(Exception ee) {

                        }
                    }

                    //Toast.makeText(this, num.get(0)+"   "+num.size(), Toast.LENGTH_SHORT).show();
                }



            }
            edittext.setText(sb.toString());
        }
        catch (Exception ee){
            edittext.setText("Error");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.secondmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId()==R.id.history){
            Intent intent=new Intent(MainActivity.this,HistoryPage.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}