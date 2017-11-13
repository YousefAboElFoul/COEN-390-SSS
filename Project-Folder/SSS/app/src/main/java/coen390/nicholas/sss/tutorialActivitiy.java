package coen390.nicholas.sss;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import coen390.nicholas.sss.quizTracking;

public class tutorialActivitiy extends AppCompatActivity
{
    //---------------------------------------------Activity Variables--------------------------------------------------------
    protected static final String TAG = "Tutorial Activity";
    ListView levelList;
    ArrayList<quizTracking> quizList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        Log.d(TAG, "The onCreate event");

        quizTracking quiz1 = new quizTracking("1", "Test Your skills against the alphabet");
        quizTracking quiz2 = new quizTracking("2", "Dare to Challenge Yourself Against Some Words");
        quizList.add(quiz1);
        quizList.add(quiz2);

        //function to set the listview
        setList(); //go to setlist function
    }

    //function to create the listview
    public void setList()
    {
        Log.d(TAG, "The setList event");
        ListView quiz = (ListView) findViewById(R.id.tutLvls);

        customTutorialListView adapter = new customTutorialListView(this, R.layout.tutlist, quizList);
        quiz.setAdapter(adapter);
    }

}
