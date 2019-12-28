package com.androidtipsweekly.Otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class BusStation {
    // TODO: 12/28/2019
    //   private static Bus bus=new Bus();
    private static Bus bus = new Bus(ThreadEnforcer.ANY);

    public static Bus getBus() {
        return bus;
    }
}
