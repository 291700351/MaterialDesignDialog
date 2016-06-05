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
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lb.dialog.R;
import com.lb.materialdesigndialog.base.DialogBase;
import com.lb.utils.ViewUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目名称：ysp-android<br>
 * 作者：IceLee<br>
 * 邮箱：lb291700351@live.cn<br>
 * 时间：2016/6/4 10:51<br>
 * 类描述：加载中的Dialog<br>
 */
public class MaterialDialogLoading extends DialogBase {
    private static final int UPDATE_TEXT = 0;//修改文本，handle发送消息使用
    private Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    String desc = (String) msg.obj;
                    tv_dialog_desc.setText(desc);
                    break;
            }

        }
    };
    //===Desc:成员变量===============================================================================
    /**
     * 加载布局使用
     */
    private LayoutInflater inflater;

    /**
     * 显示在界面上的View对象
     */
    private View contentView;

    private TextView tv_dialog_desc;//文本显示控件

    private String loadingText;//显示的文本

    //===Desc:构造函数===============================================================================================
    public MaterialDialogLoading(Context context) {
        super(context);
    }

    //===Desc:复写父类中的方法===============================================================================
    @Override
    protected View initTitle() {
        return null;
    }

    @Override
    protected View initContent() {
        if (null == inflater) inflater = LayoutInflater.from(context);

        contentView = inflater.inflate(R.layout.layout_dialog_loading, null, false);

        findView();

        setData();

        return contentView;
    }

    @Override
    protected View initBottom() {
        return null;
    }
    //===Desc:本类中使用的方法===============================================================================

    /**
     * 初始化界面控件
     */
    private void findView() {
        tv_dialog_desc = ViewUtil.findViewById(contentView, R.id.tv_dialog_desc);
    }

    /**
     * 设置数据
     */
    private void setData() {
        setText(context.getResources().getString(R.string.txt_dialog_loading));
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int count = 0;
                String desc = loadingText;
                while (true) {
                    if (TextUtils.isEmpty(loadingText)) break;
                    if (!isShowing()) break;
                    if (count++ < 10) {
                        desc += " . ";
                    } else {
                        desc = loadingText;
                        count = 0;
                    }
                    Message msg = Message.obtain();
                    msg.what = UPDATE_TEXT;
                    msg.obj = desc;
                    handle.sendMessage(msg);
                    SystemClock.sleep(500);
                }
            }
        };
        timer.schedule(task, 0);
    }

    //===Desc:提供给外界调用的方法===============================================================================================

    /**
     * 设置加载中的文字
     *
     * @param text 加载中的文字
     */
    public void setText(CharSequence text) {
        tv_dialog_desc.setText(text);
        loadingText = text.toString();
    }

}
