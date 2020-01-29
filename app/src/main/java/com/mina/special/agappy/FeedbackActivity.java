package com.mina.special.agappy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText editText = findViewById(R.id.edit_text);
        Button send_button = findViewById(R.id.send_btn);
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Feedback");
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty())
                {
                    editText.setError("اكتب شيء!");
                    editText.requestFocus();
                }
                else
                {

                    databaseReference.push().setValue(editText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                editText.setText("");
                                Toast.makeText(FeedbackActivity.this, "تم الاِرسال بنجاح..شكرا لك.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(FeedbackActivity.this, "تأكد من اِتصالك بالاِنترنت ثم اعد المحاولة.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });
    }
}
