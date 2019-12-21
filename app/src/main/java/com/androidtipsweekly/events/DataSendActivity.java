package com.androidtipsweekly.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidtipsweekly.MainActivity;
import com.androidtipsweekly.R;

import org.greenrobot.eventbus.EventBus;

public class DataSendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_send);
        Button btnFi=findViewById(R.id.btnFi);
        btnFi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent messageEvent=new MessageEvent("Test event message");
                EventBus.getDefault().post(messageEvent);
                startActivity(new Intent(DataSendActivity.this, MainActivity.class));
            }
        });


    }
}
