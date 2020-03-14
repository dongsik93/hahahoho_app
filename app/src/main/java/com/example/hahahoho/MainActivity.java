package com.example.hahahoho;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private fragment_menu1 menu1Fragment = new fragment_menu1();
    private fragment_menu2 menu2Fragment = new fragment_menu2();
    private fragment_menu3 menu3Fragment = new fragment_menu3();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        // Bottom nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // 첫화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, menu1Fragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.menu1: {
                        transaction.replace(R.id.fragment, menu1Fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu2: {
                        transaction.replace(R.id.fragment, menu2Fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.menu3: {
                        transaction.replace(R.id.fragment, menu3Fragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }
    // XML에 정의한 appbar menu가 나타나도록
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu) ;
        return true ;
    }
}
