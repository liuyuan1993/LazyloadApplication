package com.example.lazyloadapplication;

import android.util.Log;

/**
 * Created by liuyuan on 2016/10/20 0020.
 */
public class ThirdFragment extends BaseFragment {

    @Override
    public String setTitle() {
        return TAG;
    }

    @Override
    protected void getDataFromServer() {
        Log.e(TAG, "getDataFromServer");
    }
}
