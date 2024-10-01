package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liên kết các view với các biến
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);

        btnrequest = findViewById(R.id.btnrequest);

        // Xử lý sự kiện khi nhấn nút "YÊU CẦU KẾT QUẢ"
        btnrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai báo intent để chuyển sang SubActivity
                Intent myintent = new Intent(MainActivity.this, result.class);

                // Lấy dữ liệu từ EditText A và B
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                // Đẩy dữ liệu vào intent
                myintent.putExtra("soa", a);
                myintent.putExtra("sob", b);

                // Khởi động intent với ActivityResultLauncher
                activityResultLauncher.launch(myintent);
            }
        });
    }

    // Khai báo ActivityResultLauncher thay thế cho startActivityForResult
    private final ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == 33 && result.getData() != null) {
                            // Nhận kết quả tổng
                            int sum = result.getData().getIntExtra("kq", 0);
                            edtKQ.setText("Tổng 2 số là: " + sum);
                        } else if (result.getResultCode() == 34 && result.getData() != null) {
                            // Nhận kết quả hiệu
                            int sub = result.getData().getIntExtra("kq", 0);
                            edtKQ.setText("Hiệu 2 số là: " + sub);
                        }
                    });
}
