package coen390.nicholas.sss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;
    TextView hello = null;
    Button goWord = null;
    Button goVoice = null;

    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"The onCreate() event");

        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.Title);
        hello = (TextView) findViewById(R.id.helloText);
        goWord = (Button) findViewById(R.id.getWord);
        goVoice = (Button) findViewById(R.id.getVoice);
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    //------when the action button gets pressed--------
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //----------when text button is pressed------------
    public void goToWord(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, wordPageActivity.class);
        startActivity(startIntent);
    }

    //----------when voice button is pressed--------------
    public void goToVoice(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, letterPage.class);
        startActivity(startIntent);
    }

    //-----------when items are selected----------------
    //attempted to make an onClick in the menu, but it crashed the app...
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(TAG, "The onOptions event");
        switch (item.getItemId())
        {
            //action to switch to settings gets pressed
            case R.id.goSettings:
                Intent startIntent = new Intent(MainActivity.this, settings.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
