package com.example.LayoutAnimation;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

public class MyActivity extends Activity {

    View midView;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ViewGroup viewGroup=(ViewGroup)midView.getParent();
            if(viewGroup!=null){
                midView.setVisibility(View.VISIBLE);
            }
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        midView=findViewById(R.id.midItem);
        midView.setVisibility(View.GONE);

        ViewGroup viewGroup=(ViewGroup)midView.getParent();
        LayoutTransition layoutTransition=new LayoutTransition();
        layoutTransition.setDuration(1500);
        layoutTransition.disableTransitionType(LayoutTransition.APPEARING);
        viewGroup.setLayoutTransition(layoutTransition);
    }


    @Override
    protected void onResume() {
        super.onResume();
        handler.sendMessageDelayed(new Message(),1000);
    }
}
