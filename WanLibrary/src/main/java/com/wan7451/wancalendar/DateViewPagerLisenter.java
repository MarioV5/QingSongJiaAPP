package com.wan7451.wancalendar;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class DateViewPagerLisenter implements OnPageChangeListener {

    private SildeDirection mDirection = SildeDirection.NO_SILDE;
    int mCurrIndex = 498;
    private DateView[] mShowViews;

    public DateViewPagerLisenter(CustomViewPagerAdapter<DateView> viewAdapter) {
        super();
        this.mShowViews = viewAdapter.getAllItems();
    }

    @Override
    public void onPageSelected(int arg0) {
        measureDirection(arg0);
        updateCalendarView(arg0);
    }

    private void updateCalendarView(int arg0) {
        if (mDirection == SildeDirection.RIGHT) {
            mShowViews[arg0 % mShowViews.length].rightSilde();
        } else if (mDirection == SildeDirection.LEFT) {
            mShowViews[arg0 % mShowViews.length].leftSilde();
        }
        mDirection = SildeDirection.NO_SILDE;
    }


    private void measureDirection(int arg0) {

        if (arg0 > mCurrIndex) {
            mDirection = SildeDirection.RIGHT;

        } else if (arg0 < mCurrIndex) {
            mDirection = SildeDirection.LEFT;
        }
        mCurrIndex = arg0;
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }


    enum SildeDirection {
        RIGHT, LEFT, NO_SILDE
    }
}