package com.bec.merchantmanager.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;

import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.bean.LineChartBeanVO;

import java.util.ArrayList;
import java.util.List;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/27.
 */

public class LineChartView extends View {

    private static int DEFAULT_BULE = 0XFF00BFFF;
    private static int DEFAULT_GRAY = Color.GRAY;

    private int backgroundColor;
    private int minViewHeight; //控件的最低高度
    private int minPointHeight;//折线最低点的高度
    private int lineInterval; //折线线段长度
    private float pointRadius; //折线点的半径
    private float textSize; //字体大小
    private float pointGap; //折线单位高度差
    private int defaultPadding; //折线坐标图四周留出来的偏移量
    private int viewHeight;
    private int viewWidth;
    private int screenWidth;
    private int screenHeight;

    private Paint linePaint; //线画笔
    private Paint textPaint; //文字画笔
    private Paint circlePaint; //圆点画笔
    private List<Pair<Integer, String>> mList = new ArrayList<>();
    private List<Float> dashDatas = new ArrayList<>(); //虚线的x坐标集合
    private List<LineChartBeanVO> data = new ArrayList<>(); //元数据
    private List<PointF> points = new ArrayList<>(); //折线拐点的集合
    private double maxTemperature;//元数据中的最高和最低值
    private double minTemperature;

    private VelocityTracker velocityTracker;
    private Scroller scroller;
    private ViewConfiguration viewConfiguration;

    public LineChartView(Context context) {
        this(context, null);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        scroller = new Scroller(context);
        viewConfiguration = ViewConfiguration.get(context);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LineChartView);
        minPointHeight = (int) ta.getDimension(R.styleable.LineChartView_min_point_height, AppUtils.dp2pxF(context, 60));
        lineInterval = (int) ta.getDimension(R.styleable.LineChartView_line_interval, AppUtils.dp2pxF(context, 60));
        backgroundColor = ta.getColor(R.styleable.LineChartView_background_color, Color.WHITE);
        ta.recycle();

//        setBackground(getResources().getDrawable(R.drawable.bg_line_chart));

        initSize(context);

