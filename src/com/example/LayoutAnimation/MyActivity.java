package com.example.LayoutAnimation;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

public class MyActivity extends Activity {

    private MySurfaceView mySurfaceView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mySurfaceView=(MySurfaceView)this.findViewById(R.id.animateView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mySurfaceView.onResume();

        mySurfaceView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySurfaceView.onPause();
    }
}
