package com.lb.materialdesigndialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.lb.materialdesigndialog.base.DialogBase;
import com.lb.materialdesigndialog.base.DialogWithTile;
import com.lb.materialdesigndialog.impl.MaterialDialogInput;
import com.lb.materialdesigndialog.impl.MaterialDialogNormal;
import com.lb.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        final MaterialDialogInput dialog = new MaterialDialogInput(this);
        dialog.setTitle("Material Design");
//        dialog.setMessage(
//                "谷歌推出了全新的设计语言Material Design。谷歌表示，这种设计语言旨在为手机、平板电脑、台式机和“其他平台”提供更一致、更广泛的“外观和感觉”。");

        dialog.setDesc("请输入信息");

        dialog.setNegativeButton("取消", new DialogWithTile.OnClickListener() {
            @Override
            public void click(DialogBase dialog, View view) {
                showToast("点击取消");
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("确定", new DialogWithTile.OnClickListener() {
            @Override
            public void click(DialogBase d, View view) {
                showToast(dialog.getUserInput());
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
