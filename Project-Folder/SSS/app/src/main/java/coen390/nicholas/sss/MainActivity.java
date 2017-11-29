package coen390.nicholas.sss;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------
    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    public void goTranslate(View view) {
        Intent startIntent = new Intent(MainActivity.this, wordPageActivity.class);
        startActivity(startIntent);
    }

    public void goTutorial(View view) {
        Intent startIntent = new Intent(MainActivity.this, tutorialActivitiy.class);
        startActivity(startIntent);
    }

    public void goHelp(View view) {
        Intent startIntent = new Intent(MainActivity.this, help.class);
        startActivity(startIntent);
    }

    public void goSettings(View view) {
        Intent startIntent = new Intent(MainActivity.this, settings.class);
        startActivity(startIntent);
    }

}
