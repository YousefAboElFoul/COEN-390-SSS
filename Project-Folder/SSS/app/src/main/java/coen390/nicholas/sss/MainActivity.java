package coen390.nicholas.sss;

import android.content.Intent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
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

            @Override
            public void onMenuSelected(int index) {
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

        circleMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
    });
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


    }
//}
