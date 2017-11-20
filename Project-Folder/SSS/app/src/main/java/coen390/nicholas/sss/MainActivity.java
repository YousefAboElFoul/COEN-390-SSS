package coen390.nicholas.sss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------

    //-------for objects needed in the home page-------
    TextView title = null;
    TextView hello = null;

    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
        setupUI();
        SharedPreferences sp = getSharedPreferences("FirstTimeFile", Context.MODE_PRIVATE);
        boolean appIsOpenedForTheFirstTime = sp.getBoolean("IsAppOpenedForFirstTime",true);


//since it is true, it will be set to false after the execution of following block:
        if(appIsOpenedForTheFirstTime) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("IsAppOpenedForFirstTime", false);
            editor.commit();

            //PUT THE CODE FOR YOUR POPUP HERE
            Toast.makeText(getApplicationContext(),
                    "First time use.", Toast.LENGTH_LONG).show();

        }

    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI() {
        title = (TextView) findViewById(R.id.Title);
        hello = (TextView) findViewById(R.id.helloText);


    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    public void goTranslate(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, letterPage.class);
        startActivity(startIntent);
    }

    public void goTutorial(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, tutorialActivitiy.class);
        startActivity(startIntent);
    }

    public void goHelp(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, help.class);
        startActivity(startIntent);
    }

    public void goSettings(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, settings.class);
        startActivity(startIntent);
    }


}