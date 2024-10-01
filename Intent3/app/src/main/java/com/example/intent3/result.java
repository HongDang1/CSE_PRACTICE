package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    EditText edtAA, edtBB;
    Button btnsendtong, btnsendhieu;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        // Liên kết các view với các biến
        edtAA = findViewById(R.id.edtAA);
        edtBB = findViewById(R.id.edtBB);
        btnsendtong = findViewById(R.id.btnsendtong);
        btnsendhieu = findViewById(R.id.btnsendhieu);

        // Nhận Intent từ MainActivity
        myintent = getIntent();
        // Lấy dữ liệu từ Intent
        int a = myintent.getIntExtra("soa", 0);
        int b = myintent.getIntExtra("sob", 0);

        // Hiển thị giá trị nhận được trong EditText
        edtAA.setText(a + "");
        edtBB.setText(b + "");

        // Xử lý khi nhấn nút "TRẢ VỀ TỔNG"
        btnsendtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý kết quả: Tính tổng
                int sum = a + b;
                // Đẩy kết quả trở lại Intent
                myintent.putExtra("kq", sum);
                // Trả Intent về MainActivity với mã kết quả là 33
                setResult(33, myintent);
                // Thoát Activity để quay về
                finish();
            }
        });

        // Xử lý khi nhấn nút "TRẢ VỀ HIỆU"
        btnsendhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý kết quả: Tính hiệu
                int sub = a - b;
                // Đẩy kết quả trở lại Intent
                myintent.putExtra("kq", sub);
                // Trả Intent về MainActivity với mã kết quả là 34
                setResult(34, myintent);
                // Thoát Activity để quay về
                finish();
            }
        });
    }
}
