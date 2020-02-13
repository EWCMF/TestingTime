package com.android.example.testingtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.Year;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidThreeTen.init(this);
        int year = Year.now().getValue();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);

        String numDaysYear;
        if (gregorianCalendar.isLeapYear(year))
            numDaysYear = "/366";
        else
            numDaysYear = "/365";


        textView1.setText("Day of the year: " + gregorianCalendar.get(GregorianCalendar.DAY_OF_YEAR) + numDaysYear);
        textView2.setText("Week of the year: " + gregorianCalendar.get(GregorianCalendar.WEEK_OF_YEAR) + "/52");
    }
}
