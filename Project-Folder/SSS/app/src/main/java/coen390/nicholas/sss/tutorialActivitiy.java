package coen390.nicholas.sss;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class tutorialActivitiy extends AppCompatActivity {

    TextView showLetter = null;
    ListView myLetters;
    String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        setContentView(R.layout.activity_tutorial_activitiy);
        showLetter = (TextView) findViewById(R.id.showHelpLetter);
        myLetters = (ListView)findViewById(R.id.letterList);
        myLetters.setClickable(true);
        listviewStuff();
    }

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
                switch (position)
                {
                    case 0:
                        showLetter.setText("A");
                        break;
                    case 1:
                        showLetter.setText("B");
                        break;
                    case 2:
                        showLetter.setText("C");
                        break;
                    case 3:
                        showLetter.setText("D");
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
                        showLetter.setText("Press a Letter to View Gesture");
                        break;
                }

            }
        });
    }
}
