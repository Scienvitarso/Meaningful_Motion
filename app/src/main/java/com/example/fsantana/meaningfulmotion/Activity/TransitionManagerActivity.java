package com.example.fsantana.meaningfulmotion.Activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.fsantana.meaningfulmotion.CustomViews.ImageViewRatioThreeTwo;
import com.example.fsantana.meaningfulmotion.R;

public class TransitionManagerActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener{

    private AppCompatButton mAppCompatButton;
    private ImageViewRatioThreeTwo mImageViewRatioThreeTwo;
    private AppCompatSpinner mAppCompatSpinner;
    private static final String[] path = {"Fade", "Auto Transition", "ChangeBounds", "Transition Set",
            "Slide", "Explode", "Change clip bounds", "Change Image Transform", "Change Transform" };
    private int currentItem = 0;
    ViewGroup mViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_manager);
        mAppCompatButton = (AppCompatButton)
                findViewById(R.id.transition_manager_start_appcompatbutton);
        mImageViewRatioThreeTwo = (ImageViewRatioThreeTwo)
                findViewById(R.id.transition_manager_image_imageviewratiothreetwo);

        mAppCompatSpinner = (AppCompatSpinner)
                findViewById(R.id.transition_manager_select_spinner);


         mViewGroup = (ViewGroup) findViewById(R.id.layout_root);
        setUpSpinner();

        mAppCompatButton.setOnClickListener(this);
    }

    private void setUpSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, path);
        mAppCompatSpinner.setAdapter(arrayAdapter);
        mAppCompatSpinner.setOnItemSelectedListener(TransitionManagerActivity.this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (currentItem){
            case 0 : startFade(); break;
            case 1 : startAutoTransition(); break;
            case 2 : startChangeBounds(); break;
            case 3 : startTransitionSet(); break;
            case 4 : startSlide(); break;
            case 5 : startExplode(); break;
            case 6 : startChangeClipBounds();break;
            case 7 : startChangeImageTransform(); break;
            case 8 : startChangeTransform(); break;

        }


    }
    private void toggleVisibility() {
        if (mImageViewRatioThreeTwo.getVisibility() == View.INVISIBLE) {
            mImageViewRatioThreeTwo.setVisibility(View.VISIBLE);
        }else {

            mImageViewRatioThreeTwo.setVisibility(View.INVISIBLE);
        }
    }
    private void startFade() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            Fade fade = new Fade();
            TransitionManager.beginDelayedTransition(mViewGroup, fade);
            toggleVisibility();
        }

    }

    private void startAutoTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(mViewGroup);
            toggleVisibility();
        }
    }

    private void startChangeBounds() {
        ChangeBounds changeBounds = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            changeBounds = new ChangeBounds();
            TransitionManager.beginDelayedTransition(mViewGroup,changeBounds);
            toggleVisibility();
        }
    }

    private void startTransitionSet() {

    }

    private void startSlide() {

        Slide slide = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            slide = new Slide();
            if(mImageViewRatioThreeTwo.getVisibility() == View.INVISIBLE) {
                slide.setSlideEdge(Gravity.RIGHT);
            } else {
                slide.setSlideEdge(Gravity.LEFT);
            }
            TransitionManager.beginDelayedTransition(mViewGroup, slide);

            if (mImageViewRatioThreeTwo.getVisibility() == View.INVISIBLE) {
                mImageViewRatioThreeTwo.setVisibility(View.VISIBLE);
            } else {
                mImageViewRatioThreeTwo.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void startExplode() {
        Explode explode = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            explode = new Explode();
            TransitionManager.beginDelayedTransition(mViewGroup, explode);
            toggleVisibility();
        }
    }

    private void startChangeClipBounds () {
    }

    private void startChangeImageTransform () {

    }

    private void startChangeTransform () {

    }
    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p/>
     * Impelmenters can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            currentItem = position;
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
