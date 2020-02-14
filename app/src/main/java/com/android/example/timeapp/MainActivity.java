package com.android.example.timeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.jakewharton.threetenabp.AndroidThreeTen;
import org.threeten.bp.Year;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidThreeTen.init(this);
        int year = Year.now().getValue();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int timeZoneOffset = gregorianCalendar.getTimeZone().getRawOffset() / 3600000;

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);

        String numDaysYear;
        String weeksPerYear;
        if (gregorianCalendar.isLeapYear(year)) {
            numDaysYear = "/366";
            weeksPerYear = "/53";
        }
        else {
            numDaysYear = "/365";
            weeksPerYear = "/52";
        }
        String timeZoneName;
        if (timeZoneOffset == 1) {
            timeZoneName = "Central European Time (UTC+1)";
        }
        else if (timeZoneOffset == 2) {
            timeZoneName = "Central European Summer Time (UTC+2)";
        }
        else
            timeZoneName = "Outside Denmark not supported";

        textView1.setText("Day of the year: " + gregorianCalendar.get(GregorianCalendar.DAY_OF_YEAR) + numDaysYear);
        textView2.setText("Week of the year: " + gregorianCalendar.get(GregorianCalendar.WEEK_OF_YEAR) + weeksPerYear);
        textView3.setText("Time zone: \n" + timeZoneName);
    }
}
