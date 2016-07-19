package com.example.parmodgarg.lectureeightasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
   Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=(Button)findViewById(R.id.button_one);
        final MYTask task=new MYTask(MainActivity.this);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //try {
                if(task.getStatus()!= AsyncTask.Status.RUNNING&&task.getStatus()!=AsyncTask.Status.FINISHED)
                {
                    task.execute("a", "b", "c", "d");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Task is already Running", Toast.LENGTH_SHORT).show();
                }

           // }
//                catch(InterruptedException e)
//                {
//                    e.printStackTrace();
//
//                }
//                catch(ExecutionException e)
//                {
//                    e.printStackTrace();
//                }
                //task.doInBackground("a","b","c","d");
            }
        });
    }
}
