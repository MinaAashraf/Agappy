package com.mina.special.agappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class NoslelActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textView;
NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noslel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView lel1 = findViewById(R.id.noslel1);
        ImageView lel2 = findViewById(R.id.noslel2);
        ImageView lel3 = findViewById(R.id.noslel3);
        TextView lelname1 = findViewById(R.id.noslel1name);
        TextView lelname2 = findViewById(R.id.noslel2name);
        TextView lelname3 = findViewById(R.id.noslel3name);
textView = findViewById(R.id.textview);
        lel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الاولي"));
            }
        });

        lelname1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الاولي"));
            }
        });

        lel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثانية"));
            }
        });

        lelname2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثانية"));
            }
        });


        lel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثالثة"));
            }
        });

        lelname3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثالثة"));
            }
        });































        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
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

        if (id == R.id.nav_sawa3y) {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_baker)
        {


            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","baker");
            startActivity(intent);
        }
        else if (id == R.id.nav_talta)
        {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","talta");
            startActivity(intent);
        }  else if (id == R.id.nav_sata)
        {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","sata");
            startActivity(intent);
        }
        else if (id == R.id.nav_tas3a)
        {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","tas3a");
            startActivity(intent);
        }
        else if (id == R.id.nav_ghrob)
        {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","ghrob");
            startActivity(intent);
        }
        else if (id == R.id.nav_nom)
        {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","nom");
            startActivity(intent);
        }
        else if (id == R.id.nav_noslel) {

            Intent intent = new Intent (NoslelActivity.this,NoslelActivity.class);
            startActivity(intent);

        }
        else if (id==R.id.nav_noslel1)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","الاولي");
            startActivity(intent);
        }
        else if (id==R.id.nav_noslel2)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثانية");
            startActivity(intent);
        }
        else if (id==R.id.nav_noslel3)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","الثالثة");
            startActivity(intent);
        }
        else if (id == R.id.nav_sattar) {
            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","الستار");
            startActivity(intent);
        } else if (id == R.id.nav_salawat) {

            Intent intent = new Intent (NoslelActivity.this,SalawatActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.nav_toba)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","toba");
            startActivity(intent);
        }
        else if (id==R.id.nav_e3traf)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","e3traf");
            startActivity(intent);
        }
        else if (id==R.id.nav_tnawl)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","tnawl");
            startActivity(intent);
        }
        else if (id==R.id.nav_food)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","food");
            startActivity(intent);
        }
        else if (id==R.id.nav_work)
        {

            Intent intent = new Intent (NoslelActivity.this,Elsawa3yText.class).putExtra("name","work");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
