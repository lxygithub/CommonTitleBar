package com.mewlxy.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by master on 2017/5/1.
 */

public class CommonTitleBar extends LinearLayout
{
    private Context context;


    /**
     * TitleBar整体背景色
     */
    private int titleBarBackground;


    /**
     * 是否显示左侧View容器
     */
    private boolean leftViewVisibility;
    /**
     * 是否显示左侧TextView
     */
    private boolean leftTextViewVisibility;
    /**
     * 是否显示左侧ImageView
     */
    private boolean leftImageViewVisibility;

    /**
     * 左侧View容器背景色
     */
    private int leftViewBackground;
    /**
     * 返回键文字
     */
    private String leftText;
    /**
     * 返回键TextView左侧图标
     */
    private int leftTextViewDrawable;
    /**
     * 返回键文字字号
     */
    private float leftTextSize;
    /**
     * 返回键文字颜色
     */
    private int leftTextColor;
    /**
     * 返回TextView背景色
     */
    private int leftTextViewBackground;

    /**
     * 返回键图标
     */
    private int leftImageDrawable;
    /**
     * 右侧View容器背景色
     */
    private int rightViewBackground;
    /**
     * 是否显示右侧View容器
     */
    private boolean rightViewVisibility;
    /**
     * 是否显示右侧TextView
     */
    private boolean rightTextViewVisibility;
    /**
     * 是否显示右侧ImageView
     */
    private boolean rightImageViewVisibility;
    /**
     * 菜单键文字
     */
    private String rightText;
    /**
     * 菜单键文字字号
     */
    private float rightTextSize;
    /**
     * 菜单键文字颜色
     */
    private int rightTextColor;

    /**
     * 菜单键TextView背景
     */
    private int rightTextViewBackground;

    /**
     * 菜单键图标
     */
    private int rightImageDrawable;

    /**
     * 中间容器背景色
     */
    private int middleViewBackground;
    /**
     * 是否显示title
     */
    private boolean titleTextViewVisibility;
    /**
     * 是否显示搜索框
     */
    private boolean searchVisibility;

    /**
     * 标题
     */
    private String titleText;
    /**
     * 标题字号，单位sp
     */
    private float titleTextSize;
    /**
     * 标题字体颜色
     */
    private int titleTextColor;
    /**
     * 标题TextView背景色
     */
    private int titleTextViewBackground;

    /**
     * 搜索框hint
     */
    private String searchHint;
    /**
     * 搜索框hint字体颜色
     */
    private int searchHintColor;
    /**
     * 搜索框文字
     */
    private String titleSearchText;
    /**
     * 搜索框文字颜色
     */
    private int titleSearchTextColor;
    /**
     * 搜索框文字字号
     */
    private float titleSearchTextSize;
    /**
     * 搜索框背景色
     */
    private int titleSearchBackground;
    /**
     * 搜索框文字排版方式
     */
    private int titleSearchTextGravity;

    /**
     * 左边View容器
     */
    private View viewLeft;
    /**
     * 左边TextView
     */
    private TextView tvLeft;
    /**
     * 返回键
     */
    private ImageView ivLeft;

    /**
     * 右边View容器
     */
    private View viewRight;
    /**
     * 右边TextView
     */
    private TextView tvRight;
    /**
     * 菜单键
     */
    private ImageView ivRight;
    /**
     * 中间View容器
     */
    private View viewTitle;
    /**
     * 标题TextView
     */
    private TextView tvTitle;
    /**
     * 搜索框
     */
    private EditText etTitle;

    private float etSearchPaddingLeft = 10;
    private float etSearchPaddingTop = 0;
    private float etSearchPaddingRight = 10;
    private float etSearchPaddingBottom = 0;
    /**
     * 搜索框左侧小图标
     */
    private int etDrawableLeft;
    /**
     * 搜索框右侧小图标
     */
    private int etDrawableRight;

    private final static float DEFAULT_TITLE_BAR_HEIGHT = 45;

    private OnClickListener OnLeftClickListener;
    private OnClickListener OnRightClickListener;
    private OnClickListener OnSearchClickListener;


    public CommonTitleBar(Context context)
    {
        this(context, null, 0);
    }

    public CommonTitleBar(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonTitleBar);
        titleBarBackground = typedArray.getColor(R.styleable.CommonTitleBar_title_bar_background, getResources().getColor(android.R.color.white));

        leftViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_left_view_visibility, true);
        leftTextViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_left_textView_visibility, false);
        leftImageViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_left_imageView_visibility, true);
        leftViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_left_view_background, getTitleBarBackground());
        leftText = typedArray.getString(R.styleable.CommonTitleBar_left_text);
        leftTextViewDrawable = typedArray.getResourceId(R.styleable.CommonTitleBar_left_textView_drawable, 0);
        leftTextSize = typedArray.getDimension(R.styleable.CommonTitleBar_left_text_size, dip2px(16));
        leftTextColor = typedArray.getColor(R.styleable.CommonTitleBar_left_text_color, getResources().getColor(android.R.color.black));
        leftTextViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_left_textView_background, getTitleBarBackground());
        leftImageDrawable = typedArray.getResourceId(R.styleable.CommonTitleBar_left_image, R.drawable.ic_back);


        rightViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_right_view_background, getTitleBarBackground());
        rightViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_right_view_visibility, true);
        rightTextViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_right_textView_visibility, false);
        rightImageViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_right_imageView_visibility, false);
        rightText = typedArray.getString(R.styleable.CommonTitleBar_right_text);
        rightTextSize = typedArray.getDimension(R.styleable.CommonTitleBar_right_text_size, dip2px(16));
        rightTextColor = typedArray.getColor(R.styleable.CommonTitleBar_right_text_color, getResources().getColor(android.R.color.black));
        rightTextViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_right_textView_background, getTitleBarBackground());
        rightImageDrawable = typedArray.getResourceId(R.styleable.CommonTitleBar_right_image, R.drawable.ic_menu);


        middleViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_middle_view_background, getTitleBarBackground());
        titleTextViewVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_title_visibility, true);
        searchVisibility = typedArray.getBoolean(R.styleable.CommonTitleBar_search_visibility, false);


        titleText = typedArray.getString(R.styleable.CommonTitleBar_title_txt);
        titleTextSize = typedArray.getDimension(R.styleable.CommonTitleBar_title_text_size, dip2px(20));
        titleTextColor = typedArray.getColor(R.styleable.CommonTitleBar_title_text_color, getResources().getColor(android.R.color.black));
        titleTextViewBackground = typedArray.getColor(R.styleable.CommonTitleBar_title_text_color, getResources().getColor(android.R.color.black));

        searchHint = typedArray.getString(R.styleable.CommonTitleBar_title_search_hint);
        searchHintColor = typedArray.getColor(R.styleable.CommonTitleBar_title_search_hint_color, getResources().getColor(android.R.color.darker_gray));
        titleSearchText = typedArray.getString(R.styleable.CommonTitleBar_title_search_text);

        etSearchPaddingLeft = typedArray.getDimension(R.styleable.CommonTitleBar_title_search_paddingLeft, 10);
        etSearchPaddingTop = typedArray.getDimension(R.styleable.CommonTitleBar_title_search_paddingTop, 0);
        etSearchPaddingRight = typedArray.getDimension(R.styleable.CommonTitleBar_title_search_paddingRight, 10);
        etSearchPaddingBottom = typedArray.getDimension(R.styleable.CommonTitleBar_title_search_paddingBottom, 0);

        etDrawableLeft = typedArray.getResourceId(R.styleable.CommonTitleBar_title_search_drawableLeft, 0);
        etDrawableRight = typedArray.getResourceId(R.styleable.CommonTitleBar_title_search_drawableRight, 0);

        titleSearchTextColor = typedArray.getColor(R.styleable.CommonTitleBar_title_search_text_color, getResources().getColor(android.R.color.black));
        titleSearchTextSize = typedArray.getDimension(R.styleable.CommonTitleBar_title_search_text_size, dip2px(16));
        titleSearchBackground = typedArray.getResourceId(R.styleable.CommonTitleBar_title_search_background, R.drawable.bg_title_search);
        titleSearchTextGravity = typedArray.getInt(R.styleable.CommonTitleBar_title_search_text_gravity, 19);

        typedArray.recycle();
        initView();
    }


    private void initView()
    {
        View view = LayoutInflater.from(context).inflate(R.layout.common_title, this, true);

        viewLeft = view.findViewById(R.id.view_left);
        tvLeft = (TextView) view.findViewById(R.id.tv_title_left);
        ivLeft = (ImageView) view.findViewById(R.id.iv_title_left);

        viewRight = view.findViewById(R.id.view_right);
        tvRight = (TextView) view.findViewById(R.id.tv_title_right);
        ivRight = (ImageView) view.findViewById(R.id.iv_title_right);

        viewTitle = view.findViewById(R.id.view_title);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        etTitle = (EditText) view.findViewById(R.id.et_title);


        viewLeft.setVisibility(leftViewVisibility ? VISIBLE : INVISIBLE);
        viewLeft.setBackgroundColor(leftViewBackground);


        tvLeft.setVisibility(leftTextViewVisibility ? VISIBLE : INVISIBLE);
        tvLeft.setText(leftText);
        if (leftTextViewDrawable != 0)
        {
            Drawable drawable = getResources().getDrawable(leftImageDrawable);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvLeft.setCompoundDrawables(drawable, null, null, null);
        }
        tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
        tvLeft.setTextColor(leftTextColor);
        tvLeft.setBackgroundColor(leftTextViewBackground);

        ivLeft.setVisibility(leftImageViewVisibility ? VISIBLE : INVISIBLE);
        ivLeft.setImageResource(leftImageDrawable);

        viewTitle.setBackgroundColor(middleViewBackground);

        tvTitle.setVisibility(titleTextViewVisibility ? VISIBLE : INVISIBLE);
        tvTitle.setText(titleText);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTextSize);
        tvTitle.setTextColor(titleTextViewBackground);
        tvTitle.setBackgroundColor(titleBarBackground);

        etTitle.setVisibility(searchVisibility ? VISIBLE : GONE);
        etTitle.setHint(searchHint);
        etTitle.setHintTextColor(searchHintColor);
        etTitle.setText(titleSearchText);
        etTitle.setPadding(dip2px(etSearchPaddingLeft),
                dip2px(etSearchPaddingTop),
                dip2px(etSearchPaddingRight),
                dip2px(etSearchPaddingBottom));
        Drawable drawableLeft = null;
        Drawable drawableRight = null;
        if (etDrawableLeft != 0)
        {
            drawableLeft = getResources().getDrawable(etDrawableLeft);
            drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
        }
        if (etDrawableRight != 0)
        {
            drawableRight = getResources().getDrawable(etDrawableRight);
            drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
        }
        etTitle.setCompoundDrawables(drawableLeft, null, drawableRight, null);
        etTitle.setGravity(titleSearchTextGravity);
        etTitle.setTextColor(titleSearchTextColor);
        etTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSearchTextSize);
        etTitle.setBackgroundResource(titleSearchBackground);


        viewRight.setVisibility(rightViewVisibility ? VISIBLE : INVISIBLE);
        viewRight.setBackgroundColor(rightViewBackground);

        tvRight.setVisibility(rightTextViewVisibility ? VISIBLE : INVISIBLE);
        tvRight.setText(rightText);
        tvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
        tvRight.setTextColor(rightTextColor);
        tvRight.setBackgroundColor(rightTextViewBackground);

        ivRight.setVisibility(rightImageViewVisibility ? VISIBLE : INVISIBLE);
        ivRight.setImageResource(rightImageDrawable);

        //view绘制完成之后才能添加点击时间的监听，这里要延时处理
        this.post(new Runnable()
        {
            @Override
            public void run()
            {
                if (OnLeftClickListener != null)
                {
                    viewLeft.setOnClickListener(OnLeftClickListener);
                }

                if (OnRightClickListener != null)
                {
                    viewRight.setOnClickListener(OnRightClickListener);
                }
                if (OnSearchClickListener != null)
                {
                    viewTitle.setOnClickListener(OnSearchClickListener);
                }
            }
        });


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        switch (widthMode)
        {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = screenWidth();
                break;
            case MeasureSpec.EXACTLY:
                width = MeasureSpec.getSize(widthMeasureSpec);
                break;
        }
        switch (heightMode)
        {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = dip2px(DEFAULT_TITLE_BAR_HEIGHT);
                break;
            case MeasureSpec.EXACTLY:
                height = MeasureSpec.getSize(heightMeasureSpec);
                break;
        }

        setMeasuredDimension(width, height);
    }


    private int screenWidth()
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private int screenHeight()
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private int dip2px(float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    private int px2dip(float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public View getViewLeft()
    {
        return viewLeft;
    }

    public CommonTitleBar setViewLeft(View viewLeft)
    {
        this.viewLeft = viewLeft;
        initView();
        return this;
    }

    public TextView getTvLeft()
    {
        return tvLeft;
    }

    public CommonTitleBar setTvLeft(TextView tvLeft)
    {
        this.tvLeft = tvLeft;
        initView();
        return this;
    }

    public ImageView getIvLeft()
    {
        return ivLeft;
    }

    public CommonTitleBar setIvLeft(ImageView ivLeft)
    {
        this.ivLeft = ivLeft;
        initView();
        return this;
    }

    public View getViewRight()
    {
        return viewRight;
    }

    public CommonTitleBar setViewRight(View viewRight)
    {
        this.viewRight = viewRight;
        initView();
        return this;
    }

    public TextView getTvRight()
    {
        return tvRight;
    }

    public CommonTitleBar setTvRight(TextView tvRight)
    {
        this.tvRight = tvRight;
        initView();
        return this;
    }

    public ImageView getIvRight()
    {
        return ivRight;
    }

    public CommonTitleBar setIvRight(ImageView ivRight)
    {
        this.ivRight = ivRight;
        initView();
        return this;
    }

    public View getViewTitle()
    {
        return viewTitle;
    }

    public CommonTitleBar setViewTitle(View viewTitle)
    {
        this.viewTitle = viewTitle;
        initView();
        return this;
    }

    public TextView getTvTitle()
    {
        return tvTitle;
    }

    public CommonTitleBar setTvTitle(TextView tvTitle)
    {
        this.tvTitle = tvTitle;
        initView();
        return this;
    }

    public EditText getEtTitle()
    {
        return etTitle;
    }

    public CommonTitleBar setEtTitle(EditText etTitle)
    {
        this.etTitle = etTitle;
        initView();
        return this;
    }

    public int getTitleBarBackground()
    {
        return titleBarBackground;
    }

    public CommonTitleBar setTitleBarBackground(int titleBarBackground)
    {
        this.titleBarBackground = titleBarBackground;
        initView();
        return this;
    }

    public boolean isLeftViewVisibility()
    {
        return leftViewVisibility;
    }

    public CommonTitleBar setLeftViewVisibility(boolean leftViewVisibility)
    {
        this.leftViewVisibility = leftViewVisibility;
        initView();
        return this;
    }

    public boolean isLeftTextViewVisibility()
    {
        return leftTextViewVisibility;
    }

    public CommonTitleBar setLeftTextViewVisibility(boolean leftTextViewVisibility)
    {
        this.leftTextViewVisibility = leftTextViewVisibility;
        initView();
        return this;
    }

    public boolean isLeftImageViewVisibility()
    {
        return leftImageViewVisibility;
    }

    public CommonTitleBar setLeftImageViewVisibility(boolean leftImageViewVisibility)
    {
        this.leftImageViewVisibility = leftImageViewVisibility;
        initView();
        return this;
    }

    public int getLeftViewBackground()
    {
        return leftViewBackground;
    }

    public CommonTitleBar setLeftViewBackground(int leftViewBackground)
    {
        this.leftViewBackground = leftViewBackground;
        initView();
        return this;
    }

    public String getLeftText()
    {
        return leftText;
    }

    public CommonTitleBar setLeftText(String leftText)
    {
        this.leftText = leftText;
        initView();
        return this;
    }

    public int getLeftTextViewDrawable()
    {
        return leftTextViewDrawable;
    }

    public CommonTitleBar setLeftTextViewDrawable(int leftTextViewDrawable)
    {
        this.leftTextViewDrawable = leftTextViewDrawable;
        initView();
        return this;
    }

    public float getLeftTextSize()
    {
        return leftTextSize;
    }

    public CommonTitleBar setLeftTextSize(float leftTextSize)
    {
        this.leftTextSize = leftTextSize;
        initView();
        return this;
    }

    public int getLeftTextColor()
    {
        return leftTextColor;
    }

    public CommonTitleBar setLeftTextColor(int leftTextColor)
    {
        this.leftTextColor = leftTextColor;
        initView();
        return this;
    }

    public int getLeftTextViewBackground()
    {
        return leftTextViewBackground;
    }

    public CommonTitleBar setLeftTextViewBackground(int leftTextViewBackground)
    {
        this.leftTextViewBackground = leftTextViewBackground;
        initView();
        return this;
    }

    public int getLeftImageDrawable()
    {
        return leftImageDrawable;
    }

    public CommonTitleBar setLeftImageDrawable(int leftImageDrawable)
    {
        this.leftImageDrawable = leftImageDrawable;
        initView();
        return this;
    }

    public int getRightViewBackground()
    {
        return rightViewBackground;
    }

    public CommonTitleBar setRightViewBackground(int rightViewBackground)
    {
        this.rightViewBackground = rightViewBackground;
        initView();
        return this;
    }

    public boolean isRightViewVisibility()
    {
        return rightViewVisibility;
    }

    public CommonTitleBar setRightViewVisibility(boolean rightViewVisibility)
    {
        this.rightViewVisibility = rightViewVisibility;
        initView();
        return this;
    }

    public boolean isRightTextViewVisibility()
    {
        return rightTextViewVisibility;
    }

    public CommonTitleBar setRightTextViewVisibility(boolean rightTextViewVisibility)
    {
        this.rightTextViewVisibility = rightTextViewVisibility;
        initView();
        return this;
    }

    public boolean isRightImageViewVisibility()
    {
        return rightImageViewVisibility;
    }

    public CommonTitleBar setRightImageViewVisibility(boolean rightImageViewVisibility)
    {
        this.rightImageViewVisibility = rightImageViewVisibility;
        initView();
        return this;
    }

    public String getRightText()
    {
        return rightText;
    }

    public CommonTitleBar setRightText(String rightText)
    {
        this.rightText = rightText;
        initView();
        return this;
    }

    public float getRightTextSize()
    {
        return rightTextSize;
    }

    public CommonTitleBar setRightTextSize(float rightTextSize)
    {
        this.rightTextSize = rightTextSize;
        initView();
        return this;
    }

    public int getRightTextColor()
    {
        return rightTextColor;
    }

    public CommonTitleBar setRightTextColor(int rightTextColor)
    {
        this.rightTextColor = rightTextColor;
        initView();
        return this;
    }

    public int getRightTextViewBackground()
    {
        return rightTextViewBackground;
    }

    public CommonTitleBar setRightTextViewBackground(int rightTextViewBackground)
    {
        this.rightTextViewBackground = rightTextViewBackground;
        initView();
        return this;
    }

    public int getRightImageDrawable()
    {
        return rightImageDrawable;
    }

    public CommonTitleBar setRightImageDrawable(int rightImageDrawable)
    {
        this.rightImageDrawable = rightImageDrawable;
        initView();
        return this;
    }

    public int getMiddleViewBackground()
    {
        return middleViewBackground;
    }

    public CommonTitleBar setMiddleViewBackground(int middleViewBackground)
    {
        this.middleViewBackground = middleViewBackground;
        initView();
        return this;
    }

    public boolean isTitleTextViewVisibility()
    {
        return titleTextViewVisibility;
    }

    public CommonTitleBar setTitleTextViewVisibility(boolean titleTextViewVisibility)
    {
        this.titleTextViewVisibility = titleTextViewVisibility;
        initView();
        return this;
    }

    public boolean isSearchVisibility()
    {
        return searchVisibility;
    }

    public CommonTitleBar setSearchVisibility(boolean searchVisibility)
    {
        this.searchVisibility = searchVisibility;
        initView();
        return this;
    }

    public String getTitleText()
    {
        return titleText;
    }

    public CommonTitleBar setTitleText(String titleText)
    {
        this.titleText = titleText;
        initView();
        return this;
    }

    public float getTitleTextSize()
    {
        return titleTextSize;
    }

    public CommonTitleBar setTitleTextSize(float titleTextSize)
    {
        this.titleTextSize = titleTextSize;
        initView();
        return this;
    }

    public int getTitleTextColor()
    {
        return titleTextColor;
    }

    public CommonTitleBar setTitleTextColor(int titleTextColor)
    {
        this.titleTextColor = titleTextColor;
        initView();
        return this;
    }

    public int getTitleTextViewBackground()
    {
        return titleTextViewBackground;
    }

    public CommonTitleBar setTitleTextViewBackground(int titleTextViewBackground)
    {
        this.titleTextViewBackground = titleTextViewBackground;
        initView();
        return this;
    }

    public String getSearchHint()
    {
        return searchHint;
    }

    public CommonTitleBar setSearchHint(String searchHint)
    {
        this.searchHint = searchHint;
        initView();
        return this;
    }

    public int getSearchHintColor()
    {
        return searchHintColor;
    }

    public CommonTitleBar setSearchHintColor(int searchHintColor)
    {
        this.searchHintColor = searchHintColor;
        initView();
        return this;
    }

    public String getTitleSearchText()
    {
        return titleSearchText;
    }

    public CommonTitleBar setTitleSearchText(String titleSearchText)
    {
        this.titleSearchText = titleSearchText;
        initView();
        return this;
    }

    public int getTitleSearchTextColor()
    {
        return titleSearchTextColor;
    }

    public CommonTitleBar setTitleSearchTextColor(int titleSearchTextColor)
    {
        this.titleSearchTextColor = titleSearchTextColor;
        initView();
        return this;
    }

    public float getTitleSearchTextSize()
    {
        return titleSearchTextSize;
    }

    public CommonTitleBar setTitleSearchTextSize(float titleSearchTextSize)
    {
        this.titleSearchTextSize = titleSearchTextSize;
        initView();
        return this;
    }

    public int getTitleSearchBackground()
    {
        return titleSearchBackground;
    }

    public CommonTitleBar setTitleSearchBackground(int titleSearchBackground)
    {
        this.titleSearchBackground = titleSearchBackground;
        initView();
        return this;
    }

    public int getTitleSearchTextGravity()
    {
        return titleSearchTextGravity;
    }

    public CommonTitleBar setTitleSearchTextGravity(int titleSearchTextGravity)
    {
        this.titleSearchTextGravity = titleSearchTextGravity;
        initView();
        return this;
    }

    public float getEtSearchPaddingLeft()
    {
        return etSearchPaddingLeft;
    }

    public CommonTitleBar setEtSearchPaddingLeft(float etSearchPaddingLeft)
    {
        this.etSearchPaddingLeft = etSearchPaddingLeft;
        initView();
        return this;
    }

    public float getEtSearchPaddingTop()
    {
        return etSearchPaddingTop;
    }

    public CommonTitleBar setEtSearchPaddingTop(float etSearchPaddingTop)
    {
        this.etSearchPaddingTop = etSearchPaddingTop;
        initView();
        return this;
    }

    public float getEtSearchPaddingRight()
    {
        return etSearchPaddingRight;
    }

    public CommonTitleBar setEtSearchPaddingRight(float etSearchPaddingRight)
    {
        this.etSearchPaddingRight = etSearchPaddingRight;
        initView();
        return this;
    }

    public float getEtSearchPaddingBottom()
    {
        return etSearchPaddingBottom;
    }

    public CommonTitleBar setEtSearchPaddingBottom(float etSearchPaddingBottom)
    {
        this.etSearchPaddingBottom = etSearchPaddingBottom;
        initView();
        return this;
    }

    public int getEtDrawableLeft()
    {
        return etDrawableLeft;
    }

    public CommonTitleBar setEtDrawableLeft(int etDrawableLeft)
    {
        this.etDrawableLeft = etDrawableLeft;
        initView();
        return this;
    }

    public int getEtDrawableRight()
    {
        return etDrawableRight;
    }

    public CommonTitleBar setEtDrawableRight(int etDrawableRight)
    {
        this.etDrawableRight = etDrawableRight;
        initView();
        return this;
    }

    public CommonTitleBar setOnLeftClickListener(OnClickListener onLeftClickListener)
    {
        this.OnLeftClickListener = onLeftClickListener;
        return this;
    }

    public CommonTitleBar setOnRightClickListener(OnClickListener onRightClickListener)
    {
        this.OnRightClickListener = onRightClickListener;
        return this;
    }

    public CommonTitleBar setOnSearchClickListener(OnClickListener onSearchClickListener)
    {
        this.OnSearchClickListener = onSearchClickListener;
        return this;
    }
}
