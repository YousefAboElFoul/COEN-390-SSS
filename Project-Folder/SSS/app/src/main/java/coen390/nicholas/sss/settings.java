package coen390.nicholas.sss;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;
    private Spinner spinner;
    TextToSpeech speaking;
    private static final String[]paths = {"English", "French", "Arabic","Kharma"};
    //--------to LOG textPage events-----------
    protected static final String TAG = "settingsActivity";


    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d(TAG,"The onCreate() event");

        // set up spinner for language selection
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(settings.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.settingTitle);
        Button btn = (Button) findViewById(R.id.button_gotobluetooth);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(settings.this, Bluetooth.class);
                startActivity(startIntent);
            }
        });

        ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebuttonVoiceOn);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false); // The toggle is disabled
                    //unmute audio
                    Toast.makeText(getApplicationContext(),
                            "Toggle on.", Toast.LENGTH_SHORT).show();
                    AudioManager volumeControl = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    volumeControl.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    // The toggle is enabled
                } else {

                    Toast.makeText(getApplicationContext(),
                            "Toggle off.", Toast.LENGTH_SHORT).show();
                    AudioManager volumeControl = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    volumeControl.setStreamMute(AudioManager.STREAM_MUSIC, true);
                }
            }
        });
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
        Intent startIntent = new Intent(settings.this, letterPage.class);
        startActivity(startIntent);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            //run code depending on language selection
            case 0:
                Toast.makeText(getApplicationContext(),
                        "English selected.", Toast.LENGTH_SHORT).show();// Whatever you want to happen when the first item gets selected


                break;
            case 1:
                Toast.makeText(getApplicationContext(),
                        "French selected.", Toast.LENGTH_SHORT).show();// Whatever you want to happen when the second item gets selected


                break;
            case 2:
                Toast.makeText(getApplicationContext(),
                        "Arabic selected.", Toast.LENGTH_SHORT).show();// Whatever you want to happen when the thrid item gets selected
                break;
            case 3:
                Toast.makeText(getApplicationContext(),
                        "Kharma selected.", Toast.LENGTH_SHORT).show();// Whatever you want to happen when the thrid item gets selected
                break;
        }}

    public void onNothingSelected(AdapterView<?> parent) {

    }


}
