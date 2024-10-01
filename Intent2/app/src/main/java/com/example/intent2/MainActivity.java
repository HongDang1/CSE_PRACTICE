package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        EditText edta, edtb;
        Button btnkq;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edta = findViewById(R.id.txta);
            edtb = findViewById(R.id.txtb);
            btnkq = findViewById(R.id.btnketqua);

            btnkq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent myintent = new Intent(MainActivity.this, ketqua.class);
                    Bundle bundle1 = new Bundle();

                    int a = Integer.parseInt(edta.getText() + "");
                    int b = Integer.parseInt(edtb.getText() + "");

                    bundle1.putInt("soa", a);
                    bundle1.putInt("sob", b);

                    myintent.putExtra("mypackage", bundle1);
                    startActivity(myintent);
                }
            });
        }
    }
