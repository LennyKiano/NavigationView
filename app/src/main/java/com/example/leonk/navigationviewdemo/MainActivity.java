package com.example.leonk.navigationviewdemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        mDrawer=(NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);

        //for hamburger icon
        drawerToggle= new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);


        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }

    //needs to be called for the drawer toggle
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent=null;

        if(item.getItemId()==R.id.navigation_item_2){

            mDrawerLayout.closeDrawer(GravityCompat.START);   //Closing the navigation drawer
            intent= new Intent(this,Main2Activity.class);
            startActivity(intent);
            return true;

        } if(item.getItemId()==R.id.navigation_item_3){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent= new Intent(this,Main3Activity.class);
            startActivity(intent);
            return true;

        } if(item.getItemId()==R.id.navigation_item_5){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent= new Intent(this,Main5Activity.class);
            startActivity(intent);
            return true;

        }

        return false;
    }
}
