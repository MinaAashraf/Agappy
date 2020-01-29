package com.mina.special.agappy;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DailyAyaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_aya);
        TextView textView = findViewById(R.id.ayatxt);
        textView.setText(getIntent().getExtras().getString("aya"));

if (getIntent().getExtras().getBoolean("share")==true)
{
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT,getIntent().getExtras().getString("aya"));
    if (intent.resolveActivity(getPackageManager())!=null)
    {
        startActivity(Intent.createChooser(intent,"Share"));
    }
}
NotificationManager mm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);

    }
}
