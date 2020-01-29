package com.mina.special.agappy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static android.support.v4.view.ViewPager.*;

public class Elsawa3yText extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Menu globalMenu;
    ViewPager viewPager;
    Tappedpager ob;
    Spinner spinner;
    InputStream input = null;
    String txt;
    byte[] bytes;
    int i = 0;
    NavigationView navigationView;
    DrawerLayout drawer;
    String name;
    ScrollView scrollView;
    TextView mytitle;
    ImageView myimage;
    TextView textView;
    int size;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elsawa3y_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = getIntent().getExtras().getString("name");
        myimage = findViewById(R.id.myimage);
        mytitle = findViewById(R.id.mytitle);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setRotationY(180);
        ob = new Tappedpager(Elsawa3yText.this, name);
        viewPager.setAdapter(ob);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.s1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        SharedPreferences sharedPreferences = getSharedPreferences("file", 0);
        size = sharedPreferences.getInt("size", 5);
        switch (name) {
            case "baker":
                adapter = ArrayAdapter.createFromResource(this, R.array.s1, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "talta":
                adapter = ArrayAdapter.createFromResource(this, R.array.s2, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "sata":
                adapter = ArrayAdapter.createFromResource(this, R.array.s3, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "tas3a":
                adapter = ArrayAdapter.createFromResource(this, R.array.s4, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "ghrob":
                adapter = ArrayAdapter.createFromResource(this, R.array.s5, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "nom":
                adapter = ArrayAdapter.createFromResource(this, R.array.s6, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "الاولي":
                adapter = ArrayAdapter.createFromResource(this, R.array.s7, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "الثانية":
                adapter = ArrayAdapter.createFromResource(this, R.array.s8, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "الثالثة":
                adapter = ArrayAdapter.createFromResource(this, R.array.s9, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "الستار":
                adapter = ArrayAdapter.createFromResource(this, R.array.s10, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "toba":
                adapter = ArrayAdapter.createFromResource(this, R.array.s11, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "e3traf":
                adapter = ArrayAdapter.createFromResource(this, R.array.s12, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "tnawl":
                adapter = ArrayAdapter.createFromResource(this, R.array.s13, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "food":
                adapter = ArrayAdapter.createFromResource(this, R.array.s14, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
            case "work":
                adapter = ArrayAdapter.createFromResource(this, R.array.s15, android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                break;
        }

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                spinner.setSelection(viewPager.getCurrentItem());
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                viewPager.setCurrentItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        globalMenu = navigationView.getMenu();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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


        if (id == R.id.nav_baker) {


            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "baker");
            startActivity(intent);
        } else if (id == R.id.nav_talta) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "talta");
            startActivity(intent);
        } else if (id == R.id.nav_sata) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "sata");
            startActivity(intent);
        } else if (id == R.id.nav_tas3a) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "tas3a");
            startActivity(intent);
        } else if (id == R.id.nav_ghrob) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "ghrob");
            startActivity(intent);
        } else if (id == R.id.nav_nom) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "nom");
            startActivity(intent);
        } else if (id == R.id.nav_noslel1) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "الاولي");
            startActivity(intent);
        } else if (id == R.id.nav_noslel2) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "الثانية");
            startActivity(intent);
        } else if (id == R.id.nav_noslel3) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "الثالثة");
            startActivity(intent);
        } else if (id == R.id.nav_sattar) {
            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "الستار");
            startActivity(intent);
        } else if (id == R.id.nav_toba) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "toba");
            startActivity(intent);
        } else if (id == R.id.nav_e3traf) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "e3traf");
            startActivity(intent);
        } else if (id == R.id.nav_tnawl) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "tnawl");
            startActivity(intent);
        } else if (id == R.id.nav_food) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "food");
            startActivity(intent);
        } else if (id == R.id.nav_work) {

            Intent intent = new Intent(Elsawa3yText.this, Elsawa3yText.class).putExtra("name", "work");
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public class Tappedpager extends PagerAdapter {
        LayoutInflater layoutInflater;
        private Context context;
        String name;

        public Tappedpager(Context context, String name) {
            this.context = context;
            this.name = name;
        }

        @Override
        public int getCount() {
            if (name.equals("baker")) {

                return (getResources().getStringArray(R.array.s1).length);
            } else if (name.equals("talta"))
                return getResources().getStringArray(R.array.s2).length;
            else if (name.equals("sata"))
                return getResources().getStringArray(R.array.s3).length;
            else if (name.equals("tas3a"))
                return getResources().getStringArray(R.array.s4).length;
            else if (name.equals("ghrob"))
                return getResources().getStringArray(R.array.s5).length;
            else if (name.equals("nom"))
                return getResources().getStringArray(R.array.s6).length;
            else if (name.equals("toba"))
                return 1;
            else if (name.equals("e3traf"))
                return 2;
            else if (name.equals("tnawl"))
                return 2;
            else if (name.equals("food"))
                return 2;
            else if (name.equals("work"))
                return 1;
            else if (name.equals("الستار"))
                return getResources().getStringArray(R.array.s10).length;
            else if (name.equals("الاولي"))
                return getResources().getStringArray(R.array.s7).length;
            else if (name.equals("الثانية"))
                return getResources().getStringArray(R.array.s8).length;
            else
                return getResources().getStringArray(R.array.s9).length;

        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return (view == (LinearLayout) o);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.item, container, false);
            scrollView = v.findViewById(R.id.scroll);
            textView = v.findViewById(R.id.textview);
            textView.setRotationY(180);
            textView.setTextSize(size + 15);
            if (name.equals("baker")) {
                textView.setTextColor(Color.parseColor("#5a24d1"));
                scrollView.setScrollY(0);
                try {
                    input = getAssets().open("text" + (position + 1));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    txt = new String(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView.setText(txt);
                mytitle.setText("بـــاكــــــر");


            } else if (name.equals("talta")) {
                try {
                    textView.setTextColor(Color.parseColor("#5a24d1"));
                    scrollView.setScrollY(0);
                    input = getAssets().open("text" + (position + 41));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.talta);
                mytitle.setText("الساعة الثالثة");
            } else if (name.equals("sata")) {
                textView.setTextColor(Color.parseColor("#5a24d1"));
                try {
                    scrollView.setScrollY(0);
                    input = getAssets().open("text" + (position + 67));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.sata);
                mytitle.setText("الساعة السادسة");
            } else if (name.equals("tas3a")) {
                textView.setTextColor(Color.parseColor("#5a24d1"));
                try {
                    input = getAssets().open("text" + (position + 93));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.tas3a);
                mytitle.setText("الساعة التاسعة");

            } else if (name.equals("ghrob")) {
                textView.setTextColor(Color.parseColor("#5a24d1"));
                try {
                    scrollView.setScrollY(0);
                    input = getAssets().open("text" + (position + 119));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.ghrob);
                mytitle.setText("الغــــــــروب");
            } else if (name.equals("nom")) {
                textView.setTextColor(Color.parseColor("#5a24d1"));
                try {
                    scrollView.setScrollY(0);
                    if (position > 24) {
                        input = getAssets().open("text" + (position + 263));
                    } else {
                        input = getAssets().open("text" + (position + 142));
                    }

                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.nom);
                mytitle.setText("صلاة النوم");
            } else if (name.equals("الاولي")) {
                textView.setTextColor(Color.parseColor("#FF481A69"));
                try {
                    scrollView.setScrollY(0);
                    if (position == 18) {
                        input = getAssets().open("text" + (position + 274));
                    } else if (position > 18) {
                        input = getAssets().open("text" + (position + 166));
                    } else {
                        input = getAssets().open("text" + (position + 167));
                    }
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.maseh5);
                mytitle.setText("الخدمة الأولي");
            } else if (name.equals("الثانية")) {
                textView.setTextColor(Color.parseColor("#FF481A69"));
                try {
                    scrollView.setScrollY(0);
                    if (position == 18 || position == 19) {
                        input = getAssets().open("text" + (position + 275));
                    } else if (position > 19) {
                        input = getAssets().open("text" + (position + 189));
                    } else {
                        input = getAssets().open("text" + (position + 191));
                    }
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.anba);
                mytitle.setText("الخدمة الثانية");
            } else if (name.equals("الثالثة")) {
                textView.setTextColor(Color.parseColor("#FF481A69"));
                try {
                    scrollView.setScrollY(0);
                    if (position == 20 || position == 21) {
                        input = getAssets().open("text" + (position + 273));
                    } else if (position > 21 && position < 25) {
                        input = getAssets().open("text" + (position + 211));
                    } else if (position == 25) {
                        input = getAssets().open("text" + (position + 270));
                    } else if (position == 30) {
                        input = getAssets().open("text" + (position + 266));
                    } else if (position > 25 && position < 30) {
                        input = getAssets().open("text" + (position + 210));
                    } else if (position > 30) {
                        input = getAssets().open("text" + (position + 209));
                    } else {
                        input = getAssets().open("text" + (position + 213));
                    }
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.lel3);
                mytitle.setText("الخدمة الثالثة");
            } else if (name.equals("الستار")) {
                textView.setTextColor(Color.parseColor("#672970"));
                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 241));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.el3dra);
                mytitle.setText("صلاة الستار");
            } else if (name.equals("toba")) {
                textView.setTextColor(Color.parseColor("#870620"));
                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 297));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.toba);
                mytitle.setText("صلاة التوبة");
            } else if (name.equals("e3traf")) {
                textView.setTextColor(Color.parseColor("#870620"));

                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 298));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.e3traf);
                mytitle.setText("صلوات الاعترف");
            } else if (name.equals("tnawl")) {
                textView.setTextColor(Color.parseColor("#870620"));

                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 300));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.tnawl);
                mytitle.setText("صلوات التناول");
            } else if (name.equals("food")) {
                textView.setTextColor(Color.parseColor("#870620"));

                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 302));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.food);
                mytitle.setText("صلوات الطعام");
            } else if (name.equals("work")) {
                textView.setTextColor(Color.parseColor("#870620"));

                try {
                    scrollView.setScrollY(0);

                    input = getAssets().open("text" + (position + 304));
                    bytes = new byte[input.available()];
                    input.read(bytes);
                    input.close();
                    String txt = new String(bytes);
                    textView.setText(txt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myimage.setImageResource(R.drawable.work);
                mytitle.setText("صلاة قبل العمل");
            }
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }


    }
}
