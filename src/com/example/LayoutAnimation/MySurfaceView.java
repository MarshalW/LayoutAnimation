package com.example.LayoutAnimation;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

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
    public MySurfaceView(Context context) {
        super(context);
        this.init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    private void init(){
        //使用OpenGL ES 2.0
        this.setEGLContextClientVersion(2);
        this.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.setRenderer(new MyRenderer());
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
