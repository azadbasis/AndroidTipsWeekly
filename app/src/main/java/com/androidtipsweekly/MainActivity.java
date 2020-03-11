package com.androidtipsweekly;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo = new JobInfo.Builder(1001, new ComponentName(this, MyJobService.class))
                .setMinimumLatency(0)
                // .setPeriodic(2000)
                .build();
        jobScheduler.schedule(jobInfo);
      //  scheduleJobFirebaseToRoomDataUpdate();
    }
    private void scheduleJobFirebaseToRoomDataUpdate(){
        JobScheduler jobScheduler = (JobScheduler)getApplicationContext()
                .getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName componentName = new ComponentName(this,
                MyJobService.class);

        @SuppressLint("MissingPermission") JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                .setPeriodic(4000).setRequiredNetworkType(
                        JobInfo.NETWORK_TYPE_NOT_ROAMING)
                .setPersisted(true).build();
        jobScheduler.schedule(jobInfo);
    }
}
