package coen390.nicholas.sss;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class tutorialActivitiy extends AppCompatActivity {

    ListView simpleList;
    String alphabet[] = {"A", "B", "C", "D", "E", "F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        setContentView(R.layout.activity_tutorial_activitiy);
        simpleList = (ListView)findViewById(R.id.letterList);
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
        simpleList.setAdapter(arrayAdapter);
    }
}
