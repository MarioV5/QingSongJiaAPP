package com.qingsongjia.qingsongjia.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qingsongjia.qingsongjia.R;
import com.qingsongjia.qingsongjia.fragment.ExamFragment;
import com.qingsongjia.qingsongjia.fragment.ExchangeFragment;
import com.qingsongjia.qingsongjia.fragment.SchoolFragment;
import com.qingsongjia.qingsongjia.fragment.ToolsFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @Bind(R.id.main_img_drawerIcon)
    ImageView mainImgDrawerIcon;
    @Bind(R.id.main_tv_title)
    TextView mainTvTitle;
    @Bind(R.id.main_realtabcontent)
    FrameLayout mainRealtabcontent;
    @Bind(R.id.main_tabHost)
    FragmentTabHost mainTabHost;
    @Bind(R.id.main_drawerLayout)
    DrawerLayout mainDrawerLayout;
    @Bind(R.id.main_mainView)
    LinearLayout mainMainView;
    @Bind(R.id.main_tab1)
    RadioButton mainTab1;
    @Bind(R.id.main_tab2)
    RadioButton mainTab2;
    @Bind(R.id.main_tab3)
    RadioButton mainTab3;
    @Bind(R.id.main_tab4)
    RadioButton mainTab4;
    @Bind(R.id.main_navigation)
    RadioGroup mainNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSystemBar(getResources().getColor(R.color.toolbar_bg));

        mainTvTitle.setText("轻松驾");

        mainTabHost.setup(this, getSupportFragmentManager(), R.id.main_realtabcontent);

        mainTabHost.addTab(mainTabHost.newTabSpec("1").setIndicator("A"), ExamFragment.class, null);
        mainTabHost.addTab(mainTabHost.newTabSpec("2").setIndicator("B"), SchoolFragment.class, null);
        mainTabHost.addTab(mainTabHost.newTabSpec("3").setIndicator("C"), ExchangeFragment.class, null);
        mainTabHost.addTab(mainTabHost.newTabSpec("4").setIndicator("D"), ToolsFragment.class, null);

        mainTabHost.setCurrentTab(0);
        mainNavigation.setOnCheckedChangeListener(this);
        mainImgDrawerIcon.setOnClickListener(this);
    }


    private SystemBarTintManager.SystemBarConfig config;

    public void initSystemBar(int color) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintColor(color);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(color);
            View v = findViewById(R.id.main_mainView);
            if (v != null && config == null) {
                config = tintManager.getConfig();
                v.setPadding(0, config.getPixelInsetTop(true), 0, 0);
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_tab1:
                mainTabHost.setCurrentTab(0);
                break;
            case R.id.main_tab2:
                mainTabHost.setCurrentTab(1);
                break;
            case R.id.main_tab3:
                mainTabHost.setCurrentTab(2);
                break;
            case R.id.main_tab4:
                mainTabHost.setCurrentTab(3);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (mainDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mainDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            mainDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}