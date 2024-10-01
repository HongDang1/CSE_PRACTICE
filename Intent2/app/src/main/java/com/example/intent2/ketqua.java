package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; // Đổi từ EditText sang TextView vì chỉ hiển thị kết quả
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ketqua extends AppCompatActivity {
    TextView edtkq; // Đổi từ EditText sang TextView
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketqua);

        edtkq = findViewById(R.id.txtketqua);
        btnback = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("mypackage");

        int a = yourbundle.getInt("soa");
        int b = yourbundle.getInt("sob");

        // Xử lý logic tính toán nghiệm
        String kq = "";
        if (a == 0 && b == 0) {
            kq = "Vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "Vô nghiệm";
        } else {
            DecimalFormat df = new DecimalFormat("0.##");
            kq = df.format(-b * 1.0 / a); // Tính nghiệm và định dạng kết quả
        }

        // Hiển thị kết quả
        edtkq.setText(kq);

        // Xử lý sự kiện nút Back
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity và quay lại Activity trước đó
            }
        });
    }
}
