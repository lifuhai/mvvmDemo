package com.lfh.frame.base;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.lfh.frame.R;
import com.lfh.frame.preview.VaryViewHelper;
import com.lfh.frame.widget.LoadingDialog;
import com.zackratos.ultimatebarx.library.UltimateBarX;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * @author: lfh
 * @date: 2022/1/6
 * @note: BaseActivity
 */
public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    /**
     *   视图切换
     */
    public VaryViewHelper mVaryViewHelper;
    public T inflate;
    /**
     *   loading
     */
    public LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Method method = cls.getDeclaredMethod("inflate", LayoutInflater.class);
            inflate = (T) method.invoke(null, getLayoutInflater());
            setContentView(inflate.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
        UltimateBarX.with(this)
                .color(Color.WHITE)
                .light(true)
                .applyStatusBar();
    }

    protected abstract void initView();

    protected abstract void initData();


    /**
     *   初始化loading 弹窗
     * @param text
     */
    protected void initLoading(String text) {
        mLoadingDialog = new LoadingDialog(this);
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

    public void hold(int id) {

        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(findViewById(id))//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(this).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(this).inflate(R.layout.layout_errorview, null))//错误页面
                .build();
        mVaryViewHelper.mErrorView.findViewById(R.id.vv_error_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVaryViewHelper != null) {
            mVaryViewHelper.releaseVaryView();
        }

    }
}
