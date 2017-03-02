package zjhl.wxf.openeyes.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import zjhl.wxf.openeyes.R;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe
 */

public class GuideTextView extends TextView implements ValueAnimator.AnimatorUpdateListener, Runnable {
    private static final String TAG = "GuideTextView";
    private int animationDuration = 300;
    private String text;
    private int red;
    private int green;
    private int blue;
    private double[] alphas;

    public GuideTextView(Context context) {
        super(context);
        init(null);
    }

    public GuideTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context.getTheme().obtainStyledAttributes(attrs, R.styleable.GuideTextView, 0, 0));
    }

    public GuideTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context.getTheme().obtainStyledAttributes(attrs, R.styleable.GuideTextView, 0, 0));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GuideTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context.getTheme().obtainStyledAttributes(attrs, R.styleable.GuideTextView, 0, 0));
    }

    protected void init(TypedArray attrs) {
        try {
            animationDuration = attrs.getInteger(R.styleable.GuideTextView_rtv_duration, animationDuration);
            text = attrs.getString(R.styleable.GuideTextView_rtv_duration);
        } finally {
            attrs.recycle();
        }

        setAnimatedText(text);
    }

    @Override
    public void run() {
        final int color = getCurrentTextColor();

        red = Color.red(color);
        green = Color.green(color);
        blue = Color.blue(color);

        ValueAnimator animator = ValueAnimator.ofFloat(0f, 2f);
        animator.setDuration(animationDuration);
        animator.addUpdateListener(this);
        animator.start();
    }

    protected int clamp(double value) {
        return (int) (255f * Math.min(Math.max(value, 0f), 1f));
    }

    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        final float value = (float) valueAnimator.getAnimatedValue();
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            builder.setSpan(new ForegroundColorSpan(Color.argb(clamp(value + alphas[i]), red, green, blue)), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        setText(builder);
    }

    /**************
     *** Public ***
     **************/

    /**
     * Replay the animation.
     */
    public void replayAnimation() {
        if (null != text) {
            post(this);
        }
    }

    /**
     * Change the text and replay the animation.
     *
     * @param text Text to be shown.
     */
    public void setAnimatedText(String text) {
        this.text = text;
        alphas = new double[text.length()];
        for (int i = 0; i < text.length(); i++) {
            alphas[i] = Math.random() - 1.0f;
        }

        setText(text);

        replayAnimation();
    }

}
