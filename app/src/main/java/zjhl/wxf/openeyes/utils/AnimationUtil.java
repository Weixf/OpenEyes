package zjhl.wxf.openeyes.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Weixf
 * Date on 2017/3/1.
 * Describe 一些简单的动画效果
 */

public class AnimationUtil {
    /**
     * 位移动画
     */
    public static Animation translate(float x1, float x2, float y1, float y2, long duration){
        TranslateAnimation translateAnimation=new TranslateAnimation(x1,x2,y1,y2);
        translateAnimation.setDuration(duration);
        return translateAnimation;
    }
    /**
     * 渐变透明动画
     */
    public static Animation alph(int  x1, int  x2, long duration){
        AlphaAnimation animation=new AlphaAnimation(x1,x2);
        animation.setDuration(duration);
        return animation;
    }
    /**
     * 属性动画 X轴位移
     */
    public static Animator obTranslateX(View view, int duration, float x, float y){
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"translationX",x,y);
        animator.setDuration(duration);
        return animator;
    }
    /**
     * 属性动画 Y轴位移
     */
    public static Animator obTranslateY(View view, int duration, float x, float y){
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"translationY",x,y);
        animator.setDuration(duration);
        return animator;
    }
    /**
     * 属性动画 透明度渐变
     */
    public static Animator obAlpha(View view, int duration, float x, float y){
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"alpha",x,y);
        animator.setDuration(duration);
        return animator;
    }
    /**
     * 属性动画  文字颜色改变
     *         /*
     * ArgbEvaluator：这种评估者可以用来执行类型之间的插值整数值代表ARGB颜色。
     * FloatEvaluator：这种评估者可以用来执行浮点值之间的插值。
     * IntEvaluator：这种评估者可以用来执行类型int值之间的插值。
     * RectEvaluator：这种评估者可以用来执行类型之间的插值矩形值。
     */

    public static Animator obTextColorChange(View view, int duration, int x, int y){
        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(view,"textColor",x,y);
        objectAnimator.setDuration(duration);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        return objectAnimator;
    }
    /**
     * 属性动画 图片上升并逐渐消失(用于splashActivity)
     */
    public static Animator obTranslateAndAlpha(View view, int duration, float from, float to,float a1,float a2){
        AnimatorSet animatorSet=new AnimatorSet();
        Animator animator = AnimationUtil.obTranslateY(view, duration, from, to);
        Animator animator1 = AnimationUtil.obAlpha(view, duration, a1, a2);
        animatorSet.play(animator).with(animator1);
        return animatorSet;
    }
    /**
     * 属性动画 文字上升并改变颜色(用于splashActivity)
     */
    public static Animator obTranslateAndChangeColor(View view, int duration, float from, float to,int color1,int color2){
        AnimatorSet animatorSet=new AnimatorSet();
        Animator animator = AnimationUtil.obTranslateY(view, duration, from, to);
        Animator animator1 = AnimationUtil.obTextColorChange(view, duration, color1, color2);
        animatorSet.play(animator).with(animator1);
        return animatorSet;
    }
}
