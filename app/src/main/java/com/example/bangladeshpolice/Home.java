package com.example.bangladeshpolice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Home extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    private FrameLayout frameLayout;
    private HomeFragment homeFragment;
    private Inbox_fragment inbox_fragment;
    private LocationFragment locationFragment;
    private CallFragment callFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);drawerLayout=findViewById(R.id.drawerlayoutId);
        toolbar=findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setTitleTextColor(Color.WHITE);

        frameLayout=findViewById(R.id.framId);
        homeFragment=new HomeFragment();
        inbox_fragment=new Inbox_fragment();
        locationFragment =new LocationFragment();
        callFragment=new CallFragment();

        setFragment(homeFragment);


        navigationView=findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,
                R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        actionBarDrawerToggle.syncState();

        bottomNavigationView=findViewById(R.id.bottom_menu_Id);
        bottomNavigationView.setSelectedItemId(R.id.homeId);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.EmailId:
                        setFragment(inbox_fragment);
                        return true;
                    case R.id.homeId:
                        setFragment(homeFragment);
                        return true;
                    case R.id.locationId:
                        setFragment(locationFragment);
                        return true;
                    case  R.id.callId:
                        setFragment(callFragment);
                        return true;
                    default:
                        return false;
                }

            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id =item.getItemId();

                if(id==R.id.settingId) {
//                    Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                    Snackbar snackbar=Snackbar.make(drawerLayout,"Setting Is Clicked",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
                else if(id==R.id.shareId) {
                    Snackbar snackbar=Snackbar.make(drawerLayout,"Share Is Clicked",Snackbar.LENGTH_SHORT);
                    snackbar.show();                }
                else if(id==R.id.logoutId) {
                    Snackbar snackbar=Snackbar.make(drawerLayout,"Logout Is Clicked",Snackbar.LENGTH_SHORT);
                    snackbar.show();                }

                return true;
            }
        });

    }


    private  void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.popo_enter,R.anim.pop_exit);
        fragmentTransaction.replace(R.id.framId,fragment);
        fragmentTransaction.commit();
    }

}