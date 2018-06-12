package com.andromin.rvive.andromin_asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void go(View v)
    {
        pb=findViewById(R.id.pb);
        new ProgressSet().execute();
    }

    public class ProgressSet extends AsyncTask<Void,Integer,String>
    {

        @Override
        protected String doInBackground(Void... voids)
        {
            //ACTIVITY
            for(int i = 0 ; i<100;i++)
            {
                SystemClock.sleep(100);
                publishProgress(i);
            }
            return "Completed";
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }



}
