package com.kirextr.foursoulshelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer_layout;
    BottomNavigationView bottom_navigation_view;
    FragmentManager fragment_manager;
    Toolbar toolbar;
    FloatingActionButton fab;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer_layout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigation_view = findViewById(R.id.navigation_drawer);
        navigation_view.setNavigationItemSelectedListener(this);

        bottom_navigation_view = findViewById(R.id.bottom_navigation);
        bottom_navigation_view.setBackground(null);
        bottom_navigation_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.bottom_home){
                    openFragment(new HomeFragment());
                    return true;
                } else if (itemId == R.id.bottom_expansion) {
                    openFragment(new ExpansionFragment());
                    return true;
                } else if (itemId == R.id.bottom_rules) {
                    openFragment(new RulesFragment());
                    return true;
                } else if (itemId == R.id.bottom_search) {
                    openFragment(new SearchFragment());
                    return true;
                }
                return false;
            }
        });

        fragment_manager = getSupportFragmentManager();
        openFragment(new HomeFragment());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(item_id == R.id.nav_dice_roller){
            openFragment(new DiceFragment());
        } else if (item_id == R.id.nav_themes) {
            openFragment(new ThemesFragment());
        } else if (item_id == R.id.deck_builder) {
            openFragment(new DeckBuilderFragment());
        } else if (item_id == R.id.nav_donations) {
            openFragment(new DonationFragment());
        } else if (item_id == R.id.nav_statistics) {
            openFragment(new StatisticsFragment());
        } else if (item_id == R.id.nav_settings) {
            openFragment(new SettingsFragment());
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    
    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = fragment_manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}