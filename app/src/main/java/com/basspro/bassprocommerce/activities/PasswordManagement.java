package com.basspro.bassprocommerce.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.services.ServicePasswordReset;
import com.basspro.bassprocommerce.services.datatypes.PasswordResetData;
import com.basspro.bassprocommerce.services.datatypes.ServiceDataHandler;

public class PasswordManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_management);
    }

    public void onResetPassword(View view) {
        String userId = "DPAUNOVI@GMAIL.COM";
        String challengeAnswer = "Answer";


        new ServicePasswordReset().makeCall(userId, challengeAnswer, new ServiceDataHandler<PasswordResetData>() {
            @Override
            public void handleResponse(PasswordResetData data) {
                TextView msg = findViewById(R.id.successMessageId);
                if (data.isError()) {
                    msg.setText("@string/error_failure");
                } else {
                    msg.setText(data.getUserId());
                }

            }
        });


    }
}
