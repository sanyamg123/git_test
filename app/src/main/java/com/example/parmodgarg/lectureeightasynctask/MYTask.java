package com.example.parmodgarg.lectureeightasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Parmod Garg on 6/28/2016.
 */
//void pass krane se unhe return nahi karana ppadega!
public class MYTask extends AsyncTask<String,Void,Long>{
   private Context ctx;
    public MYTask(Context c){
        ctx=c;
    }
    public static final String  TAG="mytask";
    @Override
    protected Long doInBackground(String... strings) {
        long startTime= SystemClock.uptimeMillis();
        long runs=0;
        while((SystemClock.uptimeMillis()-startTime)<10000)
        {
          runs++;
        }
        return runs;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        Log.d(TAG,"onPastExecute "+String.valueOf(aLong));
        //ab iss context ko use krte hue hum wahan par toast dikhane ke liye!!

        Toast.makeText(ctx,"onPastExecute "+String.valueOf(aLong) , Toast.LENGTH_SHORT).show();
    }
}
