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

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lb.utils.DrawableUtil;
import com.lb.utils.LogUtil;
import com.lb.utils.Screenutil;
import com.lb.utils.SelectorUtil;

/**
 * 项目名称：MaterialDesignDialog
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/27 14:42
 * 类描述：Material Design风格的对话框,具有标题，继承自该类可以扩展正文部分显示
 */
public abstract class DialogWithTitle extends DialogBase {
    //===Desc:成员变量======================================================================================
    private ImageView iv_title;//title的图片

    private TextView tv_dialog_title;//title文本控件

    private TextView btn_m;//中性按钮

    private TextView btn_n;//消极按钮

    private TextView btn_p;//积极的按钮

    //===Desc:构造函数======================================================================================
    public DialogWithTitle(Context context) {
        super(context);
    }

    //===Desc:复写父类中的方法======================================================================================
    @Override
    protected View initTitle() {
        LinearLayout titleRoot = new LinearLayout(context);
        //设置宽高
        titleRoot.setLayoutParams(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        titleRoot.setOrientation(LinearLayout.HORIZONTAL);
        titleRoot.setGravity(Gravity.CENTER_VERTICAL);
        //初始化title图片
        iv_title = new ImageView(context);
//        标题部分图片宽高是40dp*40dp
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Screenutil.dp2px(context, 40), Screenutil.dp2px(context, 40));
        params.rightMargin = Screenutil.dp2px(context, 16);
        iv_title.setLayoutParams(params);
        titleRoot.addView(iv_title);
        iv_title.setVisibility(View.GONE);
        //初始化标题
        tv_dialog_title = new TextView(context);
        tv_dialog_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        tv_dialog_title.setTextColor(Color.parseColor("#DE000000"));
        LinearLayout.LayoutParams txtParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv_dialog_title.setLayoutParams(txtParams);
        titleRoot.addView(tv_dialog_title);

        return titleRoot;
    }

    @Override
    protected View initBottom() {
        LinearLayout bottomRoot = new LinearLayout(context);
        //设置宽高
        bottomRoot.setLayoutParams(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bottomRoot.setOrientation(LinearLayout.HORIZONTAL);
        //初始化中性按钮
        initBtn(btn_m = new TextView(context), bottomRoot);
        //中间占位的View
        View view = new View(context);
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        viewParams.weight = 1;
        view.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        view.setLayoutParams(viewParams);
        bottomRoot.addView(view);
        //初始化消极的按钮
        initBtn(btn_n = new TextView(context), bottomRoot);
        //初始化积极按钮
        initBtn(btn_p = new TextView(context), bottomRoot);

        LogUtil.e(this, "btn_m" + (btn_m == null));
        checkBottom();
        return bottomRoot;
    }

    //===Desc:本类中使用的方法======================================================================================

    private void initBtn(TextView btn, LinearLayout parent) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btn.setPadding(Screenutil.dp2px(context, 16), Screenutil.dp2px(context, 8),
                Screenutil.dp2px(context, 16), Screenutil.dp2px(context, 8));
        btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        btn.setTextColor(Color.parseColor("#FF239FF2"));

        float radius = Screenutil.dp2px(context, 2);
        GradientDrawable normal = DrawableUtil.createRectangleDrawable(Color.parseColor("#FFFFFFFF"), radius, radius, radius, radius);
        GradientDrawable pressed = DrawableUtil.createRectangleDrawable(Color.parseColor("#FFF0F0F0"), radius, radius, radius, radius);
        StateListDrawable selector = SelectorUtil.createPressedSelector(normal, pressed);
        btn.setBackgroundDrawable(selector);
        parent.addView(btn, params);
    }

    /**
     * 检测底部按钮是否显示，如果底部三个按钮的文本都是空，就将底部隐藏
     */
    private void checkBottom() {
        if (TextUtils.isEmpty(btn_m.getText().toString().trim())
                && TextUtils.isEmpty(btn_n.getText().toString().trim())
                && TextUtils.isEmpty(btn_p.getText().toString().trim())) {
            fl_base_bottom.setVisibility(View.GONE);
        } else {
            fl_base_bottom.setVisibility(View.VISIBLE);
        }

    }


    //===Desc:提供给外计时用的方法==========================================================================================

    /**
     * 设置title部分的Icon
     *
     * @param drawable title需要显示的图片
     */
    public void setIcon(Drawable drawable) {
        iv_title.setVisibility(View.VISIBLE);
        iv_title.setImageDrawable(drawable);
    }

    /**
     * 设置title部分的图片，使用资源文件id
     *
     * @param drawableId 图片资源文件的Id
     */
    public void setIcon(@DrawableRes int drawableId) {
        iv_title.setVisibility(View.VISIBLE);
        iv_title.setBackgroundResource(drawableId);
    }

    /**
     * 给Dialog设置标题显示，如果title是空，就隐藏title
     *
     * @param title 需要显示title
     */
    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            fl_base_title.setVisibility(View.GONE);
        } else {
            tv_dialog_title.setText(title);
            fl_base_title.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 设置中性按钮，如果按钮的文本是null，这按钮不显示
     *
     * @param text     按钮文本
     * @param listener 按钮的点击事件处理
     */
    public void setNeutralButton(String text, final OnClickListener listener) {
        if (TextUtils.isEmpty(text)) {
            btn_m.setVisibility(View.INVISIBLE);
        } else {
            btn_m.setText(text);
            if (null != listener) {
                btn_m.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.click(DialogWithTitle.this, v);
                    }
                });
            }
        }
        checkBottom();
    }

    /**
     * 设置消极按钮，如果按钮的文本是null，这按钮不显示
     *
     * @param text     按钮文本
     * @param listener 按钮的点击事件处理
     */
    public void setNegativeButton(String text, final OnClickListener listener) {
        if (TextUtils.isEmpty(text)) {
            btn_n.setVisibility(View.INVISIBLE);
        } else {
            btn_n.setText(text);
            if (null != listener) {
                btn_n.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.click(DialogWithTitle.this, v);
                    }
                });
            }
        }
        checkBottom();
    }

    /**
     * 设置积极按钮
     *
     * @param text     按钮文本内容
     * @param listener 点击事件
     */
    public void setPositiveButton(String text, final OnClickListener listener) {
        if (TextUtils.isEmpty(text)) {
            btn_p.setVisibility(View.INVISIBLE);
        } else {
            btn_p.setText(text);
            if (null != listener) {
                btn_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.click(DialogWithTitle.this, v);
                    }
                });
            }
        }
        checkBottom();
    }

    /**
     * Dialog中按钮的点击事件的回调接口
     */
    public interface OnClickListener {
        /**
         * 点击事件处理
         *
         * @param dialog 控件所依附的Dialog
         * @param view   当前点击的控件
         */
        void click(DialogBase dialog, View view);
    }

}
