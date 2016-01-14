package com.example.fsantana.meaningfulmotion.Beans;

/**
 * Created by fsantana on 11/01/16.
 */
public class Person {
    int mAvatar;
    String mTitle;
    String mSubtitle;

    public Person(String title, String subtitle, int avatar) {
        mAvatar = avatar;
        mTitle = title;
        mSubtitle = subtitle;
    }

    public int getmAvatar() {
        return mAvatar;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    public String getmTitle() {
        return mTitle;
    }
}
