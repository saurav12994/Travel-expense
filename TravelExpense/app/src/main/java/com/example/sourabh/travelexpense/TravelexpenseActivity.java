package com.example.sourabh.travelexpense;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TravelexpenseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelexpense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            AddTrip fragment=new AddTrip();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            AddaFragment fragment=new AddaFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();

        } else if (id == R.id.nav_slideshow) {
            ViewFragment fragment=new ViewFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();

        } else if (id == R.id.nav_manage) {
            TripwiseFragment fragment=new TripwiseFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();
        } else if (id == R.id.nav_share) {
            CategoryFragment fragment=new CategoryFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();

        } else if (id == R.id.nav_send) {
            DayFragment fragment=new DayFragment();
            FragmentManager ft=getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.relative1,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
