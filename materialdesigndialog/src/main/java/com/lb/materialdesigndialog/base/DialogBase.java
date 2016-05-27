//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
package com.lb.materialdesigndialog.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.lb.dialog.R;
import com.lb.utils.ViewUtil;

/**
 * 项目名称：MaterialDesignDialog
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/27 13:24
 * 类描述：Material Design风格的对话框的基类，由此基类派生出另外两个基类
 */
public abstract class DialogBase {

    //===Desc:成员变量==========================================================================================

    protected Context context;//上下文对象

    private AlertDialog dialog;//基于AlertDialog真正显示在界面上的Dialog

    protected FrameLayout fl_base_title;//title部分
    protected FrameLayout fl_base_content;//正文部分
    protected FrameLayout fl_base_bottom;//底部

    //===Desc:构造函数==========================================================================================

    public DialogBase(Context context) {
        this.context = context;
        initView();
    }

    //===Desc:本类中使用的方法==========================================================================================

    /**
     * 进行初始化的操作
     */
    private void initView() {
        //显示Dialog
        dialog = new AlertDialog.Builder(context).create();
        dialog.setCancelable(true);
        dialog.show();
        dialog.getWindow()
                .clearFlags(
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow()
                .setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_MASK_STATE);

        //设置Material Design风格的背景
        Window window = dialog.getWindow();
        View rootView = LayoutInflater.from(context).inflate(R.layout.dialog_base, null, false);
        window.setContentView(rootView);

        //初始化title部分
        fl_base_title = ViewUtil.findViewById(rootView, R.id.fl_base_title);
        View titleView = initTitle();
        if (null == titleView) {
            fl_base_title.setVisibility(View.GONE);
            fl_base_title.removeAllViews();
        } else {
            fl_base_title.setVisibility(View.VISIBLE);
            fl_base_title.addView(titleView);
        }

        //初始化正文部分
        fl_base_content = ViewUtil.findViewById(rootView, R.id.fl_base_content);
        View contentView = initContent();
        if (null == contentView)
            throw new UnsupportedOperationException("The dialog must show a view in the window!");
        else
            fl_base_content.addView(contentView);

        //初始化底部
        fl_base_bottom = ViewUtil.findViewById(rootView, R.id.fl_base_bottom);
        View bottomView = initBottom();
        if (null == bottomView)
            fl_base_bottom.setVisibility(View.GONE);
        else
            fl_base_bottom.addView(bottomView);
    }


    /**
     * 子类必须实现该方法用于显示在界面上的Dialog的Title部分
     *
     * @return title部分的显示的View，返回的titleView为null的话，Dialog将不显示title部分
     */
    protected abstract View initTitle();

    /**
     * 子类必须实现该方法用于显示在界面上的正文部分控件
     *
     * @return content部分显示的内容，如果返回null，将会抛出异常
     */
    protected abstract View initContent();

    /**
     * 子类实现该方法用于显示底部的view
     *
     * @return bottom部分显示的view，如果返回null，bottom部分将不显示
     */
    protected abstract View initBottom();


    //===Desc:提供给外界使用的方法==========================================================================================


    /**
     * 设置点击Dialog以为是否关闭Dialog
     *
     * @param flag true：可以关闭。false：不可以关闭
     */
    public void setCancelable(boolean flag) {
        dialog.setCancelable(flag);
    }

    /**
     * 显示这个Dialog
     */
    public void show() {
        if (!dialog.isShowing())
            dialog.show();
    }

    /**
     * 关闭当前的Dialog
     */
    public void dismiss() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /**
     * 给当前Dialog设置关闭之后的回调监听
     *
     * @param listener OnDialogDismissListener回调监听
     */
    public void setOnDialogDismissListener(DialogInterface.OnDismissListener listener) {
        dialog.setOnDismissListener(listener);
    }


}
