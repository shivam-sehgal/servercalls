package com.skeleton.activity;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.skeleton.R;
import com.skeleton.adapter.ViewPagerAdapter;
import com.skeleton.fragment.SignInFragment;
import com.skeleton.fragment.SignupFragment;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String android_id= Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
       viewPager=(ViewPager)findViewById(R.id.my_pager);
        tabLayout=(TabLayout) findViewById(R.id.my_tab);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addData(new SignupFragment(),"Sign Up");
        viewPagerAdapter.addData(new SignInFragment(),"Sign In");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
