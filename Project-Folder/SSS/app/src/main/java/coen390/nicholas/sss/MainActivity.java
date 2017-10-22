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
    Button goText = null;
    Button goVoice = null;

    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

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
        goText = (Button) findViewById(R.id.getText);
        goVoice = (Button) findViewById(R.id.getVoice);
    }

    //---------------------------------Function for when the action button gets pressed----------------------------------
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //-----------------------------Function to go to text page when text button is pressed---------------------------------
    public void goToText(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, textPageActivity.class);
        startActivity(startIntent);
    }

    //-----------------------------Function to go to voice page when voice button is pressed---------------------------------
    public void goToVoice(View view)
    {
        Intent startIntent = new Intent(MainActivity.this, voicePage.class);
        startActivity(startIntent);
    }

    //function for when items are selected
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(TAG, "The onOptions event");
        switch (item.getItemId())
        {
            //action to switch grades gets pressed
            case R.id.goSettings:
                Intent startIntent = new Intent(MainActivity.this, voicePage.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
