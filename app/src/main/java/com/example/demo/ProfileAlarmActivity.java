package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import es.dmoral.toasty.Toasty;

public class ProfileAlarmActivity extends AppCompatActivity {

    EditText hour_time, min_time;
    Button set_alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_alarm);


        hour_time = findViewById(R.id.hour_time);
        min_time = findViewById(R.id.minute_time);
        set_alarm = findViewById(R.id.set_alarm);




        set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String d1 = hour_time.getText().toString();
                String d = min_time.getText().toString();
            if (min_time.getText().toString().equals("") || hour_time.getText().toString().equals("")){
                Toasty.error(ProfileAlarmActivity.this, "You need to enter hours first!", Toast.LENGTH_SHORT).show();
                return;
            }
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour_time.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(min_time.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "STOP PLAYING! REST A BIT :)");


                if (hour_time.getText().toString().trim().length() <= 2) {
                    startActivity(intent);
                    Toasty.success(ProfileAlarmActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else if (hour_time.getText().toString().trim().length() > 2) {
                    Toasty.error(ProfileAlarmActivity.this, "Please choose proper time", Toast.LENGTH_SHORT).show();
                }
               else if (min_time.getText().toString().trim().length() <= 2) {
                    startActivity(intent);
                    Toasty.success(ProfileAlarmActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else if (min_time.getText().toString().trim().length() > 2)  {
                    Toasty.error(ProfileAlarmActivity.this, "Please choose proper time", Toast.LENGTH_SHORT).show();
                }
                }

            });
        }
}