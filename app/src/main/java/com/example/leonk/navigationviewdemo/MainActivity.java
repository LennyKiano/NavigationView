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

    private static final  String SELECTED_ITEM_ID ="selected_item_id" ;
    private Toolbar toolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private  int mSelectedId;


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

        //checking if the app is coming from a rotation or is being created for the first time
        mSelectedId=savedInstanceState==null? R.id.navigation_item_2:savedInstanceState.getInt(SELECTED_ITEM_ID);

        navigate(mSelectedId);

    }

    private void navigate(int mSelectedId) {
        Intent intent=null;


        if(mSelectedId==R.id.navigation_item_2){

            mDrawerLayout.closeDrawer(GravityCompat.START);   //Closing the navigation drawer
            intent= new Intent(this,Main2Activity.class);
            startActivity(intent);

        } if(mSelectedId==R.id.navigation_item_3){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent= new Intent(this,Main3Activity.class);
            startActivity(intent);

        } if(mSelectedId==R.id.navigation_item_5){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent= new Intent(this,Main5Activity.class);
            startActivity(intent);

        }


    }

    //needs to be called for the drawer toggle
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);
        mSelectedId=item.getItemId();

        navigate(mSelectedId);

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {   //for remember what item was selected
        super.onSaveInstanceState(outState);

        outState.putInt(SELECTED_ITEM_ID,mSelectedId);
    }
}
