package com.lfh.frame.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.lfh.frame.R;
import com.lfh.frame.preview.VaryViewHelper;
import com.lfh.frame.widget.LoadingDialog;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * basefragment    抽象类
 */
public abstract class BaseFragment<T extends ViewBinding> extends Fragment {

    public VaryViewHelper mVaryViewHelper;
    protected T binding;
    /**
     *   loading
     */
    public LoadingDialog mLoadingDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Type superclass = getClass().getGenericSuperclass();
        Class<?> aClass = (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
        try {
            Method method = aClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            binding = (T) method.invoke(null, getLayoutInflater(), container, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    protected abstract void initView() ;


    protected abstract void initData();


    public void hold(int id) {
        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(binding.getRoot().findViewById(id))//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_errorview, null))//错误页面
                .build();
        mVaryViewHelper.mErrorView.findViewById(R.id.vv_error_refresh)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initData();
                    }
                });
    }


    /**
     *   初始化loading 弹窗
     * @param text
     */
    protected void initLoading(String text) {
        mLoadingDialog = new LoadingDialog(getActivity());
        if (TextUtils.isEmpty(text) ) {
            mLoadingDialog.setDialogText("加载中...");
        }else {
            mLoadingDialog.setDialogText(text);
        }
        mLoadingDialog.showDialog();
    }

    /**
     *  取消弹窗
     */
    protected void cancelLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mVaryViewHelper != null) {
            mVaryViewHelper.releaseVaryView();
        }

    }
}