        initPaint(context);
    }

    /**
     * 唯一公开方法，用于设置元数据
     *
     * @param data
     */
    public void setData(List<LineChartBeanVO> data) {
        if (data == null || data.isEmpty()) {
            return;
        }
        this.data = data;
        mList.clear();
        points.clear();
        dashDatas.clear();

        initMap();
        requestLayout();
        invalidate();
    }

    /**
     * 初始化默认数据
     */
    private void initSize(Context c) {
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        minViewHeight = 3 * minPointHeight;  //默认3倍
        pointRadius = AppUtils.dp2pxF(c, 2.5f);
        textSize = AppUtils.sp2pxF(c, 10);
        defaultPadding = (int) (0.5 * minPointHeight);  //默认0.5倍
    }

    private void initPaint(Context c) {
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(AppUtils.dp2px(c, 1));

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(textSize);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStrokeWidth(AppUtils.dp2pxF(c, 1));
    }

    /**
     * 计算折线单位高度差
     */
    private void calculatePontGap() {
        double lastMaxTem = -Integer.MAX_VALUE;
        double lastMinTem = Integer.MAX_VALUE;
        for (LineChartBeanVO bean : data) {
            if (bean.getyValues() > lastMaxTem) {
                maxTemperature = bean.getyValues();
                lastMaxTem = bean.getyValues();
            }
            if (bean.getyValues() < lastMinTem) {
                minTemperature = bean.getyValues();
                lastMinTem = bean.getyValues();
            }
        }
        double gap = (maxTemperature - minTemperature) * 1.0f;
        gap = (gap == 0.0f ? 1.0f : gap);  //保证分母不为0
        pointGap = (float) ((viewHeight - minPointHeight - 2 * defaultPadding) / gap);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initSize(getContext());
        calculatePontGap();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode == MeasureSpec.EXACTLY) {
            viewHeight = Math.max(heightSize, minViewHeight);
        } else {
            viewHeight = minViewHeight;
        }

        int totalWidth = 0;
        if (data.size() > 1) {
            totalWidth = 2 * defaultPadding + lineInterval * (data.size() - 1);
        }
        viewWidth = Math.max(screenWidth, totalWidth);  //默认控件最小宽度为屏幕宽度

        setMeasuredDimension(viewWidth, viewHeight);
        calculatePontGap();
        Log.d("ccy", "viewHeight = " + viewHeight + ";viewWidth = " + viewWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (data.isEmpty()) {
            return;
        }
        drawAxis(canvas);

        drawLinesAndPoints(canvas);

        drawTemperature(canvas);

        drawDash(canvas);

    }

    /**
     * 画时间轴
     *
     * @param canvas
     */
    private void drawAxis(Canvas canvas) {
        canvas.save();
        linePaint.setColor(DEFAULT_GRAY);
        linePaint.setStrokeWidth(AppUtils.dp2px(getContext(), 1));

        canvas.drawLine(defaultPadding,
                viewHeight - defaultPadding,
                viewWidth - defaultPadding,
                viewHeight - defaultPadding,
                linePaint);

        float centerY = viewHeight - defaultPadding + AppUtils.dp2pxF(getContext(), 15);
        float centerX;
        for (int i = 0; i < data.size(); i++) {
            String text = data.get(i).getxValues();
            centerX = defaultPadding + i * lineInterval;
            Paint.FontMetrics m = textPaint.getFontMetrics();
            canvas.drawText(text, 0, text.length(), centerX, centerY - (m.ascent + m.descent) / 2, textPaint);
        }
        canvas.restore();
    }

    /**
     * 画折线和它拐点的园
     *
     * @param canvas
     */
    private void drawLinesAndPoints(Canvas canvas) {
        canvas.save();
        linePaint.setColor(getResources().getColor(R.color.white));
        linePaint.setStrokeWidth(AppUtils.dp2pxF(getContext(), 1));
        linePaint.setStyle(Paint.Style.STROKE);

        Path linePath = new Path(); //用于绘制折线
        points.clear();
        int baseHeight = defaultPadding + minPointHeight;
        float centerX;
        float centerY;
        for (int i = 0; i < data.size(); i++) {
            double tem = data.get(i).getyValues();
            tem = tem - minTemperature;
            centerY = (int) (viewHeight - (baseHeight + tem * pointGap));
            centerX = defaultPadding + i * lineInterval;
            points.add(new PointF(centerX, centerY));
            if (i == 0) {
                linePath.moveTo(centerX, centerY);
            } else {
                linePath.lineTo(centerX, centerY);
            }
        }
        canvas.drawPath(linePath, linePaint); //画出折线

        //接下来画折线拐点的园
        float x, y;
        for (int i = 0; i < points.size(); i++) {
            x = points.get(i).x;
            y = points.get(i).y;

            //先画一个颜色为背景颜色的实心园覆盖掉折线拐角
            circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
            circlePaint.setColor(backgroundColor);
            canvas.drawCircle(x, y,
                    pointRadius + AppUtils.dp2pxF(getContext(), 1),
                    circlePaint);
            //再画出正常的空心园
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setColor(DEFAULT_BULE);
            canvas.drawCircle(x, y,
                    pointRadius,
                    circlePaint);
        }
        canvas.restore();
    }

    /**
     * 拐点处的值
     *
     * @param canvas
     */
    private void drawTemperature(Canvas canvas) {
        canvas.save();

        textPaint.setTextSize(1.2f * textSize); //字体放大一丢丢
        float centerX;
        float centerY;
        String text;
        for (int i = 0; i < points.size(); i++) {
            text = data.get(i).getValues();
            centerX = points.get(i).x;
            centerY = points.get(i).y - AppUtils.dp2pxF(getContext(), 13);
            Paint.FontMetrics metrics = textPaint.getFontMetrics();
            canvas.drawText(text,
                    centerX,
                    centerY - (metrics.ascent + metrics.descent) / 2,
                    textPaint);
        }
        textPaint.setTextSize(textSize);
        canvas.restore();
    }

    private float lastX = 0;
    private float x = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!scroller.isFinished()) {  //fling还没结束
                    scroller.abortAnimation();
                }
                lastX = x = event.getX();
                return true;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                int deltaX = (int) (lastX - x);
                if (getScrollX() + deltaX < 0) {    //越界恢复
                    scrollTo(0, 0);
                    return true;
                } else if (getScrollX() + deltaX > viewWidth - screenWidth) {
                    scrollTo(viewWidth - screenWidth, 0);
                    return true;
                }
                scrollBy(deltaX, 0);
                lastX = x;
                break;
            case MotionEvent.ACTION_UP:
                x = event.getX();
                velocityTracker.computeCurrentVelocity(1000);  //计算1秒内滑动过多少像素
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > viewConfiguration.getScaledMinimumFlingVelocity()) {  //滑动速度可被判定为抛动
                    scroller.fling(getScrollX(), 0, -xVelocity, 0, 0, viewWidth - screenWidth, 0, 0);
                    invalidate();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }

    private void initMap() {
        mList.clear();
        String lastdata = "";
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            LineChartBeanVO bean = data.get(i);
            if (i == 0) {
                lastdata = bean.getValues();
            }
            if (bean.getValues() != lastdata) {
                Pair<Integer, String> pair = new Pair<>(count, lastdata);
                mList.add(pair);
                count = 1;
            } else {
                count++;
            }
            lastdata = bean.getValues();

            if (i == data.size() - 1) {
                Pair<Integer, String> pair = new Pair<>(count, lastdata);
                mList.add(pair);
            }
        }

        for (int i = 0; i < mList.size(); i++) {
            int c = mList.get(i).first;
            String w = mList.get(i).second;
            Log.d("ccy", "Map i =" + i + ";count = " + c + ";er = " + w);
        }
    }

    /**
     * 画的虚线
     *
     * @param canvas
     */
    private void drawDash(Canvas canvas) {

        canvas.save();
        linePaint.setColor(DEFAULT_GRAY);
        linePaint.setStrokeWidth(AppUtils.dp2pxF(getContext(), 0.5f));
        linePaint.setAlpha(0xcc);

        //设置画笔画出虚线
        float[] f = {AppUtils.dp2pxF(getContext(), 5), AppUtils.dp2pxF(getContext(), 1)};  //两个值分别为循环的实线长度、空白长度
        PathEffect pathEffect = new DashPathEffect(f, 0);
        linePaint.setPathEffect(pathEffect);

        dashDatas.clear();
        int interval = 0;
        float startX, startY, endX, endY;
        endY = viewHeight - defaultPadding;

        //0坐标点的虚线手动画上
        canvas.drawLine(defaultPadding,
                points.get(0).y + pointRadius + AppUtils.dp2pxF(getContext(), 2),
                defaultPadding,
                endY,
                linePaint);
        dashDatas.add((float) defaultPadding);

        for (int i = 0; i < mList.size(); i++) {
            interval += mList.get(i).first;
            if (interval > points.size() - 1) {
                interval = points.size() - 1;
            }
            startX = endX = defaultPadding + interval * lineInterval;
            startY = points.get(interval).y + pointRadius + AppUtils.dp2pxF(getContext(), 2);
            dashDatas.add(startX);
            canvas.drawLine(startX, startY, endX, endY, linePaint);
        }

        if (mList.get(mList.size() - 1).first == 1
                && dashDatas.size() > 1) {
            dashDatas.remove(dashDatas.get(dashDatas.size() - 1));
        }

        linePaint.setPathEffect(null);
        linePaint.setAlpha(0xff);
        canvas.restore();
    }

}
