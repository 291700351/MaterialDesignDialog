package com.lb.materialdesigndialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lb.materialdesigndialog.base.DialogBase;
import com.lb.materialdesigndialog.base.DialogWithTitle;
import com.lb.materialdesigndialog.impl.MaterialDialogInput;
import com.lb.materialdesigndialog.impl.MaterialDialogNormal;
import com.lb.utils.ToastUtil;
import com.lb.utils.ViewUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //===Desc:成员变量===============================================================================================
    private Button btn_normal;//显示一个提醒Dialog的按钮
    private Button btn_input;//显示一个带输入框的dialog按钮的

    //===Desc:复写父类的方法===============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        setListener();


    }

    //===Desc:本类使用的方法===============================================================================================

    /**
     * 初始化界面中的控件
     */
    private void findView() {
        btn_normal = ViewUtil.findViewById(this, R.id.btn_normal);
        btn_input = ViewUtil.findViewById(this, R.id.btn_input);
    }

    /**
     * 给界面中的控件设置监听
     */
    private void setListener() {
        btn_normal.setOnClickListener(this);
        btn_input.setOnClickListener(this);
    }

    //===Desc:点击事件的处理===============================================================================================
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                showNormalDialog();
                break;
            case R.id.btn_input:
                showInputDialog();
                break;

        }

    }

    /**
     * 显示一个提醒对话框
     */
    private void showNormalDialog() {
        MaterialDialogNormal dialog = new MaterialDialogNormal(this);
        dialog.setTitle("Material Design");
        dialog.setMessage(
                "谷歌推出了全新的设计语言Material Design。谷歌表示，这种设计语言旨在为手机、平板电脑、台式机和“其他平台”提供更一致、更广泛的“外观和感觉”。");

        dialog.setNegativeButton("取消", new DialogWithTitle.OnClickListener() {
            @Override
            public void click(DialogBase dialog, View view) {
                showToast("点击取消");
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("确定", new DialogWithTitle.OnClickListener() {
            @Override
            public void click(DialogBase dialog, View view) {
                showToast("点击确定");
                dialog.dismiss();
            }
        });
    }

    /**
     * 显示一个带输入框的Dialog
     */
    private void showInputDialog() {
        final MaterialDialogInput dialog = new MaterialDialogInput(this);

        dialog.setIcon(R.mipmap.ic_launcher);//设置图标

        dialog.setTitle("Material Design Input");

        dialog.setDesc("请输入信息");

        dialog.setNeutralButton("获取用户输入", new DialogWithTitle.OnClickListener() {
            @Override
            public void click(DialogBase d, View view) {
                String userInput = dialog.getUserInput();
                showToast(userInput);
            }
        });

        dialog.setNegativeButton("取消", new DialogWithTitle.OnClickListener() {
            @Override
            public void click(DialogBase dialog, View view) {
                showToast("取消");
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("确定", new DialogWithTitle.OnClickListener() {
            @Override
            public void click(DialogBase dialog, View view) {
                dialog.dismiss();
            }
        });


    }


    /**
     * 显示一个Toast
     *
     * @param text 显示的文本
     */
    private void showToast(String text) {
        ToastUtil.showShortToast(this, text);
    }


}
