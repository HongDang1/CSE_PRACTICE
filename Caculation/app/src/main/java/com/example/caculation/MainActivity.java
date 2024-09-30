package com.example.caculation;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnTiepTuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTiepTuc = findViewById(R.id.btntieptuc);
        btnGiai = findViewById(R.id.btngiaiPT);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtkq = findViewById(R.id.txtkq);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String kq = "";
                DecimalFormat dcf = new DecimalFormat("0.00");

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            kq = "PT vô số nghiệm";
                        } else {
                            kq = "PT vô nghiệm";
                        }
                    } else {
                        kq = "Pt có 1 No, x= " + dcf.format(-c / (float) b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "PT vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Pt có No kép x1=x2= " + dcf.format(-b / (2 * (float) a));
                    } else {
                        kq = "Pt có 2 No: x1= " + dcf.format((-b + Math.sqrt(delta)) / (2 * a)) +
                                "; x2= " + dcf.format((-b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                txtkq.setText(kq);
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

