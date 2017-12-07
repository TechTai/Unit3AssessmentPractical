package nyc.c4q.loopactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    public static final String LIST_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        //Get a reference to the fragment
        LoginFragment loginFragment = (LoginFragment) getFragmentManager().findFragmentById(R.id.frag);
        //Get the ID of the workout the user clicked on from the intent.

        //      Pass the workout ID to the fragment
    }
}
