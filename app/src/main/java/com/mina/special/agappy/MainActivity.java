package com.mina.special.agappy;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String aya_txt;
    int i = 0;
    int s;
    SharedPreferences sharedPreferences;
    TextView monaspat_txt1, monaspat_txt2, feedback_title, share_title, aya_title, rating_title;
    Dialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ImageView sawa3y = findViewById(R.id.image1);
        ImageView noslel = findViewById(R.id.image2);
        ImageView sattar = findViewById(R.id.image3);
        ImageView salawat = findViewById(R.id.image4);
        TextView sawa3ytxt = findViewById(R.id.sawa3ytxt);
        TextView nosleltxt = findViewById(R.id.nosleltxt);
        TextView sattartxt = findViewById(R.id.sattartxt);
        TextView salawattxt = findViewById(R.id.salawattxt);
        ImageView list = findViewById(R.id.list_icon);
        final ImageView feedback = findViewById(R.id.feedback);
        final ImageView share = findViewById(R.id.share);
        final ImageView rating = findViewById(R.id.rating);
        final ImageView aya = findViewById(R.id.aya);
        final LinearLayout feedbacklayout = findViewById(R.id.feedbacklayout);
        final LinearLayout sharelayout = findViewById(R.id.sharelayout);
        final LinearLayout ayalayout = findViewById(R.id.ayalayout);
        final LinearLayout ratinglayout = findViewById(R.id.ratinglayout);
        monaspat_txt1 = findViewById(R.id.monaspa_text1);
        monaspat_txt2 = findViewById(R.id.monaspa_text2);
        feedback_title = findViewById(R.id.feedback_title);
        share_title = findViewById(R.id.share_title);
        aya_title = findViewById(R.id.aya_title);
        rating_title = findViewById(R.id.rating_title);
        final RelativeLayout mylayout = findViewById(R.id.mylayout);
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("monaspat");
        String[] arr = getResources().getStringArray(R.array.ayat);
        Random rnd = new Random();
        final int ind = rnd.nextInt(arr.length);
        aya_txt = arr[ind];
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        SeekBar sb = dialog.findViewById(R.id.seek_bar);
        final TextView tx = dialog.findViewById(R.id.tx);
        final TextView cancel = dialog.findViewById(R.id.cancel);
        final TextView ok = dialog.findViewById(R.id.ok);
        sharedPreferences = getSharedPreferences("file", 0);
        sb.setProgress(sharedPreferences.getInt("size", 5));
        tx.setTextSize(sharedPreferences.getInt("size", 5) + 15);

        ayalayout.setEnabled(false);
        ratinglayout.setEnabled(false);
        sharelayout.setEnabled(false);
        feedbacklayout.setEnabled(false);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, boolean b) {
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                tx.setTextSize(i + 15);
                s = i;

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        seekBar.setProgress(sharedPreferences.getInt("size", 5));
                        tx.setTextSize(sharedPreferences.getInt("size", 5) + 15);
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editor.putInt("size", i);
                        editor.apply();
                        dialog.dismiss();
                    }
                });


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "تطبيق الأجبية المقدسة" + "\n" + "https://play.google.com/store/apps/details?id=" + getPackageName());
                startActivity(Intent.createChooser(intent, "مشاركة التطبيق"));
            }
        });
        ratinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

                }

            }
        });

        ayalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DailyAyaActivity.class).putExtra("aya", aya_txt));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);
                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);
                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);


                i = 0;
            }
        });


        databaseReference.child("txt1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                monaspat_txt1.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("txt2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                monaspat_txt2.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (++i % 2 != 0) {
                    feedback.animate().translationX(0).translationY(0).rotationBy(720).setDuration(500);
                    share.animate().translationX(0).translationY(0).rotationBy(720).setDuration(500);
                    rating.animate().translationX(0).translationY(0).rotationBy(720).setDuration(500);
                    aya.animate().translationX(0).translationY(0).rotationBy(720).setDuration(500);

                    ayalayout.setEnabled(true);
                    ratinglayout.setEnabled(true);
                    sharelayout.setEnabled(true);
                    feedbacklayout.setEnabled(true);

                    feedback_title.animate().alpha(1).setDuration(500);
                    rating_title.animate().alpha(1).setDuration(500);
                    aya_title.animate().alpha(1).setDuration(500);
                    share_title.animate().alpha(1).setDuration(500);

                    feedbacklayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
                            feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                            share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                            rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                            aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                            ayalayout.setEnabled(false);
                            ratinglayout.setEnabled(false);
                            sharelayout.setEnabled(false);
                            feedbacklayout.setEnabled(false);

                            feedback_title.animate().alpha(0).setDuration(200);
                            rating_title.animate().alpha(0).setDuration(200);
                            aya_title.animate().alpha(0).setDuration(200);
                            share_title.animate().alpha(0).setDuration(200);


                            i = 0;

                        }
                    });

                } else {
                    feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                    share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                    rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                    aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                    ayalayout.setEnabled(false);
                    ratinglayout.setEnabled(false);
                    sharelayout.setEnabled(false);
                    feedbacklayout.setEnabled(false);

                    feedback_title.animate().alpha(0).setDuration(200);
                    rating_title.animate().alpha(0).setDuration(200);
                    aya_title.animate().alpha(0).setDuration(200);
                    share_title.animate().alpha(0).setDuration(200);


                }
                mylayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                        share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                        rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                        aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);
                        ayalayout.setEnabled(false);
                        ratinglayout.setEnabled(false);
                        sharelayout.setEnabled(false);
                        feedbacklayout.setEnabled(false);
                        feedback_title.animate().alpha(0).setDuration(200);
                        rating_title.animate().alpha(0).setDuration(200);
                        aya_title.animate().alpha(0).setDuration(200);
                        share_title.animate().alpha(0).setDuration(200);

                        i = 0;
                    }
                });
            }
        });


        sawa3y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Elsawa3yActivity.class));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);
                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);

                i = 0;
            }
        });
        sawa3ytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Elsawa3yActivity.class));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);


                rating_title.animate().alpha(0).setDuration(200);


                aya_title.animate().alpha(0).setDuration(200);


                share_title.animate().alpha(0).setDuration(200);

                i = 0;
            }
        });
        noslel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NoslelActivity.class));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);
                i = 0;
            }
        });
        nosleltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NoslelActivity.class));
            }
        });
        sattar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Elsawa3yText.class).putExtra("name", "الستار"));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);
                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);
                i = 0;
            }
        });
        sattartxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Elsawa3yText.class).putExtra("name", "الستار"));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);
                i = 0;
            }
        });
        salawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SalawatActivity.class));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);
                i = 0;
            }
        });
        salawattxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SalawatActivity.class));
                feedback.animate().translationX(140).translationY(100).rotation(0).setDuration(200);
                share.animate().translationX(40).translationY(200).rotation(0).setDuration(200);
                rating.animate().translationX(-140).translationY(100).rotation(0).setDuration(200);
                aya.animate().translationX(-40).translationY(200).rotation(0).setDuration(200);

                ayalayout.setEnabled(false);
                ratinglayout.setEnabled(false);
                sharelayout.setEnabled(false);
                feedbacklayout.setEnabled(false);

                feedback_title.animate().alpha(0).setDuration(200);
                rating_title.animate().alpha(0).setDuration(200);
                aya_title.animate().alpha(0).setDuration(200);
                share_title.animate().alpha(0).setDuration(200);
                i = 0;
            }
        });


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(MainActivity.this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        if (System.currentTimeMillis() > calendar.getTimeInMillis()) {
            alarmManager.cancel(pendingIntent);

        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 6);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);

        Intent intent1 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "baker");
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent1);
        if (System.currentTimeMillis() > calendar1.getTimeInMillis()) {
            alarmManager1.cancel(pendingIntent1);
        }


        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY, 9);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);

        Intent intent2 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "talta");
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 1, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent2);
        if (System.currentTimeMillis() > calendar2.getTimeInMillis()) {
            alarmManager2.cancel(pendingIntent2);
        }

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.HOUR_OF_DAY, 12);
        calendar3.set(Calendar.MINUTE, 0);
        calendar3.set(Calendar.SECOND, 0);
        Intent intent3 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "sata");
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 2, intent3, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager3 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager3.setRepeating(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent3);
        if (System.currentTimeMillis() > calendar3.getTimeInMillis()) {
            alarmManager3.cancel(pendingIntent3);
        }

        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(Calendar.HOUR_OF_DAY, 15);
        calendar4.set(Calendar.MINUTE, 0);
        calendar4.set(Calendar.SECOND, 0);
        Intent intent4 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "tas3a");
        PendingIntent pendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), 3, intent4, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager4 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager4.setRepeating(AlarmManager.RTC_WAKEUP, calendar4.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent4);
        if (System.currentTimeMillis() > calendar4.getTimeInMillis()) {
            alarmManager4.cancel(pendingIntent4);
        }
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(Calendar.HOUR_OF_DAY, 17);
        calendar5.set(Calendar.MINUTE, 0);
        calendar5.set(Calendar.SECOND, 0);
        Intent intent5 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "ghrob");
        PendingIntent pendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), 4, intent5, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager5 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager5.setRepeating(AlarmManager.RTC_WAKEUP, calendar5.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent5);
        if (System.currentTimeMillis() > calendar5.getTimeInMillis()) {
            alarmManager5.cancel(pendingIntent5);
        }
        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(Calendar.HOUR_OF_DAY, 18);
        calendar6.set(Calendar.MINUTE, 0);
        calendar6.set(Calendar.SECOND, 0);
        Intent intent6 = new Intent(getApplicationContext(), MyReceiver.class).putExtra("sala", "nom");
        PendingIntent pendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), 5, intent6, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager6 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager6.setRepeating(AlarmManager.RTC_WAKEUP, calendar6.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent6);
        if (System.currentTimeMillis() > calendar6.getTimeInMillis()) {
            alarmManager6.cancel(pendingIntent6);
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("تطبيق الأجبية المقدسة").setMessage("هل تريد الخروج من التطبيق؟").setIcon(R.drawable.close).setPositiveButton("موافق", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        }).setNegativeButton("اِلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.elsawa3y, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dialog.show();
        return super.onOptionsItemSelected(item);
    }

}
