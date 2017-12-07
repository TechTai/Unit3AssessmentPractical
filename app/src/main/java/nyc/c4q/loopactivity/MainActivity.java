package nyc.c4q.loopactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LongRunningTask().execute();

    }

    private class LongRunningTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: run before task");
        }

        @Override
        protected Integer doInBackground(Integer[] values) {
            Log.d(TAG, "doInBackground: run in background thread");
            // Write a loop that starts at the value passed into the AsyncTask after running execute(0) and ends at 100,000. For every loop, run publishProces().
            int count = 100000;
            for (int i = 0; i < count; i++) {
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer...progress){
            Log.d(TAG, "onProgressUpdate: publish progress of task");
            // Set the text of the textview "Loops completed: ", followed by the number received from the return in doInBackground
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("Loops completed: ");
            setProgress(progress [0]);
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            Log.d(TAG, "onPostExecute: run after task");
            // Set the text of the textview "Loops completed: ", followed by the number received from the return in doInBackground
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("Loops completed: ");
            setResult(result);

            //Create an intent to to a new activity called "LoginActivity"
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }



    }

    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragmentContainer);
        if (fragmentContainer != null) {
            LoginFragment loginFragment = new LoginFragment();
            loginFragment.set
        }
    }
}
