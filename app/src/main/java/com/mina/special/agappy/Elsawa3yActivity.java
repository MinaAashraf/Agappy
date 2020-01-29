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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Elsawa3yActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
TextView textView ; Menu gobalMenu;
NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elsawa3y);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView baker = findViewById(R.id.baker);
        ImageView talta = findViewById(R.id.talta);
        ImageView sata = findViewById(R.id.sata);
        ImageView tas3a = findViewById(R.id.tas3a);
        ImageView ghrob = findViewById(R.id.ghrob);
        ImageView nom = findViewById(R.id.nom);
        TextView bakername = findViewById(R.id.bakername);
        TextView taltaname = findViewById(R.id.taltaname);
        TextView sataname = findViewById(R.id.sataname);
        TextView tas3aname = findViewById(R.id.tas3aname);
        TextView ghrobname = findViewById(R.id.ghrobname);
        TextView nomname = findViewById(R.id.nomname);
        textView = findViewById(R.id.textview);
baker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","baker"));

    }
});
        bakername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","baker"));
            }
        });
        talta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","talta"));
            }
        });
        taltaname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","talta"));
            }
        });
        sata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","sata"));
            }
        });
        sataname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","sata"));
            }
        });
        tas3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","tas3a"));
            }
        });
        tas3aname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","tas3a"));
            }
        });
        ghrob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","ghrob"));
            }
        });
        ghrobname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","ghrob"));
            }
        });
        nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","nom"));
            }
        });
        nomname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","nom"));
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

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.nav_baker)
        {


            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","baker");
            startActivity(intent);
        }
        else if (id == R.id.nav_talta)
        {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","talta");
            startActivity(intent);
        }  else if (id == R.id.nav_sata)
        {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","sata");
            startActivity(intent);
        }
        else if (id == R.id.nav_tas3a)
        {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","tas3a");
            startActivity(intent);
        }
        else if (id == R.id.nav_ghrob)
        {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","ghrob");
            startActivity(intent);
        }
        else if (id == R.id.nav_nom)
        {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","nom");
            startActivity(intent);
        }
        else if (id == R.id.nav_noslel) {
            Intent intent = new Intent (Elsawa3yActivity.this,NoslelActivity.class);
            startActivity(intent);

        }
        else if (id==R.id.nav_noslel1)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","الاولي");
            startActivity(intent);
        }
        else if (id==R.id.nav_noslel2)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","الثانية");
            startActivity(intent);
        }
        else if (id==R.id.nav_noslel3)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","الثالثة");
            startActivity(intent);
        }
        else if (id == R.id.nav_sattar) {
            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","الستار");
            startActivity(intent);
        } else if (id == R.id.nav_salawat) {
            Intent intent = new Intent (Elsawa3yActivity.this,SalawatActivity.class);
            startActivity(intent);

        }
        else if (id==R.id.nav_toba)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","toba");
            startActivity(intent);
        }
        else if (id==R.id.nav_e3traf)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","e3traf");
            startActivity(intent);
        }
        else if (id==R.id.nav_tnawl)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","tnawl");
            startActivity(intent);
        }
        else if (id==R.id.nav_food)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","food");
            startActivity(intent);
        }
        else if (id==R.id.nav_work)
        {

            Intent intent = new Intent (Elsawa3yActivity.this,Elsawa3yText.class).putExtra("name","work");
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
