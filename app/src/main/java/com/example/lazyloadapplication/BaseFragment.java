package com.example.lazyloadapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by liuyuan on 2016/10/20 0020.
 */
public abstract class BaseFragment extends Fragment {
    protected TextView mTvTitle;
    protected String TAG=getClass().getSimpleName();
    protected boolean isVisible;
    protected boolean isPrepared;
    protected boolean isFirst=true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       if(isVisibleToUser){
           isVisible=true;
           loadData();
       }else{
           isVisible=false;
       }
    }

    protected  void loadData(){
        if(isVisible&&isPrepared&&isFirst){
            Log.e(TAG,"loadData准备好了");
            isFirst=false;//其实应该在请求网络成功拉取json数据成功之后才置为false
            getDataFromServer();
        }else{
            Log.e(TAG,"loadData没有准备好:isVisible="+isVisible+"==isPrepared="+isPrepared+"是否是第一次拉取数据："+isFirst);
        }
    }

    protected abstract void getDataFromServer();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mTvTitle==null){
            mTvTitle=new TextView(getActivity());
        }
        return mTvTitle;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared=true;
        if(mTvTitle!=null){
            mTvTitle.setText(setTitle());
        }
        loadData();
    }

    public abstract String setTitle();
}
