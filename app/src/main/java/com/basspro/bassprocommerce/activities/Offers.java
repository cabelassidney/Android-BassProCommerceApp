package com.basspro.bassprocommerce.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.basspro.bassprocommerce.R;

public class Offers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
    }

    public void gotToOfferDetails(View view) {
        Intent intent = new Intent(this, OfferDetails.class);
        startActivity(intent);
    }


}
