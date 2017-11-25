package coen390.nicholas.sss;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPreference {

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
    
}