package coen390.nicholas.sss;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class textPageActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;
    TextView showText = null;
    Button getLetter = null;

    //--------to LOG textPage events-----------
    protected static final String TAG = "textActivity";

    //------------Voice variable-----------------
    TextToSpeech speaking;


    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_page);
        Log.d(TAG,"The onCreate() event");

        //reference on initialization:
        //https://www.tutorialspoint.com/android/android_text_to_speech.htm
        speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    speaking.setLanguage(Locale.UK);
                }
            }
        });

        hash.setAlphabets();
        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.textTitle);
        showText = (TextView) findViewById(R.id.viewLetter);
        getLetter = (Button) findViewById(R.id.getLetterV);
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    //------when the action button gets pressed--------
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //-----------when items are selected----------------
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(TAG, "The onOptions event");
        switch (item.getItemId())
        {
            //action to switch to settings gets pressed
            case R.id.goSettings:
                Intent startIntent = new Intent(textPageActivity.this, settings.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //-------------------------------------Function for getting and outputting a letter----------------------------------------
    //potential to customize our own voice:
    //https://android.stackexchange.com/questions/14713/is-there-a-way-to-change-the-text-to-speech-persons-voice
    public void outputLetter(View view)
    {
        //-------Generate a random number from 1-26 for the indexes---------
        Random rndIndex = new Random();
        int hashIndex = rndIndex.nextInt(26) + 1;

        String letter = hash.getAlphabets(hashIndex);

        showText.setText(letter);

        //reference on using the if to fix the speak issue:
        //https://stackoverflow.com/questions/30280082/android-tts-sound-leaked-service-connection-and-speak-deprecated
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            speaking.speak(letter, TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            speaking.speak(letter, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
