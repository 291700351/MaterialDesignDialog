//   _ooOoo_
//  o8888888o
//  88" . "88
//  (| -_- |)
//   O\ = /O
//       ____/`---'\____
//     .   ' \\| |// `.
//      / \\||| : |||// \
//    / _||||| -:- |||||- \
//      | | \\\ - /// | |
//    | \_| ''\---/'' | |
//     \ .-\__ `-` ___/-. /
//  ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//\ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//   `=---='
//
//         .............................................
// 佛祖镇楼 BUG辟易
//          佛曰:
// 写字楼里写字间，写字间里程序员；
// 程序人员写程序，又拿程序换酒钱。
// 酒醒只在网上坐，酒醉还来网下眠；
// 酒醉酒醒日复日，网上网下年复年。
// 但愿老死电脑间，不愿鞠躬老板前；
// 奔驰宝马贵者趣，公交自行程序员。
// 别人笑我忒疯癫，我笑自己命太贱；
// 不见满街漂亮妹，哪个归得程序员？
package com.lb.materialdesigndialog.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lb.dialog.R;
import com.lb.materialdesigndialog.base.DialogWithTile;
import com.lb.utils.ViewUtil;

/**
 * 项目名称：MaterialDesignDialog
 * 作者：lb291
 * 邮箱： lb291700351@live.cn
 * 时间：2016/5/27 18:16
 * 类描述：有输入框的Dialog
 */
public class MaterialDialogInput extends DialogWithTile {

    //===Desc:成员变量======================================================================================

    private View contextView;

    private TextView tv_dialog_desc;

    private EditText et_dialog_input;

    //===Desc:构造函数======================================================================================

    public MaterialDialogInput(Context context) {
        super(context);
    }

    //===Desc:复写父类中的方法======================================================================================
    @Override
    protected View initContent() {
        contextView = LayoutInflater.from(context).inflate(R.layout.layout_dialog_input, null, false);

        findView();

        return contextView;
    }

    //===Desc:本类中使用的方法======================================================================================

    /**
     * 初始化界面中的控件
     */
    private void findView() {
        tv_dialog_desc = ViewUtil.findViewById(contextView, R.id.tv_dialog_desc);

        et_dialog_input = ViewUtil.findViewById(contextView, R.id.et_dialog_input);
    }

    //===Desc:提供外界使用的方法==========================================================================================

    /**
     * 设置描述信息
     *
     * @param desc 描述信息文本
     */
    public void setDesc(String desc) {
        if (TextUtils.isEmpty(desc)) {
            tv_dialog_desc.setVisibility(View.GONE);
        } else {
            tv_dialog_desc.setText(desc);
        }
    }

    /**
     * 获取输入框输入的数据
     *
     * @return 输入框输入的数据
     */
    public String getUserInput() {
        return et_dialog_input.getText().toString().trim();
    }

    /**
     * 设置输入框的提示信息
     *
     * @param hint 要显示的提示信息
     */
    public void setEditTextHintText(String hint) {
        et_dialog_input.setHint(hint);
    }

