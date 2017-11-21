package coen390.nicholas.sss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity
{
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;

    //--------to LOG textPage events-----------
    protected static final String TAG = "settingsActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d(TAG,"The onCreate() event");

        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.settingTitle);
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    public void goHelp(View view)
    {
        Intent startIntent = new Intent(settings.this, help.class);
        startActivity(startIntent);
    }

    public void goTutorial(View view)
    {
        Intent startIntent = new Intent(settings.this, tutorialActivitiy.class);
        startActivity(startIntent);
    }

    public void goHome(View view)
    {
        Intent startIntent = new Intent(settings.this, MainActivity.class);
        startActivity(startIntent);
    }

    public void goTranslate(View view)
    {
        Intent startIntent = new Intent(settings.this, wordPageActivity.class);
        startActivity(startIntent);
    }
}
