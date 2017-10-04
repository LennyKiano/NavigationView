package com.example.leonk.navigationviewdemo;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager pager;
    private  MyPagerAdapter myPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        toolbar = (Toolbar) findViewById(R.id.app_bar3);
        setSupportActionBar(toolbar);

        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager()); //initialization of the pagerAdapter
        pager=(ViewPager) findViewById(R.id.pager);
        pager.setAdapter(myPagerAdapter);
        tabLayout=(TabLayout) findViewById(R.id.tab_layout);

        //setting the tab text
        tabLayout.addTab(tabLayout.newTab().setText("TAB 0"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB 1"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB 2"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB 3"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB 4"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB 5"));

        //linking the tabLayout and the view pager ie.when the tab changes we want to update the viewPager

        tabLayout.setupWithViewPager(pager);

        //linking the viewPager to the tab layout ie.when the page changes so does the tabs

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


    public static class MyFragment extends Fragment {
        public static final java.lang.String ARG_PAGE ="arg_page" ; //make sure its public

        public MyFragment(){  //Default fragment that is required to run efficiently


        }

        public static MyFragment newInstance(int pageNumber) {  //returns object of MyFragment after accepting a page number

            Bundle arguments = new Bundle();

            MyFragment fragment = new MyFragment();
            arguments.putInt(ARG_PAGE,pageNumber);
            fragment.setArguments(arguments);

            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //getting the page number

            Bundle arguments=getArguments();
            int pageNumber=arguments.getInt(ARG_PAGE);

            //displaying a textView in java code instead of xml

            TextView textView=new TextView(getActivity());
            textView.setText("I am a text inside this fragment"+pageNumber);
            textView.setGravity(Gravity.CENTER);

            return textView;
        }
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        private String tabTitles[] = new String[]{"TAB 0", "TAB 1", "TAB 2","TAB 3","TAB 4","Tab 5"};


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {  //need to return the fragment at a given position

            ThirdActivity.MyFragment myFragment= ThirdActivity.MyFragment.newInstance(position); //passing the position or page number

            return myFragment;
        }

        @Override
        public int getCount() {
            return 6;    //number of fragments
        }

        @Override
        public CharSequence getPageTitle(int position) {  //returning respective tab titles
            return tabTitles[position];
        }
    }

}
