package coen390.nicholas.sss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testActivity extends AppCompatActivity
{
    //-------------------------------------------Necessary Variables------------------------------------------
    int level;
    int currentQ = 0;
    TextView lvlShow;
    TextView question;
    Button nextQ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        lvlShow = (TextView) findViewById(R.id.showLvl);
        question = (TextView) findViewById(R.id.showQ);
        nextQ = (Button) findViewById(R.id.nextQ);

        level = tutorialActivitiy.getLvl();
        currentQ = tutorialActivitiy.getCurrent(level);

        setText();
        setQuestion();
    }

    //----function to set the title of the page:  use this for when we change the language-----------
    private void setText()
    {
        String title = "Welcome To Level " + level;
        lvlShow.setText(title);

        String nextQuestion = "Next Question";
        nextQ.setText(nextQuestion);
    }

    private void setQuestion()
    {
        String theQuestion = "Question undefined";
        if (level == 1) {
            theQuestion = "Sign the Following: " + quizTracking.getQuestion(tutorialActivitiy.getCurrent(level));
        }
        else if (level == 2){
            theQuestion = "Sign the Following: " + quizTracking.getQuestion(2 * tutorialActivitiy.getCurrent(level));
        }
        question.setText(theQuestion);
    }

    public void goToNextQ(View view)
    {
        tutorialActivitiy.setCurrent(level);
        setQuestion();
    }
}
