package com.android.example.timeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.jakewharton.threetenabp.AndroidThreeTen;
import org.threeten.bp.Year;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        AndroidThreeTen.init(this);
        int year = Year.now().getValue();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Copenhagen");
        boolean daylightTime = timeZone.inDaylightTime(gregorianCalendar.getTime());

        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);

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
        if (!daylightTime) {
            timeZoneName = "Central European Time (UTC+1)";
        }
        else {
            timeZoneName = "Central European Summer Time (UTC+2)";
        }

        textView1.setText("Day of the year: " + gregorianCalendar.get(GregorianCalendar.DAY_OF_YEAR) + numDaysYear);
        textView2.setText("Week of the year: " + gregorianCalendar.get(GregorianCalendar.WEEK_OF_YEAR) + weeksPerYear);
        textView3.setText("Time zone: \n" + timeZoneName);
    }
}
