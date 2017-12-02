package com.example.user.klrahul;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by User on 12/3/2017.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent in = new Intent(SplashScreen.this,Login.class);
                    startActivity(in);
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
