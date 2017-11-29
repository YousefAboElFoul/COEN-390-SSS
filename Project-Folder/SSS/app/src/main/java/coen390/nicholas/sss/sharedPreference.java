package coen390.nicholas.sss;

import android.content.Context;
import android.content.SharedPreferences;


public class sharedPreference {


    BluetoothConnectionService mBluetooth;
    private SharedPreferences sharedPreferences; //class object

    //constructor
    public sharedPreference(Context context)
    {
        sharedPreferences = context.getSharedPreferences("Preference", Context.MODE_PRIVATE);
    }

    //function to save the bluetooth connection
    public void saveConnection(Boolean connection)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("connection",connection);
        editor.apply();
    }
    //function to get the name
    public boolean getConnection()
    {
        return sharedPreferences.getBoolean("connection", false);
    }

    public void saveLanguage(int language)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("language",language);
        editor.apply();
    }

    public int getLanguage() { return sharedPreferences.getInt("language", 1);}

    public void voiceOut(Boolean voice)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("voice",voice);
        editor.apply();
    }
    //function to get the name
    public boolean getVoiceOut()
    {
        return sharedPreferences.getBoolean("voice", true);
    }

    public void isOn(Boolean on)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("on",on);
        editor.apply();
    }

    public boolean getOn()
    {
        return sharedPreferences.getBoolean("on", false);
    }

    /*
    public void nmbC1(int score)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score1",score);
        editor.apply();
    }

    public int getSC1(){ return sharedPreferences.getInt("score1", 0);}

    public void nmbC2(int score)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score2",score);
        editor.apply();
    }

    public int getSC2(){ return sharedPreferences.getInt("score2", 0);}

    public void nmbC3(int score)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score3",score);
        editor.apply();
    }

    public int getSC3(){ return sharedPreferences.getInt("score3", 0);}*/
}