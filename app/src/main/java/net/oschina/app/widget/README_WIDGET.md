# widget

View有三个构造方法

    1.public View(Context context)
    2.public View(Context context, AttributeSet attrs)
    3.public View(Context context, AttributeSet attrs, int defStyle)
　　要在布局中使用自定义控件，控件必须实现带参数AttributeSet的构造方法，实例化布局的时候会调用这个方法去实例化控件，否则就会报你图上的错误
　　另外引用自定义控件的时候必须用包名.类名的方式，否则也会报错