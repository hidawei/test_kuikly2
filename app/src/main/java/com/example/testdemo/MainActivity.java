package com.example.testdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdemo.recycleview.RecyclerViewActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.recycleviewdemo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
                    long time1 = zbj.toEpochSecond();
                    ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
                    long time2 = zny.toEpochSecond();
                    Log.d("vinneywang", "time1:" + time1 + ",time2:" + time2);
                    String format = "yyyy-MMMM-dd'T'HH:mm:ss[aa.SSS.zzz";
                    SimpleDateFormat sm = new SimpleDateFormat(format);
                    String formatTime = sm.format(new Date(System.currentTimeMillis()));
                    Log.d("vinneywang", "formatTime:" + formatTime);
                    String format2 = "yyyy-MMMM-dd''HH:mm:ss.aa[SSS.z";
                    sm.applyPattern(format2);
                    try {
                        int d = sm.parse("2024-December-10'5:35:30.PM[150.GMT+08:00").getHours();
                        Log.d("vinneywang", "Hours:" + d);
                        //解析时，日期字符串一定要和指定的pattern一样
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    Calendar c2 = Calendar.getInstance();
                    c2.setTimeInMillis(1574208900000l);
                    //打印时间戳对应的本地时区时间
                    Log.d("vinneywang", "timeZone2:" + ",day:" + c2.get(Calendar.DAY_OF_MONTH) + ",hour:" + c2.get(Calendar.HOUR_OF_DAY) + ", min:" + c2.get(Calendar.MINUTE) + ",timeStamp:" + c2.getTimeInMillis());
                    int timezoneoffset2 = TimeZone.getTimeZone("GMT+09:00").getRawOffset();//包含夏令时
                    Log.d("vinneywang", "c2 toString1:" + c2.toString());
                    //打印时间戳对应的新时区对应的时间
                    c2.set(Calendar.ZONE_OFFSET, timezoneoffset2);
                    c2.set(Calendar.DST_OFFSET, 0);
                    Log.d("vinneywang", "c2 toString2:" + c2.toString());
                    c2.setTimeZone(TimeZone.getTimeZone("GMT+10:00"));//不包含夏令时信息
                    Log.d("vinneywang", "timeZone2 change:" + ",day:" + c2.get(Calendar.DAY_OF_MONTH) + ",hour:" + c2.get(Calendar.HOUR_OF_DAY) + ", min:" + c2.get(Calendar.MINUTE) + ",timeStamp:" + c2.getTimeInMillis());

                    //设置时区，要考虑时区对应的夏令时规则，结合时区对应的rawOffset，计算出对应的时区offset。
                    //设置ZONE_OFFSET，
                    sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    sm.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                    String formatedTime = sm.format(new Date(1735693500100L));
                    Calendar c3 = Calendar.getInstance();
                    c3.setTimeInMillis(1735693500100L);
                    Log.d("vinneywang", "formatedTime:" + formatedTime + ",getMonth:" + c3.get(Calendar.MONTH));
//                    sm.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                }
            }
        });

        findViewById(R.id.vToSuspendedLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SuspendedLayoutActivity.class));
            }
        });

        ViewGroup outer = (ViewGroup) findViewById(R.id.outer);
        outer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Button btn = new Button(MainActivity.this);
                outer.addView(btn);
                btn.setVisibility(View.INVISIBLE);
                outer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Log.d("vinney", "onGloballayout");
                    }
                });
            }
        }, 1000);

    }
}
