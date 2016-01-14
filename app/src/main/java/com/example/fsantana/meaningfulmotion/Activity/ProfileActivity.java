package com.example.fsantana.meaningfulmotion.Activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.fsantana.meaningfulmotion.CustomViews.ImageViewRatioThreeTwo;
import com.example.fsantana.meaningfulmotion.R;

public class ProfileActivity extends AppCompatActivity {

    private int mAvatarId;
    private String mTitle;
    private String mSubtitle;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageViewRatioThreeTwo mImageViewRatioThreeTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.profile_collapsingtoolbarlayout);
        mImageViewRatioThreeTwo = (ImageViewRatioThreeTwo) findViewById(R.id.profile_avatar_imageview);

        receiveData();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle(mTitle);
        mImageViewRatioThreeTwo.setImageResource(mAvatarId);

    }


    private void receiveData() {
        mAvatarId = getIntent().getIntExtra(MainActivity.AVATAR_ID, R.drawable.mylena);
        mTitle = getIntent().getStringExtra(MainActivity.TITLE_ID);
        mSubtitle = getIntent().getStringExtra(MainActivity.SUBTITLE_ID);
    }

}
