package coen390.nicholas.sss;

import android.content.Intent;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View.OnTouchListener;

public class MainActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------
    private int _xDelta;
    private int _yDelta;
    private ViewGroup rootLayout;
     int  test =-250;

    //-------for objects needed in the home page-------
    TextView title = null;
    TextView hello = null;
    //-----------drawable menu------------------------------
   private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    //--------to LOG mainActivity events-----------
    protected static final String TAG = "MainActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
        setupUI();

    //    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
    //   circleMenu.setLayoutParams(layoutParams);
     //   circleMenu.setOnTouchListener(new ChoiceTouchListener());


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




    }

   /* private final class ChoiceTouchListener implements OnTouchListener

    {
        public boolean onTouch (View view, MotionEvent event){
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
               RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
               _yDelta = Y - lParams.topMargin;

                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin =  -250;
                layoutParams.bottomMargin =  -250;
                view.setLayoutParams(layoutParams);
                break;
        }
      //  rootLayout.invalidate();
        return true;
    }*/



//}
