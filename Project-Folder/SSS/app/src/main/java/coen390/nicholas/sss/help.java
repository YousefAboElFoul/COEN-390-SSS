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

    //--------to keep track of presses---------
    //View lastview = null;
    //int lastLetter = -1;

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
        //-------------Create the adapter-----------------
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
                    view.setBackgroundColor(Color.argb(100, 100, 100, 100));
                }
                return view;
            }
        };
        myLetters.setAdapter(arrayAdapter);

        //----------When Items on list are pressed-----------------
        myLetters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                final ImageView imageView = (ImageView) findViewById(R.id.helpImage);
                switch (position)
                {
                    case 0: //case A
                        showLetter.setText("A");
                        imageView.setImageResource(R.drawable.lettera);
                        /*view.setBackgroundColor(Color.argb(100, 10, 150, 100));
                        if(lastLetter %2 == 1) { lastview.setBackgroundColor(Color.rgb(130, 130, 130));}
                        else
                        { view.setBackgroundColor(Color.argb(100, 100, 100, 100));}
                        lastLetter = position;
                        lastview = view;*/
                        break;
                    case 1: //case B
                        showLetter.setText("B");
                        imageView.setImageResource(R.drawable.letterb);
                        break;
                    case 2: //case C
                        showLetter.setText("C");
                        imageView.setImageResource(R.drawable.letterc);
                        break;
                    case 3: //case D
                        showLetter.setText("D");
                        imageView.setImageResource(R.drawable.letterd);
                        break;
                    case 4: //case E
                        showLetter.setText("E");
                        imageView.setImageResource(R.drawable.lettere);
                        break;
                    case 5: //case F
                        showLetter.setText("F");
                        imageView.setImageResource(R.drawable.letterf);
                        break;
                    case 6: //case G
                        showLetter.setText("G");
                        imageView.setImageResource(R.drawable.letterg);
                        break;
                    case 7: //case H
                        showLetter.setText("H");
                        imageView.setImageResource(R.drawable.letterh);
                        break;
                    case 8: //case I
                        showLetter.setText("I");
                        imageView.setImageResource(R.drawable.letteri);
                        break;
                    case 9: //case J
                        showLetter.setText("J");
                        imageView.setImageResource(R.drawable.letterj);
                        break;
                    case 10: //case K
                        showLetter.setText("K");
                        imageView.setImageResource(R.drawable.letterk);
                        break;
                    case 11: //case L
                        showLetter.setText("L");
                        imageView.setImageResource(R.drawable.letterl);
                        break;
                    case 12: //case M
                        showLetter.setText("M");
                        imageView.setImageResource(R.drawable.letterm);
                        break;
                    case 13: //case N
                        showLetter.setText("N");
                        imageView.setImageResource(R.drawable.lettern);
                        break;
                    case 14: //case O
                        showLetter.setText("O");
                        imageView.setImageResource(R.drawable.lettero);
                        break;
                    case 15: //case P
                        showLetter.setText("P");
                        imageView.setImageResource(R.drawable.letterp);
                        break;
                    case 16: //case Q
                        showLetter.setText("Q");
                        imageView.setImageResource(R.drawable.letterq);
                        break;
                    case 17: //case R
                        showLetter.setText("R");
                        imageView.setImageResource(R.drawable.letterr);
                        break;
                    case 18: //case S
                        showLetter.setText("S");
                        imageView.setImageResource(R.drawable.letters);
                        break;
                    case 19: //case T
                        showLetter.setText("T");
                        imageView.setImageResource(R.drawable.lettert);
                        break;
                    case 20: //case U
                        showLetter.setText("U");
                        imageView.setImageResource(R.drawable.letteru);
                        break;
                    case 21: //case V
                        showLetter.setText("V");
                        imageView.setImageResource(R.drawable.letterv);
                        break;
                    case 22: //case W
                        showLetter.setText("W");
                        imageView.setImageResource(R.drawable.letterw);
                        break;
                    case 23: //case X
                        showLetter.setText("X");
                        imageView.setImageResource(R.drawable.letterx);
                        break;
                    case 24: //case Y
                        showLetter.setText("Y");
                        imageView.setImageResource(R.drawable.lettery);
                        break;
                    case 25: //case Z
                        showLetter.setText("Z");
                        imageView.setImageResource(R.drawable.letterz);
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
