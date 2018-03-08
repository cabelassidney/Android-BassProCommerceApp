package com.basspro.bassprocommerce.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.activities.Home;
import com.basspro.bassprocommerce.activities.Login;
import com.basspro.bassprocommerce.activities.Register;
import com.basspro.bassprocommerce.localstorage.AppData;

public class ChooseYourOwnAdventure extends Fragment {
    Button btnGuest,btnSignUp;
    TextView btnExist;
    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_choose_adventure, container, false);
        AppData.createSharedPref(getActivity());
        btnExist = view.findViewById(R.id.textView25);
        btnSignUp = view.findViewById(R.id.btnStart);
        btnGuest =  view.findViewById(R.id.skipme);
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppData.setGuest(true);
                Intent intent = new Intent(getActivity(),Home.class);
                intent.putExtra("Guest",v.getId());
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppData.setRegistering(true);
                Intent intent = new Intent(getActivity(),Register.class);
                intent.putExtra("SignUp",v.getId());
                startActivity(intent);
            }
        });
        btnExist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Login.class);
                intent.putExtra("Login",v.getId());
                startActivity(intent);
            }
        });
        return view;

    }
}
