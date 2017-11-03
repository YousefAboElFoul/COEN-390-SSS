package coen390.nicholas.sss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class help extends AppCompatActivity
{
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView showLetter = null;
    ListView myLetters;
    String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    //--------to LOG textPage events-----------
    protected static final String TAG = "helpActivity";

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Log.d(TAG,"The onCreate() event");

        setupUI();
        listviewStuff();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        showLetter = (TextView) findViewById(R.id.showHelpLetter);
        myLetters = (ListView)findViewById(R.id.letterList);
        myLetters.setClickable(true);
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    //------when the action button gets pressed--------
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //-----------when items are selected----------------
    //attempted to make an onClick in the menu, but it crashed the app...
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "The onOptions event");
        Intent startIntent;
        switch (item.getItemId()) {
            //action to switch to the letter page
            case R.id.goLetter:
                startIntent = new Intent(help.this, letterPage.class);
                startActivity(startIntent);
                return true;
            //action to switch to word page
            case R.id.goWord:
                startIntent = new Intent(help.this, wordPageActivity.class);
                startActivity(startIntent);
                return true;
            //action to switch to help
            case R.id.goHelp:
                return true;
            //action to switch to settings
            case R.id.goSettings:
                startIntent = new Intent(help.this, settings.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //-----------------------------------Function that control listview environment------------------------------------------
    private void listviewStuff()
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_tutorial, R.id.letterText, alphabet)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);
                if(position %2 == 1)
                {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.rgb(130, 130, 130));
                }
                else
                {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.rgb(100, 100, 200));
                }
                return view;
            }
        };
        myLetters.setAdapter(arrayAdapter);


        myLetters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                final ImageView imageView = (ImageView) findViewById(R.id.helpImage);
                switch (position)
                {
                    case 0:
                        showLetter.setText("A");
                        imageView.setImageResource(R.drawable.lettera);
                        break;
                    case 1:
                        showLetter.setText("B");
                        imageView.setImageResource(R.drawable.letterb);
                        break;
                    case 2:
                        showLetter.setText("C");
                        imageView.setImageResource(R.drawable.letterc);
                        break;
                    case 3:
                        showLetter.setText("D");
                        imageView.setImageResource(R.drawable.letterd);
                        break;
                    case 4:
                        showLetter.setText("E");
                        break;
                    case 5:
                        showLetter.setText("F");
                        break;
                    case 6:
                        showLetter.setText("G");
                        break;
                    case 7:
                        showLetter.setText("H");
                        break;
                    case 8:
                        showLetter.setText("I");
                        break;
                    case 9:
                        showLetter.setText("J");
                        break;
                    case 10:
                        showLetter.setText("K");
                        break;
                    case 11:
                        showLetter.setText("L");
                        break;
                    case 12:
                        showLetter.setText("M");
                        break;
                    case 13:
                        showLetter.setText("N");
                        break;
                    case 14:
                        showLetter.setText("O");
                        break;
                    case 15:
                        showLetter.setText("P");
                        break;
                    case 16:
                        showLetter.setText("Q");
                        break;
                    case 17:
                        showLetter.setText("R");
                        break;
                    case 18:
                        showLetter.setText("S");
                        break;
                    case 19:
                        showLetter.setText("T");
                        break;
                    case 20:
                        showLetter.setText("U");
                        break;
                    case 21:
                        showLetter.setText("V");
                        break;
                    case 22:
                        showLetter.setText("W");
                        break;
                    case 23:
                        showLetter.setText("X");
                        break;
                    case 24:
                        showLetter.setText("Y");
                        break;
                    case 25:
                        showLetter.setText("Z");
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
