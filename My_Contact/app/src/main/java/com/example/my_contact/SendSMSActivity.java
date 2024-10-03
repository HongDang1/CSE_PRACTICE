package com.example.my_contact;

// SMSActivity.java
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SendSMSActivity extends AppCompatActivity {

    EditText editTextPhoneNumber;
    ImageButton buttonSendSMS;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonSendSMS = findViewById(R.id.buttonSendSMS);
        buttonBack = findViewById(R.id.buttonBack);

        // Send SMS button action
        buttonSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhoneNumber.getText().toString();
                Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber, null));
                smsIntent.putExtra("sms_body", "Hello");
                startActivity(smsIntent);
            }
        });

        // Back button action
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
