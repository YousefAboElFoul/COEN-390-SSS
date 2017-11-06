package coen390.nicholas.sss;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

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

    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI() {
        title = (TextView) findViewById(R.id.Title);
        hello = (TextView) findViewById(R.id.helloText);


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
                startIntent = new Intent(MainActivity.this, letterPage.class);
                startActivity(startIntent);
                return true;
            //action to switch to word page
            case R.id.goWord:
                startIntent = new Intent(MainActivity.this, wordPageActivity.class);
                startActivity(startIntent);
                return true;
            //action to switch to help
            case R.id.goHelp:
                startIntent = new Intent(MainActivity.this, help.class);
                startActivity(startIntent);
                return true;
            //action to switch to tutorial
            case R.id.goTutorial:
                startIntent = new Intent(MainActivity.this, tutorialActivitiy.class);
                startActivity(startIntent);
                return true;
            //action to switch to settings
            case R.id.goSettings:
                startIntent = new Intent(MainActivity.this, settings.class);
                startActivity(startIntent);
                return true;
            //action to go to BluetoothSettings to setup bluetooth
            case R.id.BluetoothSettings:
                startIntent = new Intent(MainActivity.this, BluetoothSettings.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





}