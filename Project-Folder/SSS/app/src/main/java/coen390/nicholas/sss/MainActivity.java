package coen390.nicholas.sss;

import android.bluetooth.BluetoothAdapter;
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

public class MainActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------
    //------------Bluetooth variables--------------
    BluetoothAdapter myBluetoothAdapter;

    //-------for objects needed in the home page-------
    TextView title = null;
    TextView hello = null;
    Button Bluetoothonoff = null;

    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
        setupUI();
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothbutton();

    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI() {
        title = (TextView) findViewById(R.id.Title);
        hello = (TextView) findViewById(R.id.helloText);
        Bluetoothonoff = (Button) findViewById(R.id.bluetooth);

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
        }
        return super.onOptionsItemSelected(item);
    }


    //-------------------Button onclick for bluetooth-----------------------------------------
    public void bluetoothbutton() {
        Bluetoothonoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enable_disable_bluetooth();
            }
        });
    }


    //---------------------------------Checking for bluetooth if its enabled or disabled------------------------------
    public void Enable_disable_bluetooth() {
        if (myBluetoothAdapter == null)
            Toast.makeText(this, "Bluetooth not available on your device!", Toast.LENGTH_SHORT).show();
        if (!myBluetoothAdapter.isEnabled()) {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBluetooth);

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
        if (myBluetoothAdapter.isEnabled()) {
            Log.d(TAG, "enableDisableBT: disabling BT.");
            myBluetoothAdapter.disable();
            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
    }
    //----------------------------------Brodcast function for the change of states---------------------------------
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (action.equals(myBluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, myBluetoothAdapter.ERROR);

                switch(state){
                    case BluetoothAdapter.STATE_OFF:
                        Log.d(TAG, "onReceive: STATE OFF");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING OFF");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d(TAG, "mBroadcastReceiver1: STATE ON");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d(TAG, "mBroadcastReceiver1: STATE TURNING ON");
                        break;
                }
            }
        }
    };

    //---------------------------------------------functionality function for the bluetooth-------------------------
    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver1);
    }

}