package com.example.calculatora;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class UnitActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    Toolbar toolbar;
    NavigationView navview;
    ActionBarDrawerToggle toggle;

    TabLayout tablayout;
    ViewPager viewpager;

//    FrameLayout frameLayout;
//    Fragment fragment=null;
//    FragmentManager fragmentManager;
//    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        this.setTitle("Unit Converter");

        drawerlayout=findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.toolbar);
        navview=findViewById(R.id.navigationview);

        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        tablayout=findViewById(R.id.tablayout);
        viewpager=findViewById(R.id.viewpager);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        navview.setCheckedItem(R.id.unitmenu);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.calculatermenu){
                    Intent intent=new Intent(UnitActivity.this,MainActivity.class);
                    startActivity(intent);

                }
                else if(item.getItemId()==R.id.unitmenu){
                }
                else if(item.getItemId()==R.id.currencymenu){
                }

                return false;
            }
        });

        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),getApplicationContext(),tablayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
//                if(tab.getPosition()==R.id.tabdistance){
//                    fragment=new DistanceFragment();
//                }
//                else if(tab.getPosition()==R.id.tabarea){
//                    fragment=new AreaFragment();
//                }
//                else if(tab.getPosition()==R.id.tabvolume){
//                    fragment=new VolumeFragment();
//                }
//                else if(tab.getPosition()==R.id.tabmass){
//                    fragment=new MassFragment();
//
//                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId()==R.menu.settingmenu){
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settingmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}