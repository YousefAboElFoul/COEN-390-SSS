package coen390.nicholas.sss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    //------when the action button gets pressed--------
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //-----------when items are selected----------------
    //attempted to make an onClick in the menu, but it crashed the app...
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "The onOptions event");
        Intent startIntent;
        switch (item.getItemId()) {
            //action to switch to the letter page
            case R.id.goLetter:
                startIntent = new Intent(settings.this, letterPage.class);
                startActivity(startIntent);
                return true;
            //action to switch to word page
            case R.id.goWord:
                startIntent = new Intent(settings.this, wordPageActivity.class);
                startActivity(startIntent);
                return true;
            //action to switch to help
            case R.id.goHelp:
                startIntent = new Intent(settings.this, help.class);
                startActivity(startIntent);
                return true;
            //action to switch to settings
            case R.id.goSettings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
