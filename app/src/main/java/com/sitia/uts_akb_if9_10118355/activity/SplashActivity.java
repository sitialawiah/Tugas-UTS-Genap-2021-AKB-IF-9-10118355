package com.sitia.uts_akb_if9_10118355.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.sitia.uts_akb_if9_10118355.MainActivity;
import com.sitia.uts_akb_if9_10118355.R;

public class SplashActivity extends Activity {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
