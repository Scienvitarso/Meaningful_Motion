package com.example.fsantana.meaningfulmotion.Activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.fsantana.meaningfulmotion.CustomViews.ImageViewRatioThreeTwo;
import com.example.fsantana.meaningfulmotion.R;

public class ProfileActivity extends AppCompatActivity {

    private int mAvatarId;
    private String mTitle;
    private String mSubtitle;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageViewRatioThreeTwo mImageViewRatioThreeTwo;
    private ImageView mImageView;
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        receiveData();
        setUpLayout();
    }

    private void setUpLayout() {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.profile_collapsingtoolbarlayout);
        mCollapsingToolbarLayout.setTitle(mTitle);
        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT) {
            mImageView = (ImageView) findViewById(R.id.profile_avatar_imageview);
            mImageView.setImageResource(mAvatarId);
        } else {
            mImageViewRatioThreeTwo = (ImageViewRatioThreeTwo) findViewById(R.id.profile_avatar_imageview);
            mImageViewRatioThreeTwo.setImageResource(mAvatarId);
        }

    }

    private void receiveData() {
        mAvatarId = getIntent().getIntExtra(MainActivity.AVATAR_ID, R.drawable.fabio);
        mTitle = getIntent().getStringExtra(MainActivity.TITLE_ID);
        mSubtitle = getIntent().getStringExtra(MainActivity.SUBTITLE_ID);
    }

}
