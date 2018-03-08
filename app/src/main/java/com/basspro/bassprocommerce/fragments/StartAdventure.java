package com.basspro.bassprocommerce.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.activities.Welcome;

public class StartAdventure extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start_adventure, container, false);
        Button btnstart = view.findViewById(R.id.btnStart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Welcome.getInstance()!=null){
                    Welcome.getInstance().navigateToSecond();
                }
            }
        });
        return view;
    }

    //
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_start_view_pager);
//    }
}
