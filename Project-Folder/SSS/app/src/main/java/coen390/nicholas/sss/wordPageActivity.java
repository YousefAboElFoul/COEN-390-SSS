package coen390.nicholas.sss;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
import java.util.Date;

public class wordPageActivity extends AppCompatActivity {

    BluetoothConnectionService mmo;

    String send1 ="1";
    byte[] bytes;

    //--------------------------------------------Declaring variables----------------------------------------------
    sharedPreference sharePreferences;
    //-------for objects needed in the activity-------
    TextView title = null;
    TextView showText = null;
    Button getWord = null;
    Button addLetter = null;

    //--------to LOG textPage events-----------
    protected static final String TAG = "textActivity";

    //------------Voice variable-----------------
    TextToSpeech speaking;

    //----------To control word making-----------
    boolean word = false;
    String wording = "";


    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_page);
        Log.d(TAG,"The onCreate() event");

        bytes = send1.getBytes(Charset.defaultCharset());
        sharePreferences = new sharedPreference(this);

        //reference on initialization:
        //https://www.tutorialspoint.com/android/android_text_to_speech.htm
        if (sharePreferences.getLanguage() == 2)
        {
            speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        speaking.setLanguage(Locale.UK);
                        if (settings.getLanguageSelection() == 2) {
                            speaking.setLanguage(Locale.CANADA_FRENCH);
                        }
                    }
                }
            });
        }
        else {
            speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        speaking.setLanguage(Locale.UK);
                        if (settings.getLanguageSelection() == 2) {
                            speaking.setLanguage(Locale.US);
                        }
                    }
                }
            });
        }

        hash.setAlphabets();

        setupUI();
        if (sharePreferences.getConnection()) {
            setText();
        }
        else { setNoConnection();}
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.textTitleW);
        showText = (TextView) findViewById(R.id.viewWord);
        getWord = (Button) findViewById(R.id.getWord);
        addLetter = (Button) findViewById(R.id.addLetter);
    }

    //---------------------------------------set the text base on app language--------------------------------------
    private void setText()
    {
            String Title = "TRANSLATION PAGE";
            String getWordText = "Begin";
            String addLetterText = "Add a Letter";

            if (sharePreferences.getLanguage() == 2) {
                Title = "PAGE DE TRANSLATION";
                getWordText = "Commencer";
                addLetterText = "Ajouter un Lettre";
            }

            title.setText(Title);
            getWord.setText(getWordText);
            addLetter.setText(addLetterText);

    }

    private void setNoConnection(){
        String notConnected = "CONNECT TO BLUETOOTH!";

        if (sharePreferences.getLanguage() == 2) {
            notConnected = "FAIT LA CONNECTION AVEC BLUETOOTH";
        }

        title.setText(notConnected);
        getWord.setVisibility(View.INVISIBLE);
        addLetter.setVisibility(View.INVISIBLE);
    }

    //-------------------------------------Function for monitoring the Word making----------------------------------------
    public void makingWord(View view)
    {
        if (sharePreferences.getConnection()) {
            //make bool variable false if its true, and true if its false
            if (word) {
                if (settings.getVoiceOption()) {
                    voiceWord();
                }

                word = false;
                String begin = "BEGIN TRANSLATING";
                if (sharePreferences.getLanguage() == 2){ begin = "COMMENCER LA TRANSLATION";}
                getWord.setText(begin);
                wording = "";
                addLetter.setVisibility(View.INVISIBLE);
            } else {
                word = true;
                String end = "END";
                if (sharePreferences.getLanguage() == 2){ end = "TERMINÉ";}
                getWord.setText(end);
                addLetter.setVisibility(View.VISIBLE);
                showText.setText(wording);
            }
        }
        else { setNoConnection();}
    }

    public void addToWord(View view)
    {

        if (sharePreferences.getConnection()) {
            //-------Generate a random number from 1-26 for the indexes--------
            //Random rndIndex = new Random();
            //int hashIndex = rndIndex.nextInt(26) + 1;

            if (Bluetooth.mBTDevice ==  null) {
                Log.d(TAG, "No Connection is established.....");
                sharePreferences.saveConnection(false);
                setNoConnection();
            }
            else{
                Bluetooth.mBluetoothConnection.write(bytes);
                if (BluetoothConnectionService.getConnect())
                {
                    sharePreferences.saveConnection(true);
                    //String letter = hash.getAlphabets(hashIndex);
                    Log.d(TAG, "IS the output being sent:" + BluetoothConnectionService.Print());

                    try {
                        Thread.sleep(2500);
                    }
                    catch (Exception e){e.printStackTrace();}

                    String letter = BluetoothConnectionService.Print();

                    wording = wording + letter;


                    showText.setText(wording);}

                else {setNoConnection();}
            }
        }
        else {setNoConnection();}
   }

    //-------------------------------------Function for getting and outputting a letter----------------------------------------
    //potential to customize our own voice:
    //https://android.stackexchange.com/questions/14713/is-there-a-way-to-change-the-text-to-speech-persons-voice
    public void voiceWord()
    {
        //reference on using the if to fix the speak issue:
        //https://stackoverflow.com/questions/30280082/android-tts-sound-leaked-service-connection-and-speak-deprecated
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            speaking.speak(wording, TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            speaking.speak(wording, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    public void goHelp(View view)
    {
        Intent startIntent = new Intent(wordPageActivity.this, help.class);
        startActivity(startIntent);
    }

    public void goTutorial(View view)
    {
        Intent startIntent = new Intent(wordPageActivity.this, tutorialActivitiy.class);
        startActivity(startIntent);
    }

    public void goHome(View view)
    {
        Intent startIntent = new Intent(wordPageActivity.this, MainActivity.class);
        startActivity(startIntent);
    }

    public void goSettings(View view)
    {
        Intent startIntent = new Intent(wordPageActivity.this, settings.class);
        startActivity(startIntent);
    }
}
