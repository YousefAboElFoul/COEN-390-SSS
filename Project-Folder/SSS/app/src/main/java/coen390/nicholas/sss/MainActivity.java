package coen390.nicholas.sss;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------

    //-------for objects needed in the home page-------
    TextView title = null;
    TextView hello = null;
    //-----------Circle menu------------------------------
    CircleMenu circleMenu;
    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
        setupUI();
        MenuCircle();


    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI() {
        title = (TextView) findViewById(R.id.Title);
        hello = (TextView) findViewById(R.id.helloText);


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

    //-------------------------------------------------------finish function for the circle menu----------------------------------------------------

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

    public void MenuCircle() {
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_home)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

            @Override public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
                                             }

        );
        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
                Toast.makeText(MainActivity.this, "Menu Opend", Toast.LENGTH_SHORT).show();
                                                     }

            @Override
            public void onMenuClosed() {
                Toast.makeText(MainActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
        );
    }
}