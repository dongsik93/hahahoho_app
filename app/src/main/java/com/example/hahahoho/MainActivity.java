package com.example.hahahoho;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hahahoho.ui.FragmentMenu1;
import com.example.hahahoho.ui.FragmentMenu2;
import com.example.hahahoho.ui.FragmentMenu3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentMenu1 menu1Fragment = new FragmentMenu1();
    private FragmentMenu2 menu2Fragment = new FragmentMenu2();
    private FragmentMenu3 menu3Fragment = new FragmentMenu3();

    // 이 한줄의 의미
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
        // 두줄 알아보기
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

    // 툴바 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }
}
