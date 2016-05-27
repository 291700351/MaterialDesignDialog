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
package com.lb.materialdesigndialog.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lb.dialog.R;
import com.lb.materialdesigndialog.base.DialogWithTitle;
import com.lb.utils.ViewUtil;

/**
 * 项目名称：MaterialDesignDialog
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/27 17:40
 * 类描述：项目提供的默认的Dialog显示，显示一个正常的Dialog
 */
public class MaterialDialogNormal extends DialogWithTitle {

    //===Desc:成员变量======================================================================================

    /**
     * 正文部分显示的View
     */
    private View contextView;

    private TextView tv_normal_message;//消息部分

    //===Desc:构造函数======================================================================================
    public MaterialDialogNormal(Context context) {
        super(context);
    }

    //===Desc:复写父类中的方法======================================================================================
    @Override
    protected View initContent() {
        contextView = LayoutInflater.from(context).inflate(R.layout.layout_dialog_normal, null, false);

        findView();

        return contextView;
    }

    //===Desc:本类中使用的方法======================================================================================

    /**
     * 初始化界面中的控件
     */
    private void findView() {
        tv_normal_message = ViewUtil.findViewById(contextView, R.id.tv_normal_message);
    }

    //===Desc:提供给外界使用的方法==========================================================================================

    /**
     * 设置正文部分的msg内容
     *
     * @param msg 需要显示的msg内容
     */
    public void setMessage(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            tv_normal_message.setText(msg);
        }
    }

}
