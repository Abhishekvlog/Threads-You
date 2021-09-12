package com.example.threads_you;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread{
    public Looper looper;
    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        looper = Looper.myLooper();
        handler = new Handler(looper);
        Looper.loop();

    }
    public void addMessageToQueue(Runnable runnable){
        handler.post(runnable);
    }
}
