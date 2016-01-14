package com.example.fsantana.meaningfulmotion.Activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fsantana.meaningfulmotion.R;

public class TransitionScenesActivity extends AppCompatActivity {
    private boolean mainScene = true;

    private AppCompatButton mAppCompatButton;
    private AppCompatButton mAppCompatButton2;
    private ViewGroup root;
    private Scene scene1;
    private Scene scene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_scenes);
        root = (ViewGroup) findViewById(R.id.transition_scenes_root);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            scene1 = Scene.getSceneForLayout(root, R.layout.activity_transition_scenes, this);
            scene2 = Scene.getSceneForLayout(root, R.layout.activity_transition_scenes2, this);
        }
    }


    public void goToScene2(View v) {
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                   Transition transition = TransitionInflater.from(this)
                           .inflateTransition(R.transition.transition_to_scene_two);
                   TransitionManager.go(scene2, transition);
               }

    }

    public void goToScene1(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.go(scene1);
        }
    }
}
