package com.androidtipsweekly;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidtipsweekly.Otto.BusStation;
import com.androidtipsweekly.Otto.Message;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvResult = view.findViewById(R.id.tvResult);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        BusStation.getBus().unregister(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        BusStation.getBus().register(this);
    }

    @Subscribe
    public void recieveMessage(Message message){
       tvResult.setText(message.getMsg());
    }
}
