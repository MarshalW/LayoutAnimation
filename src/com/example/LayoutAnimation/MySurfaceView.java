package com.example.LayoutAnimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-27
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
public class MySurfaceView extends GLSurfaceView {

    private ValueAnimator animator;

    private MyRenderer renderer;

    private long duration = 300;

    private long startDelay = 2000;

    public MySurfaceView(Context context) {
        super(context);
        this.init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    private void init() {
        this.renderer = new MyRenderer();

        //使用OpenGL ES 2.0
        this.setEGLContextClientVersion(2);
        this.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.setRenderer(this.renderer);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(this.duration);
        animator.setStartDelay(this.startDelay);
//        animator.setInterpolator(new AccelerateInterpolator());
        animator.setInterpolator(new DecelerateInterpolator());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                Log.d("MySurfaceView",">>>"+(Float)valueAnimator.getAnimatedValue());
                renderer.setAnimateFactor((Float) valueAnimator.getAnimatedValue());
                requestRender();
            }
        });
    }

    public void start() {
        if (animator != null) {
            animator.start();
        }
    }
}
