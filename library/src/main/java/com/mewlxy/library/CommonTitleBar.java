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
     * 标题栏高度
     */
    private float titleBarHeight;

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

    private final static float DEFAULT_TITLE_BAR_HEIGHT = 50;

    private OnClickListener leftClicklistener;
    private OnClickListener rightClicklistener;
    private OnClickListener searchClicklistener;


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
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.common_title_bar);
        titleBarHeight = typedArray.getDimension(R.styleable.common_title_bar_title_bar_height, dip2px(context, DEFAULT_TITLE_BAR_HEIGHT));
        titleBarBackground = typedArray.getColor(R.styleable.common_title_bar_title_bar_background, getResources().getColor(android.R.color.white));

        leftViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_left_view_visibility, true);
        leftTextViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_left_textView_visibility, false);
        leftImageViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_left_imageView_visibility, true);
        leftViewBackground = typedArray.getColor(R.styleable.common_title_bar_left_view_background, getTitleBarBackground());
        leftText = typedArray.getString(R.styleable.common_title_bar_left_text);
        leftTextViewDrawable = typedArray.getResourceId(R.styleable.common_title_bar_left_textView_drawable, 0);
        leftTextSize = typedArray.getDimension(R.styleable.common_title_bar_left_text_size, dip2px(context,16));
        leftTextColor = typedArray.getColor(R.styleable.common_title_bar_left_text_color, getResources().getColor(android.R.color.black));
        leftTextViewBackground = typedArray.getColor(R.styleable.common_title_bar_left_textView_background, getTitleBarBackground());
        leftImageDrawable = typedArray.getResourceId(R.styleable.common_title_bar_left_image, R.drawable.ic_back);


        rightViewBackground = typedArray.getColor(R.styleable.common_title_bar_right_view_background, getTitleBarBackground());
        rightViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_right_view_visibility, true);
        rightTextViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_right_textView_visibility, false);
        rightImageViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_right_imageView_visibility, false);
        rightText = typedArray.getString(R.styleable.common_title_bar_right_text);
        rightTextSize = typedArray.getDimension(R.styleable.common_title_bar_right_text_size, dip2px(context,16));
        rightTextColor = typedArray.getColor(R.styleable.common_title_bar_right_text_color, getResources().getColor(android.R.color.black));
        rightTextViewBackground = typedArray.getColor(R.styleable.common_title_bar_right_textView_background, getTitleBarBackground());
        rightImageDrawable = typedArray.getResourceId(R.styleable.common_title_bar_right_image, R.drawable.ic_menu);


        middleViewBackground = typedArray.getColor(R.styleable.common_title_bar_middle_view_background, getTitleBarBackground());
        titleTextViewVisibility = typedArray.getBoolean(R.styleable.common_title_bar_title_visibility, true);
        searchVisibility = typedArray.getBoolean(R.styleable.common_title_bar_search_visibility, false);


        titleText = typedArray.getString(R.styleable.common_title_bar_title_txt);
        titleTextSize = typedArray.getDimension(R.styleable.common_title_bar_title_text_size, dip2px(context,20));
        titleTextColor = typedArray.getColor(R.styleable.common_title_bar_title_text_color, getResources().getColor(android.R.color.black));
        titleTextViewBackground = typedArray.getColor(R.styleable.common_title_bar_title_text_color, getResources().getColor(android.R.color.black));

        searchHint = typedArray.getString(R.styleable.common_title_bar_title_search_hint);
        searchHintColor = typedArray.getColor(R.styleable.common_title_bar_title_search_hint_color, getResources().getColor(android.R.color.darker_gray));
        titleSearchText = typedArray.getString(R.styleable.common_title_bar_title_search_text);

        etSearchPaddingLeft = typedArray.getDimension(R.styleable.common_title_bar_title_search_paddingLeft, 10);
        etSearchPaddingTop = typedArray.getDimension(R.styleable.common_title_bar_title_search_paddingTop, 0);
        etSearchPaddingRight = typedArray.getDimension(R.styleable.common_title_bar_title_search_paddingRight, 10);
        etSearchPaddingBottom = typedArray.getDimension(R.styleable.common_title_bar_title_search_paddingBottom, 0);

        etDrawableLeft = typedArray.getResourceId(R.styleable.common_title_bar_title_search_drawableLeft, 0);
        etDrawableRight = typedArray.getResourceId(R.styleable.common_title_bar_title_search_drawableRight, 0);

        titleSearchTextColor = typedArray.getColor(R.styleable.common_title_bar_title_search_text_color, getResources().getColor(android.R.color.black));
        titleSearchTextSize = typedArray.getDimension(R.styleable.common_title_bar_title_search_text_size, dip2px(context,16));
        titleSearchBackground = typedArray.getResourceId(R.styleable.common_title_bar_title_search_background, R.drawable.bg_title_search);
        titleSearchTextGravity = typedArray.getInt(R.styleable.common_title_bar_title_search_text_gravity, 19);

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


        if (leftClicklistener!=null)
        {
            viewLeft.setOnClickListener(leftClicklistener);
        }
        if (rightClicklistener!=null)
        {
            viewRight.setOnClickListener(rightClicklistener);
        }
        if (searchClicklistener!=null)
        {
            viewTitle.setOnClickListener(searchClicklistener);
        }


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
        etTitle.setPadding(dip2px(context, etSearchPaddingLeft),
                dip2px(context, etSearchPaddingTop),
                dip2px(context, etSearchPaddingRight),
                dip2px(context, etSearchPaddingBottom));
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


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, (int) titleBarHeight);
    }


    private int dip2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    private int px2dip(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public View getViewLeft()
    {
        return viewLeft;
    }

    public void setViewLeft(View viewLeft)
    {
        this.viewLeft = viewLeft;
    }

    public TextView getTvLeft()
    {
        return tvLeft;
    }

    public void setTvLeft(TextView tvLeft)
    {
        this.tvLeft = tvLeft;
    }

    public ImageView getIvLeft()
    {
        return ivLeft;
    }

    public void setIvLeft(ImageView ivLeft)
    {
        this.ivLeft = ivLeft;
    }

    public View getViewRight()
    {
        return viewRight;
    }

    public void setViewRight(View viewRight)
    {
        this.viewRight = viewRight;
    }

    public TextView getTvRight()
    {
        return tvRight;
    }

    public void setTvRight(TextView tvRight)
    {
        this.tvRight = tvRight;
    }

    public ImageView getIvRight()
    {
        return ivRight;
    }

    public void setIvRight(ImageView ivRight)
    {
        this.ivRight = ivRight;
    }

    public View getViewTitle()
    {
        return viewTitle;
    }

    public void setViewTitle(View viewTitle)
    {
        this.viewTitle = viewTitle;
    }

    public TextView getTvTitle()
    {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle)
    {
        this.tvTitle = tvTitle;
    }

    public EditText getEtTitle()
    {
        return etTitle;
    }

    public void setEtTitle(EditText etTitle)
    {
        this.etTitle = etTitle;
    }


    public float getTitleBarHeight()
    {
        return titleBarHeight;
    }

    public void setTitleBarHeight(float titleBarHeight)
    {
        this.titleBarHeight = titleBarHeight;
    }

    public int getTitleBarBackground()
    {
        return titleBarBackground;
    }

    public void setTitleBarBackground(int titleBarBackground)
    {
        this.titleBarBackground = titleBarBackground;
    }

    public boolean isLeftViewVisibility()
    {
        return leftViewVisibility;
    }

    public void setLeftViewVisibility(boolean leftViewVisibility)
    {
        this.leftViewVisibility = leftViewVisibility;
    }

    public boolean isLeftTextViewVisibility()
    {
        return leftTextViewVisibility;
    }

    public void setLeftTextViewVisibility(boolean leftTextViewVisibility)
    {
        this.leftTextViewVisibility = leftTextViewVisibility;
    }

    public boolean isLeftImageViewVisibility()
    {
        return leftImageViewVisibility;
    }

    public void setLeftImageViewVisibility(boolean leftImageViewVisibility)
    {
        this.leftImageViewVisibility = leftImageViewVisibility;
    }

    public int getLeftViewBackground()
    {
        return leftViewBackground;
    }

    public void setLeftViewBackground(int leftViewBackground)
    {
        this.leftViewBackground = leftViewBackground;
    }

    public String getLeftText()
    {
        return leftText;
    }

    public void setLeftText(String leftText)
    {
        this.leftText = leftText;
    }

    public int getLeftTextViewDrawable()
    {
        return leftTextViewDrawable;
    }

    public void setLeftTextViewDrawable(int leftTextViewDrawable)
    {
        this.leftTextViewDrawable = leftTextViewDrawable;
    }

    public float getLeftTextSize()
    {
        return leftTextSize;
    }

    public void setLeftTextSize(float leftTextSize)
    {
        this.leftTextSize = leftTextSize;
    }

    public int getLeftTextColor()
    {
        return leftTextColor;
    }

    public void setLeftTextColor(int leftTextColor)
    {
        this.leftTextColor = leftTextColor;
    }

    public int getLeftTextViewBackground()
    {
        return leftTextViewBackground;
    }

    public void setLeftTextViewBackground(int leftTextViewBackground)
    {
        this.leftTextViewBackground = leftTextViewBackground;
    }

    public int getLeftImageDrawable()
    {
        return leftImageDrawable;
    }

    public void setLeftImageDrawable(int leftImageDrawable)
    {
        this.leftImageDrawable = leftImageDrawable;
    }

    public int getRightViewBackground()
    {
        return rightViewBackground;
    }

    public void setRightViewBackground(int rightViewBackground)
    {
        this.rightViewBackground = rightViewBackground;
    }

    public boolean isRightViewVisibility()
    {
        return rightViewVisibility;
    }

    public void setRightViewVisibility(boolean rightViewVisibility)
    {
        this.rightViewVisibility = rightViewVisibility;
    }

    public boolean isRightTextViewVisibility()
    {
        return rightTextViewVisibility;
    }

    public void setRightTextViewVisibility(boolean rightTextViewVisibility)
    {
        this.rightTextViewVisibility = rightTextViewVisibility;
    }

    public boolean isRightImageViewVisibility()
    {
        return rightImageViewVisibility;
    }

    public void setRightImageViewVisibility(boolean rightImageViewVisibility)
    {
        this.rightImageViewVisibility = rightImageViewVisibility;
    }

    public String getRightText()
    {
        return rightText;
    }

    public void setRightText(String rightText)
    {
        this.rightText = rightText;
    }

    public float getRightTextSize()
    {
        return rightTextSize;
    }

    public void setRightTextSize(float rightTextSize)
    {
        this.rightTextSize = rightTextSize;
    }

    public int getRightTextColor()
    {
        return rightTextColor;
    }

    public void setRightTextColor(int rightTextColor)
    {
        this.rightTextColor = rightTextColor;
    }

    public int getRightTextViewBackground()
    {
        return rightTextViewBackground;
    }

    public void setRightTextViewBackground(int rightTextViewBackground)
    {
        this.rightTextViewBackground = rightTextViewBackground;
    }

    public int getRightImageDrawable()
    {
        return rightImageDrawable;
    }

    public void setRightImageDrawable(int rightImageDrawable)
    {
        this.rightImageDrawable = rightImageDrawable;
    }

    public int getMiddleViewBackground()
    {
        return middleViewBackground;
    }

    public void setMiddleViewBackground(int middleViewBackground)
    {
        this.middleViewBackground = middleViewBackground;
    }

    public boolean isTitleTextViewVisibility()
    {
        return titleTextViewVisibility;
    }

    public void setTitleTextViewVisibility(boolean titleTextViewVisibility)
    {
        this.titleTextViewVisibility = titleTextViewVisibility;
    }

    public boolean isSearchVisibility()
    {
        return searchVisibility;
    }

    public void setSearchVisibility(boolean searchVisibility)
    {
        this.searchVisibility = searchVisibility;
    }

    public String getTitleText()
    {
        return titleText;
    }

    public void setTitleText(String titleText)
    {
        this.titleText = titleText;
    }

    public float getTitleTextSize()
    {
        return titleTextSize;
    }

    public void setTitleTextSize(float titleTextSize)
    {
        this.titleTextSize = titleTextSize;
    }

    public int getTitleTextColor()
    {
        return titleTextColor;
    }

    public void setTitleTextColor(int titleTextColor)
    {
        this.titleTextColor = titleTextColor;
    }

    public int getTitleTextViewBackground()
    {
        return titleTextViewBackground;
    }

    public void setTitleTextViewBackground(int titleTextViewBackground)
    {
        this.titleTextViewBackground = titleTextViewBackground;
    }

    public String getSearchHint()
    {
        return searchHint;
    }

    public void setSearchHint(String searchHint)
    {
        this.searchHint = searchHint;
    }

    public int getSearchHintColor()
    {
        return searchHintColor;
    }

    public void setSearchHintColor(int searchHintColor)
    {
        this.searchHintColor = searchHintColor;
    }

    public String getTitleSearchText()
    {
        return titleSearchText;
    }

    public void setTitleSearchText(String titleSearchText)
    {
        this.titleSearchText = titleSearchText;
    }

    public int getTitleSearchTextColor()
    {
        return titleSearchTextColor;
    }

    public void setTitleSearchTextColor(int titleSearchTextColor)
    {
        this.titleSearchTextColor = titleSearchTextColor;
    }

    public float getTitleSearchTextSize()
    {
        return titleSearchTextSize;
    }

    public void setTitleSearchTextSize(float titleSearchTextSize)
    {
        this.titleSearchTextSize = titleSearchTextSize;
    }

    public int getTitleSearchBackground()
    {
        return titleSearchBackground;
    }

    public void setTitleSearchBackground(int titleSearchBackground)
    {
        this.titleSearchBackground = titleSearchBackground;
    }

    public int getTitleSearchTextGravity()
    {
        return titleSearchTextGravity;
    }

    public void setTitleSearchTextGravity(int titleSearchTextGravity)
    {
        this.titleSearchTextGravity = titleSearchTextGravity;
    }

    public float getEtSearchPaddingLeft()
    {
        return etSearchPaddingLeft;
    }

    public void setEtSearchPaddingLeft(float etSearchPaddingLeft)
    {
        this.etSearchPaddingLeft = etSearchPaddingLeft;
    }

    public float getEtSearchPaddingTop()
    {
        return etSearchPaddingTop;
    }

    public void setEtSearchPaddingTop(float etSearchPaddingTop)
    {
        this.etSearchPaddingTop = etSearchPaddingTop;
    }

    public float getEtSearchPaddingRight()
    {
        return etSearchPaddingRight;
    }

    public void setEtSearchPaddingRight(float etSearchPaddingRight)
    {
        this.etSearchPaddingRight = etSearchPaddingRight;
    }

    public float getEtSearchPaddingBottom()
    {
        return etSearchPaddingBottom;
    }

    public void setEtSearchPaddingBottom(float etSearchPaddingBottom)
    {
        this.etSearchPaddingBottom = etSearchPaddingBottom;
    }

    public int getEtDrawableLeft()
    {
        return etDrawableLeft;
    }

    public void setEtDrawableLeft(int etDrawableLeft)
    {
        this.etDrawableLeft = etDrawableLeft;
    }

    public int getEtDrawableRight()
    {
        return etDrawableRight;
    }

    public void setEtDrawableRight(int etDrawableRight)
    {
        this.etDrawableRight = etDrawableRight;
    }

    public void setLeftClicklistener(OnClickListener leftClicklistener)
    {
        this.leftClicklistener = leftClicklistener;
    }

    public void setRightClicklistener(OnClickListener rightClicklistener)
    {
        this.rightClicklistener = rightClicklistener;
    }

    public void setSearchClicklistener(OnClickListener searchClicklistener)
    {
        this.searchClicklistener = searchClicklistener;
    }
}
