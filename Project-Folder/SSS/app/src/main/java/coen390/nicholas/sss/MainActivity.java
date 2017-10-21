package coen390.nicholas.sss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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
        hello = (TextView) findViewById(R.id.helloText); //link button
        goText = (Button) findViewById(R.id.getText);
        goVoice = (Button) findViewById(R.id.getVoice);
    }

}
