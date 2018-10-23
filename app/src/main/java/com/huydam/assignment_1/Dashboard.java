package com.huydam.assignment_1;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    private android.app.FragmentManager manager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Set Default Fragment
        GeneralScheduleFragment generalScheduleFragment = new GeneralScheduleFragment();
        manager.beginTransaction().replace(R.id.contentLayout,
                generalScheduleFragment,
                generalScheduleFragment.getTag()).commit();
        //Set Actions for Bottom bar
        BottomNavigationView NavigationView = (BottomNavigationView)findViewById(R.id.nav);
        NavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.personal_schedule:
                        PersonalScheduleFragment personalScheduleFragment = new PersonalScheduleFragment();
                        manager.beginTransaction().replace(R.id.contentLayout,
                                personalScheduleFragment,
                                personalScheduleFragment.getTag()).commit();
                        break;
                    case R.id.map:
                        MapFragment mapFragment = new MapFragment();
                        manager.beginTransaction().replace(R.id.contentLayout,
                                mapFragment,
                                mapFragment.getTag()).commit();
                        break;
                    default:
                        GeneralScheduleFragment generalScheduleFragment = new GeneralScheduleFragment();
                        manager.beginTransaction().replace(R.id.contentLayout,
                                generalScheduleFragment,
                                generalScheduleFragment.getTag()).commit();
                }
                return true;
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
