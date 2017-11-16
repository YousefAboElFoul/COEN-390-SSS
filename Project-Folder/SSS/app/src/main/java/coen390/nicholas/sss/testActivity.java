package coen390.nicholas.sss;

import android.graphics.Color;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class testActivity extends AppCompatActivity
{
    //-------------------------------------------Necessary Variables------------------------------------------
    int level;
    int currentQ = 0;
    TextView lvlShow;
    TextView question;
    TextView answer;
    Button nextQ;
    Button beginAnswer;
    TextToSpeech speaking;
    Boolean receivingAnswer = true;
    String letterAns = "";
    Boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    speaking.setLanguage(Locale.UK);
                }
            }
        });

        lvlShow = (TextView) findViewById(R.id.showLvl);
        question = (TextView) findViewById(R.id.showQ);
        answer = (TextView) findViewById(R.id.viewAnswer);
        answer.setBackgroundColor(Color.argb(100, 100, 100, 100));
        nextQ = (Button) findViewById(R.id.nextQ);
        beginAnswer = (Button) findViewById(R.id.addAnswer);

        level = tutorialActivitiy.getLvl();
        currentQ = tutorialActivitiy.getCurrent(level);

        setText();
        setQuestion();
    }

    //----function to set the title of the page:  use this for when we change the language-----------
    private void setText()
    {
        String title = "Welcome To Level " + level;
        String nextQuestion = "Next Question";
        String addAnswerButton = "Begin";

        nextQ.setText(nextQuestion);
        lvlShow.setText(title);
        beginAnswer.setText(addAnswerButton);
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

    //----------------------------------------Function for when the user begins answering-------------------------------------
    public void beginQ(View view)
    {
        answer.setBackgroundColor(Color.argb(100, 100, 100, 100));

        //count++;
        //while (count != 2) {
            //String letter = BluetoothConnectionService.Print();
        //}
        if (receivingAnswer) {
            letterAns += quizTracking.getQuestion(tutorialActivitiy.getCurrent(level));
            answer.setText(letterAns);
            receivingAnswer = false;
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                speaking.speak(letterAns, TextToSpeech.QUEUE_FLUSH, null, null);
            }
            else {
                speaking.speak(letterAns, TextToSpeech.QUEUE_FLUSH, null);
            }
            checkQ(letterAns);
        }
    }

    //--------------------------------------Function to check if answer is corrected------------------------------------------
    public void checkQ(String ans)
    {
        if (quizTracking.getQuestion(tutorialActivitiy.getCurrent(level)).equals(ans))
        {
            answer.setBackgroundColor(Color.argb(100, 0, 200, 0));

            beginAnswer.setVisibility(View.INVISIBLE);
            nextQ.setVisibility(View.VISIBLE);
            if (tutorialActivitiy.getCurrent(level) - 1 == tutorialActivitiy.getTotal(level))
            {
                String text = "Completed";
                nextQ.setText(text);

                completeGame();
            }
            else{
                //increment level
                tutorialActivitiy.setCurrent(level);
            }
        }
        else
        {
            answer.setBackgroundColor(Color.argb(100, 200, 0, 0));
            //reset();
        }
    }

    //------------------------------------Function to reset the test-------------------------------------
    public void reset()
    {
        receivingAnswer = true;
        letterAns = "";
        nextQ.setVisibility(View.INVISIBLE);
        answer.setText("");
        answer.setBackgroundColor(Color.argb(100, 100, 100, 100));
    }

    //---------------------------------------Function to set the game as complete----------------------------------------
    public void completeGame(){
        Toast toast = Toast.makeText(getApplicationContext(), "CONGRATS! YOU COMPLETED THIS LEVEL :)", Toast.LENGTH_LONG);
        toast.show();

        String restartText = "Restart";
        nextQ.setText(restartText);
        restart = true;
    }
    //---------------------------------------Function to go to the next question-----------------------------------------
    public void goToNextQ(View view)
    {
        beginAnswer.setVisibility(View.VISIBLE);
        if (restart)
        {
            restart = false;
            setText();
            tutorialActivitiy.setNew(level);
            reset();
            setQuestion();
        }
        else {
                reset();
                //get next question
                setQuestion();
        }
    }
}
