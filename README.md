# 更新内容
- 更新control_type的类型为枚举类型
- 修改control_textsize的大小，推荐使用SP
# TopBar
包含3个控件（左中右），其中中间为TextView，左右两个控件可以是ImageView或TextView
## 属性介绍
#### topbar_left_control_type和topbar_right_control_type（必要属性）
左右两个控件的类型，判断该控件为ImageView还是TextView。**这个属性使用imageview和textview两个枚举值**
```
<attr name="topbar_left_control_type">
        <enum name="imageview" value="100" />
        <enum name="textview" value="101" />
</attr>
<attr name="topbar_right_control_type" >
    <enum name="imageview" value="200"/>
    <enum name="textview" value="201"/>
</attr>
```
#### topbar_left_control_src和topbar_right_control_src
当topbar_left_control_type和topbar_right_control_type和topbar_left_control_type和topbar_right_control_type为imgview的时候，才能生效。
```
<attr name="topbar_left_control_src" format="reference" />
<attr name="topbar_right_control_src" format="reference" />
```
####topbar_left_control_text和topbar_right_control_textcolor
和TextView的andorid:text一样
```
<attr name="topbar_left_control_text" format="string|reference" />
<attr name="topbar_right_control_text" format="string|reference" />
```
#### topbar_left_control_textsize和topbar_right_control_textsize
和TextVIew的textSize一样，**推荐使用sp的单位**
```
<attr name="topbar_left_control_textsize" format="dimension" />
<attr name="topbar_right_control_textsize" format="dimension" />
```
#### 左右控件的点击事件
```
  topBar= (TopBar) findViewById(R.id.topbar);
        topBar.setOnClickLisnter(new TopBar.CtrolClickLisnter() {
            @Override
            public void leftClickLisnter() {
                Toast.makeText(MainActivity.this,"11111",1000).show();
            }

            @Override
            public void rightClickListener() {
                Toast.makeText(MainActivity.this,"2222",1000).show();

            }
        });
```

最后列出所有属性
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="topbar_layout">
        <!--左面控件的类型-->
        <attr name="topbar_left_control_type">
            <enum name="imageview" value="100" />
            <enum name="textview" value="101" />
        </attr>
        <attr name="topbar_left_control_widht" format="dimension" />
        <attr name="topbar_left_control_height" format="dimension" />

        <!--左面的控件为文字-->
        <attr name="topbar_left_control_text" format="string|reference" />
        <!--左面的控件的背景颜色-->
        <attr name="topbar_left_control_bgcolor" format="color|reference" />
        <!--左面的控件的文字大小-->
        <attr name="topbar_left_control_textsize" format="dimension" />
        <!--左面的控件的文字颜色-->
        <attr name="topbar_left_control_textcolor" format="color|reference" />
        <!--end 左面的控件为文字-->

        <!--左面的控件为ImageView-->
        <!--左间控件的src-->
        <attr name="topbar_left_control_src" format="reference" />
        <!--end 左面的控件为ImageView-->

        <!--右面控件的类型-->
        <attr name="topbar_right_control_type" >
            <enum name="imageview" value="200"/>
            <enum name="textview" value="201"/>
        </attr>
        <attr name="topbar_right_control_widht" format="dimension" />
        <attr name="topbar_right_control_height" format="dimension" />

        <!--右的控件为文字-->
        <!--右控件的文字-->
        <attr name="topbar_right_control_text" format="string|reference" />
        <!--右控件的背景颜色-->
        <attr name="topbar_right_control_bgcolor" format="color|reference" />
        <!--右控件的文字大小-->
        <attr name="topbar_right_control_textsize" format="dimension" />
        <!--右控件的文字颜色-->
        <attr name="topbar_right_control_textcolor" format="color|reference" />
        <!--end 左面的控件为文字-->
        <!--右的控件为ImageView-->
        <!--右控件的src-->
        <attr name="topbar_right_control_src" format="reference" />
        <!--end 左面的控件为ImageView-->


        <!--中间控件的文字-->
        <attr name="topbar_middle_control_text" format="string|reference" />
        <!--中间控件的背景颜色-->
        <attr name="topbar_middle_control_bgcolor" format="color|reference" />
        <!--中间控件的文字大小-->
        <attr name="topbar_middle_control_textsize" format="dimension" />
        <!--中间控件的文字颜色-->
        <attr name="topbar_middle_control_textcolor" format="color|reference" />

    </declare-styleable>
</resources>
```
## 举个例子
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:topbar="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context="com.tony.topdemo.MainActivity">


    <com.bigademo.topbar.TopBar
        android:id="@+id/topbar"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@android:color/holo_blue_bright"
        topbar:topbar_left_control_text="11111111"
        topbar:topbar_left_control_textcolor="@android:color/black"
        topbar:topbar_left_control_textsize="22sp"
        topbar:topbar_left_control_type="textview"

        topbar:topbar_middle_control_text="11111"
        topbar:topbar_middle_control_textsize="22sp"
        topbar:topbar_right_control_src="@mipmap/ic_launcher"
        topbar:topbar_right_control_text="22222"
        topbar:topbar_right_control_textsize="22sp"
        topbar:topbar_right_control_type="textview" />


</LinearLayout>

```