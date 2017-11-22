package coen390.nicholas.sss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;
    TextView languageSelection = null;
    TextView voiceSelection = null;
    TextView bluetoothSelection = null;
    private Spinner spinner;
    Button btn;

    //----------options for language-------------
    private static final String[]paths = {"English", "Français", "Cameron","Kharma"};

    //------------track variables----------------
    private static int languageTrack = 1;
    private static boolean voice = true;

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
        languageSelection = (TextView) findViewById(R.id.language_selection);
        voiceSelection = (TextView) findViewById(R.id.voice_output);
        bluetoothSelection = (TextView) findViewById(R.id.bluetooth_calibration);
        btn = (Button) findViewById(R.id.button_gotobluetooth);
        spinner = (Spinner)findViewById(R.id.spinner);

        setText();
        setSpinner();

    }

    private void setText()
    {
        String titleText = "SETTINGS";
        String languageText = "Language: ";
        String voiceText = "Voice Output";
        String bluetoothText = "Bluetooth Configuration";
        String bluetoothButton = "Configure";

        if (languageTrack == 2)
        {
            titleText = "PARAMÈTRES";
            languageText = "Langue: ";
            voiceText = "Translation avec Voix";
            bluetoothText = "Connection Bluetooth";
            bluetoothButton = "Configuration";
        }

        title.setText(titleText);
        languageSelection.setText(languageText);
        voiceSelection.setText(voiceText);
        bluetoothSelection.setText(bluetoothText);
        btn.setText(bluetoothButton);
    }

    //----------------------------------Setup spinner-------------------------------
    private void setSpinner()
    {
        // set up spinner for language selection
        ArrayAdapter<String> adapter = new ArrayAdapter<>(settings.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    //-------------------------------------------for going to bluetooth------------------------------------------------
    public void goBluetooth(View view)
    {
        Intent startIntent = new Intent(settings.this, Bluetooth.class);
        startActivity(startIntent);
    }

    //---------------------------------------For when the user choses to turn off voice------------------------------------
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxVoice:
                voice = checked;
                break;
        }
    }

    public static boolean getVoiceOption(){return voice;}

    //-------------------------------------Selection for the language dropdown----------------------------------------------
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            //run code depending on language selection
            case 0:
                Toast.makeText(getApplicationContext(), "English selected.", Toast.LENGTH_SHORT).show();
                languageTrack = 1;
                setText();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "French selected.", Toast.LENGTH_SHORT).show();
                languageTrack = 2;
                setText();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Aha Good One", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "Very Good One.", Toast.LENGTH_SHORT).show();
                break;
        }}

    public void onNothingSelected(AdapterView<?> parent) {}

    public static int getLanguageSelection(){ return languageTrack; }


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
        Intent startIntent = new Intent(settings.this, wordPageActivity.class);
        startActivity(startIntent);
    }
}
