package com.example.note;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapater;
    EditText edtwork, edthour, edtmi;
    Button btnwork;
    TextView txtdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.edthour);
        findViewById(R.id.edtmi);
        findViewById(R.id.edtwork);
        findViewById(R.id.btnadd);
        findViewById(R.id.listView1);
        findViewById(R.id.txtdate);

        ArrayList<String> arraywork = new ArrayList<>();
        ArrayAdapter<String> arrAdapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapater);

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem các EditText có rỗng hay không
                if (edtwork.getText().toString().isEmpty() ||
                        edthour.getText().toString().isEmpty() ||
                        edtmi.getText().toString().isEmpty()) {
                    // Hiển thị thông báo lỗi nếu có trường nào trống
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Thông tin thiếu");
                    builder.setMessage("Vui lòng nhập đầy đủ thông tin công việc");
                    builder.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Không có hành động gì khi nhấn nút "Tiếp tục" ở đây
                        }
                    });
                    builder.show();
                } else {
                    // Lấy nội dung công việc và thời gian, ghép thành một chuỗi
                    String newTask = edtwork.getText().toString() + " - " +
                            edthour.getText().toString() + ":" +
                            edtmi.getText().toString();

                    // Thêm công việc mới vào danh sách
                    arraywork.add(newTask);

                    // Cập nhật lại adapter để ListView hiển thị danh sách mới
                    arrAdapater.notifyDataSetChanged();

                    // Xóa nội dung trong các EditText
                    edtwork.setText("");
                    edthour.setText("");
                    edtmi.setText("");
                }
            }
        });
    }
}
