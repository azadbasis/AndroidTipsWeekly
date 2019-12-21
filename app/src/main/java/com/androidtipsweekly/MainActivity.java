package com.androidtipsweekly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtipsweekly.events.DataSendActivity;
import com.androidtipsweekly.events.MessageEvent;
import com.androidtipsweekly.events.MyIntentService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, MyIntentService.class));
        EventBus.getDefault().register(this);
        Button btnEvent=findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataSendActivity.class));
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public   void onMessageEvent(MessageEvent event){
        TextView result=findViewById(R.id.tv);
        result.setText(event.getMessage());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSviceEvent(MessageEvent event){

        Toast.makeText(MainActivity.this, event.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
