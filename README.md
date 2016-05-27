#Material Design风格的Dialog
*把Material Design风格的Dialog兼容到API8*
![](https://github.com/291700351/MaterialDesignDialog/blob/master/images/device-2016-05-27-231818.png)![](https://github.com/291700351/MaterialDesignDialog/blob/master/images/device-2016-05-27-231925.png)

###默认提供MaterialDialogNormal和MaterialDialogInput两个类型的Dialog，后期会陆续增加更多类型###

- MaterialDialogNormal：*显示一个提醒的Dialog*

    - 通过setTitle和setIcon可以设置Dialog的图标显示和标题文本

            dialog.setIcon(R.mipmap.ic_launcher);//设置图标，不设置就不显示图标
            dialog.setTitle("Material Design");//设置Dialog的标题
    - 通过 dialog.setMessage()方法，可以设置Dialog提醒的文本内容
            
            dialog.setMessage(msg);

- MaterialDialogInput：*显示一个带输入框的Dialog*

        getUserInput();//获取用户输入内容
        setEditTextHintText();//设置EditText的提示内容
        setEditTextInputType();//设置EditText的输入内容的类型，可以输入密码，电话。。。
        getEditText();//获取输入框对象，可以用于用户输入之后做动画提醒和用户交互等
        
        
## 可以继承DialogBase基类和DialogWithTitle来扩展更多的布局形式##
- DialogBase是Material Design风格的Dialog的最基类，其主体分为三个部分
    - title部分：主要是负责Dialog的标题部分的布局
    - content部分：主要负责Dialog正文显示部分的布局
    - bottom部分：负责底部按钮部分的布局
    继承之后实现 initTitle()、initContent()、initBottom()三个方法，给三个部分填充不同的布局
    
- DialogWithTitle是一个继承自DialogBase的子类，该类已经实现了父类的initTitle()、initBottom()两个方法，已经默认添加了Dialog的标题部分和底部按钮部分
    - 子类继承DialogWithTitle，只需实现initContent()方法，加载一个正文部分的布局就能显示Dialog
    - 默认提供的MaterialDialogNormal和MaterialDialogInput两种Dialog继承自DialogWithTitle