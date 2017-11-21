package coen390.nicholas.sss;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import coen390.nicholas.sss.quizTracking;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;



public class tutorialActivitiy extends AppCompatActivity
{
    //---------------------------------------------Activity Variables--------------------------------------------------------
    protected static final String TAG = "Tutorial Activity";


    //----------for the listview----------------
    ListView quiz;
    ArrayList<quizTracking> quizList = new ArrayList<>();
    static quizTracking quiz1 = new quizTracking(1, "Learn How To Sign The Alphabet");
    static quizTracking quiz2 = new quizTracking(2, "Test Your Skills Against 10 Random Letters");
    static quizTracking quiz3 = new quizTracking(3, "Dare to Challenge Yourself Against Some Words");


    //---------for setting the quiz----------------
    static int testLevel;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        Log.d(TAG, "The onCreate event");


        quizList.add(quiz1);
        quizList.add(quiz2);
        quizList.add(quiz3);

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
                        testLevel = 1;
                        Intent startIntent = new Intent(tutorialActivitiy.this, testActivity.class);
                        startActivity(startIntent);
                        break;
                    case 1:
                        testLevel = 2;
                        startIntent = new Intent(tutorialActivitiy.this, testActivity.class);
                        startActivity(startIntent);
                        break;
                    case 2:
                        testLevel = 3;
                        startIntent = new Intent(tutorialActivitiy.this, testActivity.class);
                        startActivity(startIntent);
                        break;
                }

            }
        });
    }

    //----------------------------------------return the current level--------------------------------------------
    public static int getLvl(){ return testLevel; }

    //gets the number of correct
    public static int getCurrent(int i)
    {
        int correct = 0;
        if (i == 1){ correct = quiz1.getNmbCorrect();}
        else if (i == 2) { correct = quiz2.getNmbCorrect();}
        else if (i == 3) { correct = quiz3.getNmbCorrect();}

        return correct;
    }

    //sets the new correct
    public static void setCurrent(int i)
    {
        if (i == 1){ quiz1.setCorrect();}
        else if (i == 2) { quiz2.setCorrect();}
        else if (i == 3) {quiz3.setCorrect();}
    }

    public static void setNew(int i)
    {
        if (i == 1){ quiz1.setNewGame();}
        else if (i == 2) { quiz2.setNewGame();}
        else if (i == 3) { quiz3.setNewGame();}
    }
    //get the score
    public static String getScore(int i)
    {
        if (i == 1){ return quiz1.getScore();}
        else if (i == 2) { return quiz2.getScore();}
        else if (i == 3) { return quiz3.getScore();}

        return "";
    }

    //get the total questions
    public static int getTotal(int i)
    {
        if (i == 1){ return quiz1.getTotal();}
        else if (i == 2) { return quiz2.getTotal();}
        else if (i == 3) { return quiz3.getTotal();}

        return 0;
    }


    //--------------------------------------------Menu Functions------------------------------------------------------------
    public void goTranslate(View view)
    {
        Intent startIntent = new Intent(tutorialActivitiy.this, wordPageActivity.class);
        startActivity(startIntent);
    }

    public void goHelp(View view)
    {
        Intent startIntent = new Intent(tutorialActivitiy.this, help.class);
        startActivity(startIntent);
    }

    public void goHome(View view)
    {
        Intent startIntent = new Intent(tutorialActivitiy.this, MainActivity.class);
        startActivity(startIntent);
    }

    public void goSettings(View view)
    {
        Intent startIntent = new Intent(tutorialActivitiy.this, settings.class);
        startActivity(startIntent);
    }
}
