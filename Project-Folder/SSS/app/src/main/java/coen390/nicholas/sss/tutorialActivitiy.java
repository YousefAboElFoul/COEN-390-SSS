package coen390.nicholas.sss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class tutorialActivitiy extends AppCompatActivity
{
    //---------------------------------------------Activity Variables--------------------------------------------------------
    protected static final String TAG = "Tutorial Activity";

    sharedPreference sharePreferences;
    static int language;

    TextView title;

    //----------for the listview----------------
    ListView quiz;
    ArrayList<quizTracking> quizList = new ArrayList<>();
    static quizTracking quiz1;
    static quizTracking quiz2;
    static quizTracking quiz3;


    //---------for setting the quiz----------------
    static int testLevel;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activitiy);

        sharePreferences = new sharedPreference(this);

        language = sharePreferences.getLanguage();

        title = (TextView) findViewById(R.id.tutTit);

        Log.d(TAG, "The onCreate event");

        setQuiz();

        quizList.add(quiz1);
        quizList.add(quiz2);
        quizList.add(quiz3);

        String titleText = "Select Your Level";
        if (language == 2) {titleText = "Choisi Votre Niveau";}
        title.setText(titleText);

        //function to set the listview
        setList(); //go to setlist function
    }

    public void setQuiz()
    {
        if (language == 1) {
            quiz1 = new quizTracking(1, " Learn How To Sign The Alphabet");
            quiz2 = new quizTracking(2, " Test Your Skills Against 10 Random Letters");
            quiz3 = new quizTracking(3, " Dare to Challenge Yourself Against Some Words");
        }
        else {
            quiz1 = new quizTracking(1, " Pratique l'alphabet");
            quiz2 = new quizTracking(2, " Compétition contre 10 lettres");
            quiz3 = new quizTracking(3, " Peux-tu battres des mots...");
        }
       // quiz1.setInitialScore(sharePreferences.getSC1());
       // quiz2.setInitialScore(sharePreferences.getSC2());
       // quiz3.setInitialScore(sharePreferences.getSC3());
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

    public static int getLanguage(){ return language;}


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
