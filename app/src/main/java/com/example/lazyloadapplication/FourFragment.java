package com.example.lazyloadapplication;

import android.util.Log;

/**
 * Created by liuyuan on 2016/10/20 0020.
 */
public class FourFragment extends BaseFragment {
    @Override
    protected void getDataFromServer() {
        Log.e(TAG, "getDataFromServer");
    }

    @Override
    public String setTitle() {
        return TAG;
    }
}
