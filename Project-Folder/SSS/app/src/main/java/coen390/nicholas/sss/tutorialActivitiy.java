package coen390.nicholas.sss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class tutorialActivitiy extends AppCompatActivity
{
    //---------------------------------------------Activity Variables--------------------------------------------------------
    protected static final String TAG = "Tutorial Activity";
    ListView quiz;
    ArrayList<quizTracking> quizList = new ArrayList<>();
    quizTracking quiz1 = new quizTracking("1", "Test Your skills against the alphabet");
    quizTracking quiz2 = new quizTracking("2", "Dare to Challenge Yourself Against Some Words");

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        Log.d(TAG, "The onCreate event");


        quizList.add(quiz1);
        quizList.add(quiz2);

        //function to set the listview
        setList(); //go to setlist function
    }

    //function to create the listview
    public void setList() {
        Log.d(TAG, "The setList event");
        quiz = (ListView) findViewById(R.id.tutLvls);

        customTutorialListView adapter = new customTutorialListView(this, R.layout.tutlist, quizList);
        quiz.setAdapter(adapter);

        setListener();

    }

    public void setListener(){
        //----------When Items on list are pressed-----------------
        quiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                switch (position) {
                    case 0: //case level 1
                        Intent startIntent = new Intent(tutorialActivitiy.this, testActivity.class);
                        startActivity(startIntent);
                        break;
                    case 1:
                        startIntent = new Intent(tutorialActivitiy.this, testActivity.class);
                        startActivity(startIntent);
                        break;
                }

            }
        });
    }

}
