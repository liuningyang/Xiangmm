package com.example.xiangmm.fragment.activitys;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.xiangmm.R;
import com.example.xiangmm.base.activity.SimpleActivity;
import com.example.xiangmm.utils.DateUtil;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

import butterknife.BindView;



public class CalendarActivity extends SimpleActivity {


    /*CalendarDay mDate;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;*/
    @BindView(R.id.view_calender)
    MaterialCalendarView mViewCalender;
   /* @BindView(R.id.tv_calender_enter)
    TextView mTvCalenderEnter;*/


    @Override
    protected void initData() {

     /*   setToolBar(mToolBar, "选择日期");*/
        mViewCalender.state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setMinimumDate(CalendarDay.from(2013, 5, 20))
                .setMaximumDate(CalendarDay.from(DateUtil.getCurrentYear(), DateUtil.getCurrentMonth(), DateUtil.getCurrentDay()))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
       /* mViewCalender.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                mDate = date;
            }
        });*/
    }

  /*  protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }*/

    @Override
    protected int createLayoutId() {
        return R.layout.activity_calendar;
    }



}
