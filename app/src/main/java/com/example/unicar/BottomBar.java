package com.example.unicar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.unicar.activities.CancelReservationActivity;
import com.example.unicar.activities.LeavingWhere;
import com.example.unicar.activities.Location;
import com.example.unicar.activities.MainMenu;
import com.example.unicar.activities.ProfileActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomBar extends Fragment {

    public Button rides;
    public Button search;
    public Button offer;
    public Button profile;

    public BottomBar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom_bar, container, false);

        rides = v.findViewById(R.id.btnCaronas);
        search = v.findViewById(R.id.btnProcurar);
        offer = v.findViewById(R.id.btnOferecer);
        profile = v.findViewById(R.id.btnPerfil);

        rides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rides(v);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });

        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer(v);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile(v);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    public void rides(View v){
        Intent i = new Intent(getActivity(), MainMenu.class);
        startActivity(i);
    }

    public void search(View v){
        Intent i = new Intent(getActivity(), Location.class);
        startActivity(i);
    }

    public void offer(View v){
        Intent i = new Intent(getActivity(), LeavingWhere.class);
        startActivity(i);
    }

    public void message(View v){
        //TODO
    }

    public void profile(View v){
        Intent i = new Intent(getActivity(), ProfileActivity.class);
        startActivity(i);
    }

}
