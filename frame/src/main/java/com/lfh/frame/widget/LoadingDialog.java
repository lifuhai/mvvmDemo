package com.lfh.frame.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.lfh.frame.R;


/**
 * 类描述：自定义dialog，提供show down方法，以及是否正在显示dialog
 */
public class LoadingDialog {

    //上下文环境
    private Context mContext;
    //对话框视图
    private View mDialogView;
    //对话框对象
    private Dialog mDialog;
    //对话框显示的文字信息
    private TextView mDialogText;

    /**
     * 构造函数
     *
     * @param context 上下文环境
     */
    public LoadingDialog(Context context) {
        this.mContext = context;
        //添加dialog_loading布局
        mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        //实例化Dialog的文字
        mDialogText = (TextView) mDialogView.findViewById(R.id.tv_msg);
        // 初始化Dialog
        initDialog();
    }

    /*
    * 初始化Dialog
    * */
    private void initDialog() {
        mDialog = new Dialog(mContext, R.style.dialog);
        mDialog.setContentView(mDialogView);
        //点击对话框外面能够取消
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.getWindow().clearFlags( WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }

    /**
     * 设置Dialog的文字
     *
     * @param dialogText dialog文本
     */
    public void setDialogText(CharSequence dialogText) {
        mDialogView.findViewById(R.id.tv_msg).setVisibility(View.VISIBLE);
        mDialogText.setText(dialogText);
    }

    /*
    * 重载setDialogText
    * */
    public void setDialogText(int dialogText) {
        mDialogView.findViewById(R.id.tv_msg).setVisibility(View.VISIBLE);
        mDialogText.setText(dialogText);
    }

    /*
    * 显示Dialog
    * */
    public void showDialog() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    /*
   * 关闭Dialog
   * */
    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    /*
    * 判断dialog是否正在显示
    * */
    public boolean isShowing() {
        return mDialog.isShowing();
    }
}
