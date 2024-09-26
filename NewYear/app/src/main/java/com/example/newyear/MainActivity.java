package com.example.newyear;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] canArray = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    String[] chiArray = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText gregorianYearInput = findViewById(R.id.editnamduonglich);
        Button convertButton = findViewById(R.id.button1);
        TextView lunarYearOutput = findViewById(R.id.textView5);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gregorianYear = Integer.parseInt(gregorianYearInput.getText().toString());
                String lunarYear = convertToLunarYear(gregorianYear);
                lunarYearOutput.setText(lunarYear);
            }
        });
    }

    private String convertToLunarYear(int year) {
        String can = canArray[year % 10];
        String chi = chiArray[year % 12];
        return can + " " + chi;
    }
}