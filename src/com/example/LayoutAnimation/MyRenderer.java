package com.example.LayoutAnimation;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-2-27
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class MyRenderer implements GLSurfaceView.Renderer {

    private MyMesh mesh;

    private float[] projectionMatrix;

    private final float[] mVMatrix = new float[16];
    private final float[] mMVPMatrix = new float[16];

    private float ratio;

    private double deltaYFactor=0.3;

    public MyRenderer() {
        this.projectionMatrix = new float[16];
        this.mesh = new MyMesh();
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0f, 0f, 0f, 0.0f);
    }

    public void setAnimateFactor(double factor) {
        this.mesh.setAnimateFactor(factor);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        ratio = (float) width / height;
        Matrix.orthoM(projectionMatrix, 0, -ratio, ratio, -1f, 1f, -10f, 10f);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        float y=(float)(-1*this.mesh.getAnimateFactor()+1);
//        Log.d("MySurfaceView",">>");
        float x=(float)(1-(this.deltaYFactor*(1-this.mesh.getAnimateFactor())))*ratio;

        float[] vertexes = {
                -ratio, 1, 0,  //左上
                -x, y, 0, //左下
                ratio, 1, 0,   //右上
                x, y, 0   //右下
        };
        mesh.setSquareCoords(vertexes);


        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        Matrix.setLookAtM(mVMatrix, 0,
                0f, 0, -1,        //eye
                0f, 0f, 0f,      //center
                0f, 1f, 0f); //up
        Matrix.multiplyMM(mMVPMatrix, 0, projectionMatrix, 0, mVMatrix, 0);
        this.mesh.draw(mMVPMatrix);
    }
}