    /**
     * 设置文本框输入类型
     *
     * @param type 输入类型，取值范围参看下面<br/><pre>
     *                                     Constant     Value     Description<br/>
     *                                     <br/>
     *                                     none     0x00000000     There is no content type. The text is not editable.<br/>
     *                                     <br/>
     *                                     text     0x00000001     Just plain old text. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_NORMAL.<br/>
     *                                     <br/>
     *                                     textCapCharacters     0x00001001     Can be combined with text and its variations to request capitalization of all characters. Corresponds to TYPE_TEXT_FLAG_CAP_CHARACTERS.<br/>
     *                                     <br/>
     *                                     textCapWords     0x00002001     Can be combined with text and its variations to request capitalization of the first character of every word. Corresponds to TYPE_TEXT_FLAG_CAP_WORDS.<br/>
     *                                     <br/>
     *                                     textCapSentences     0x00004001     Can be combined with text and its variations to  request capitalization of the first character of every sentence. Corresponds to TYPE_TEXT_FLAG_CAP_SENTENCES.<br/>
     *                                     <br/>
     *                                     textAutoCorrect     0x00008001     Can be combined with text and its variations to request auto-correction of text being input. Corresponds to TYPE_TEXT_FLAG_AUTO_CORRECT.<br/>
     *                                     <br/>
     *                                     textAutoComplete     0x00010001     Can be combined with text and its variations to specify that this field will be doing its own auto-completion and talking with the input method appropriately. Corresponds to TYPE_TEXT_FLAG_AUTO_COMPLETE.<br/>
     *                                     <br/>
     *                                     textMultiLine     0x00020001     Can be combined with text and its variations to allow multiple lines of text in the field. If this flag is not set, the text field will be constrained to a single line. Corresponds to TYPE_TEXT_FLAG_MULTI_LINE.<br/>
     *                                     <br/>
     *                                     textImeMultiLine     0x00040001     Can be combined with text and its variations to indicate that though the regular text view should not be multiple lines, the IME should provide multiple lines if it can. Corresponds to TYPE_TEXT_FLAG_IME_MULTI_LINE.<br/>
     *                                     <br/>
     *                                     textNoSuggestions     0x00080001     Can be combined with text and its variations to indicate that the IME should not show any dictionary-based word suggestions. Corresponds to TYPE_TEXT_FLAG_NO_SUGGESTIONS.<br/>
     *                                     <br/>
     *                                     textUri     0x00000011     Text that will be used as a URI. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_URI.<br/>
     *                                     <br/>
     *                                     textEmailAddress     0x00000021     Text that will be used as an e-mail address. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_ADDRESS.<br/>
     *                                     <br/>
     *                                     textEmailSubject     0x00000031     Text that is being supplied as the subject of an e-mail. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_EMAIL_SUBJECT.<br/>
     *                                     <br/>
     *                                     textShortMessage     0x00000041     Text that is the content of a short message. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_SHORT_MESSAGE.<br/>
     *                                     <br/>
     *                                     textLongMessage     0x00000051     Text that is the content of a long message. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_LONG_MESSAGE.<br/>
     *                                     <br/>
     *                                     textPersonName     0x00000061     Text that is the name of a person. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME.<br/>
     *                                     <br/>
     *                                     textPostalAddress     0x00000071     Text that is being supplied as a postal mailing address. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS.<br/>
     *                                     <br/>
     *                                     textPassword     0x00000081     Text that is a password. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD.<br/>
     *                                     <br/>
     *                                     textVisiblePassword     0x00000091     Text that is a password that should be visible. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_VISIBLE_PASSWORD.<br/>
     *                                     <br/>
     *                                     textWebEditText     0x000000a1     Text that is being supplied as text in a web form. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_WEB_EDIT_TEXT.<br/>
     *                                     <br/>
     *                                     textFilter     0x000000b1     Text that is filtering some other data. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_FILTER.<br/>
     *                                     <br/>
     *                                     textPhonetic     0x000000c1     Text that is for phonetic pronunciation, such as a phonetic name field in a contact entry. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PHONETIC.<br/>
     *                                     <br/>
     *                                     textWebEmailAddress     0x000000d1     Text that will be used as an e-mail address on a web form. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS.<br/>
     *                                     <br/>
     *                                     textWebPassword     0x000000e1     Text that will be used as a password on a web form. Corresponds to TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_WEB_PASSWORD.<br/>
     *                                     <br/>
     *                                     number     0x00000002     A numeric only field. Corresponds to TYPE_CLASS_NUMBER | TYPE_NUMBER_VARIATION_NORMAL.<br/>
     *                                     <br/>
     *                                     numberSigned     0x00001002     Can be combined with number and its other options to allow a signed number. Corresponds to TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_SIGNED.<br/>
     *                                     <br/>
     *                                     numberDecimal     0x00002002     Can be combined with number and its other options to allow a decimal (fractional) number. Corresponds to TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL.<br/>
     *                                     <br/>
     *                                     numberPassword     0x00000012     A numeric password field. Corresponds to TYPE_CLASS_NUMBER | TYPE_NUMBER_VARIATION_PASSWORD.<br/>
     *                                     <br/>
     *                                     phone     0x00000003     For entering a phone number. Corresponds to TYPE_CLASS_PHONE.<br/>
     *                                     <br/>
     *                                     datetime     0x00000004     For entering a date and time. Corresponds to TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_NORMAL.<br/>
     *                                     <br/>
     *                                     date     0x00000014     For entering a date. Corresponds to TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_DATE.<br/>
     *                                     <br/>
     *                                     time     0x00000024     For entering a time. Corresponds to TYPE_CLASS_DATETIME | TYPE_DATETIME_VARIATION_TIME.
     *                                     </pre>
     */
    public void setEditTextInputType(int type) {
        et_dialog_input.setInputType(type);
    }

}
