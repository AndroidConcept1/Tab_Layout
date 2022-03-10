package com.abulkalam.tab_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of FrameLayout and TabLayout
        simpleFrameLayout = findViewById(R.id.simpleFrameLayout);
        tabLayout         =findViewById(R.id.simpleTabLayout);

        //Create a new Tab name "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First"); //set the text for the first Tab
        firstTab.setIcon(R.drawable.ic_launcher_background); //Set the icon for first Tab
        tabLayout.addTab(firstTab);

        //Create a new Tab name "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        firstTab.setText("Second"); //set the text for the Second Tab
        firstTab.setIcon(R.drawable.ic_launcher_background); //Set the icon for Second Tab
        tabLayout.addTab(secondTab);

        //Create a new Tab name "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        firstTab.setText("Third"); //set the text for the Third Tab
        firstTab.setIcon(R.drawable.ic_launcher_background); //Set the icon for Third Tab
        tabLayout.addTab(thirdTab);


        //perform setOnTabSelectedListener event on Tab selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //get the current Tab selected position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        fragment = new SecondFragment();
                        break;
                    case 2:
                        fragment = new ThirdFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}