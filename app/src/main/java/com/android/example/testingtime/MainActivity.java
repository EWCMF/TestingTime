package com.android.example.testingtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidThreeTen.init(this);

        textView = findViewById(R.id.text1);
        org.threeten.bp.LocalDate localDate = org.threeten.bp.LocalDate.now();

        textView.setText(localDate.toString());
    }
}
