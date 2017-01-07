   <com.bigademo.topbar.TopBar
        android:id="@+id/topbar"
        android:layout_width="match_parent"
        android:layout_height="56dp"
        android:background="#00fff0"
        topbar:left_control_src="@drawable/back"
        topbar:left_control_type="ImageView"
        topbar:middle_control_text="我的棋室"
        topbar:middle_control_textcolor="@android:color/white"
        topbar:middle_control_textsize="22px"
        topbar:right_control_text="创建棋室"
        topbar:right_control_type="TextView" />


left_control_type和right_control_type 必须设置这一项为 ImageView 或 TextView
Middle Textsize 只能为px。