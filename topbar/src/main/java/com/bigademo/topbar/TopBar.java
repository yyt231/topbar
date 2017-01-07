package com.bigademo.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * 自定义TopBar,有左中右三组控件,左右两边可以是ImageView或TextView
 * Created by Tony on 2016/9/29.
 */

public class TopBar extends RelativeLayout {
    //    左右的ImageView类型
    private ImageView leftImgBtn, rightImgBtn;
    //    左右的Button类型
    private TextView leftBtn, rightBtn;
    //    中间的文字
    private TextView middleTextView;

    private LayoutParams leftParams, middleParms, rightParams;
    //    默认字体大小
    private int defTextSize = 14;
    private CtrolClickLisnter lisnter;

    public interface CtrolClickLisnter {
        void leftClickLisnter();

        void rightClickListener();
    }

    public void setOnClickLisnter(CtrolClickLisnter lisnter) {
        this.lisnter = lisnter;
    }


    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.topbar_layout);
        String leftControlType = ta.getString(R.styleable.topbar_layout_left_control_type);

        if ("ImageView".equalsIgnoreCase(leftControlType)) {
            leftImgBtn = new ImageView(context);
            leftImgBtn.setImageDrawable(ta.getDrawable(R.styleable.topbar_layout_left_control_src));
        } else if ("TextView".equalsIgnoreCase(leftControlType)) {
            leftBtn = new TextView(context);
            leftBtn.setText(ta.getString(R.styleable.topbar_layout_left_control_text));
            leftBtn.setTextColor(ta.getInt(R.styleable.topbar_layout_left_control_textcolor, View.NO_ID));
            leftBtn.setTextSize(ta.getDimensionPixelSize(R.styleable.topbar_layout_left_control_textsize, defTextSize));
        } else {
        }


        String rightControlType = ta.getString(R.styleable.topbar_layout_right_control_type);
        if ("ImageView".equalsIgnoreCase(rightControlType)) {
            rightImgBtn = new ImageView(context);
            rightImgBtn.setImageDrawable(ta.getDrawable(R.styleable.topbar_layout_right_control_src));
        } else if ("TextView".equalsIgnoreCase(rightControlType)) {
            rightBtn = new TextView(context);
            rightBtn.setText(ta.getString(R.styleable.topbar_layout_right_control_text));
            rightBtn.setTextColor(ta.getInt(R.styleable.topbar_layout_right_control_textcolor, View.NO_ID));
            rightBtn.setTextSize(ta.getDimensionPixelSize(R.styleable.topbar_layout_right_control_textsize, defTextSize));
        } else {
        }


        String middleText = ta.getString(R.styleable.topbar_layout_middle_control_text);
        float textSize = ta.getDimension(R.styleable.topbar_layout_middle_control_textsize, defTextSize);
        int textColor = ta.getColor(R.styleable.topbar_layout_middle_control_textcolor, context.getResources().getColor(android.R.color.black));
        middleTextView = new TextView(context);
        middleTextView.setText(middleText);
        middleTextView.setTextSize(textSize);
        middleTextView.setTextColor(textColor);
        ta.recycle();


        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        leftParams.addRule(Gravity.CENTER);

        if ("ImageView".equalsIgnoreCase(leftControlType)) {
            leftParams = new LayoutParams(DensityUtil.dip2px(context, 48), LayoutParams.MATCH_PARENT);
            leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
            leftParams.addRule(Gravity.CENTER);

//            leftImgBtn.setPadding(
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8)
//            );
            leftImgBtn.setScaleType(ImageView.ScaleType.CENTER);
            leftImgBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisnter.leftClickLisnter();
                }
            });
            addView(leftImgBtn, leftParams);
        } else if ("TextView".equalsIgnoreCase(leftControlType)) {
            leftBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisnter.leftClickLisnter();
                }
            });

            addView(leftBtn, leftParams);
        }

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        rightParams.addRule(Gravity.CENTER);
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
        //判断右边的控件是TextView还是ImageView
        if ("ImageView".equalsIgnoreCase(rightControlType)) {
            rightParams = new LayoutParams(DensityUtil.dip2px(context, 48), LayoutParams.MATCH_PARENT);
            rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
            rightParams.addRule(Gravity.CENTER);

//            rightImgBtn.setPadding(
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8),
//                    DensityUtil.dip2px(context,8)
//            );
            rightImgBtn.setScaleType(ImageView.ScaleType.CENTER);

            rightImgBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisnter.rightClickListener();
                }
            });

            addView(rightImgBtn, rightParams);
        } else if ("TextView".equalsIgnoreCase(rightControlType)) {
            rightParams = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
            rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
            rightParams.addRule(Gravity.CENTER);
            rightParams.setMargins(0,0,DensityUtil.dip2px(context,16),0);
            rightBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisnter.rightClickListener();
                }
            });
            rightParams.addRule(Gravity.CENTER);

            addView(rightBtn, rightParams);
        }


        middleParms = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        middleParms.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        middleParms.addRule(Gravity.CENTER);
        addView(middleTextView, middleParms);
    }
}
