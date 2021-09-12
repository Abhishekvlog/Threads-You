package com.example.threads_you;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private Button BtnGo;
    private ProgressBar progressBar;
    private WorkerThread workerThread;
    private int CurrentProgress = 0;


    private Runnable task = new Runnable() {
        @Override
        public void run() {
            for (int i =0;i<10 ;i++){
                try {
                    Thread.sleep(1000);
                    CurrentProgress = CurrentProgress + 10;
                    progressBar.setProgress(CurrentProgress);
                    progressBar.setMax(100);
                    Log.d("Abhishek","Task Complete - " + CurrentProgress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.ProBar);
        BtnGo= findViewById(R.id.btnPs);
        workerThread = new WorkerThread();
        workerThread.start();
        BtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workerThread.addMessageToQueue(task);
            }
        });
    }
}