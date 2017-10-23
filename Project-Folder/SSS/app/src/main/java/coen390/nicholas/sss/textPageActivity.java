package coen390.nicholas.sss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class textPageActivity extends AppCompatActivity {

    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;

    //--------to LOG textPage events-----------
    protected static final String TAG = "textActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_page);
        Log.d(TAG,"The onCreate() event");

        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.textTitle);
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
}
