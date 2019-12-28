package com.androidtipsweekly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtipsweekly.Otto.BusStation;
import com.androidtipsweekly.Otto.Message;
import com.androidtipsweekly.Otto.OttoIntentService;

public class MainActivity extends AppCompatActivity {
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.etInput);
    }

    public void ottoAction(View view) {
        String message = etInput.getText().toString();
        BusStation.getBus().post(new Message(message));
//      startService(new Intent(this, OttoIntentService.class));
    }
}
