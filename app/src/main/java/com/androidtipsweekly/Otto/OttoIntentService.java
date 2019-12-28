package com.androidtipsweekly.Otto;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class OttoIntentService extends IntentService {


    public OttoIntentService() {
        super("OttoIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            BusStation.getBus().post(new Message("OttoIntentService message"));
        }
    }


}
