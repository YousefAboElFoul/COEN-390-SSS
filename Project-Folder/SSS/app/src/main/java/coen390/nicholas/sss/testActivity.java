package coen390.nicholas.sss;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

public class testActivity extends AppCompatActivity
{
    //-------------------------------------------Necessary Variables------------------------------------------
    sharedPreference sharePreferences;
    String send1 ="1";
    byte[] bytes;

    //Layout Variable
    TextView lvlShow;
    TextView question;
    TextView answer;
    Button nextQ;
    Button beginAnswer;

    //test control variables
    int level;
    int currentQ = 0;
    String letterAns = "";
    String theQuestion = "";
    Boolean restart = false;
    Boolean receivingAnswer = true;
    int allQuestions[] = new int[10];

    TextToSpeech speaking;

    //NEED TO ADD CHECK FOR COMPLETITION WHEN IN THE ON CREATE
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bytes = send1.getBytes(Charset.defaultCharset());
        sharePreferences = new sharedPreference(this);

        if (tutorialActivitiy.getLanguage() == 2) {
            speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        speaking.setLanguage(Locale.CANADA_FRENCH);
                    }
                }
            });
        }
        else {
            speaking = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        speaking.setLanguage(Locale.UK);
                    }
                }
            });
        }

        lvlShow = (TextView) findViewById(R.id.showLvl);
        question = (TextView) findViewById(R.id.showQ);
        answer = (TextView) findViewById(R.id.viewAnswer);
        nextQ = (Button) findViewById(R.id.nextQ);
        beginAnswer = (Button) findViewById(R.id.addAnswer);

        level = tutorialActivitiy.getLvl();
        currentQ = tutorialActivitiy.getCurrent(level);

        //check if already completed
        if (tutorialActivitiy.getCurrent(level)  == tutorialActivitiy.getTotal(level))
        {
            //set text
            String text = "Completed";
            nextQ.setText(text);
            String title = "Welcome To Level " + level;
            lvlShow.setText(title);

            //set the buttons
            nextQ.setVisibility(View.VISIBLE);
            beginAnswer.setVisibility(View.INVISIBLE);

            //set the restart mode
            completeGame();
        }
        else {
            setText();
            setQuestion();
        }
    }

    //----function to set the title of the page:  use this for when we change the language-----------
    private void setText()
    {
        String title = "Welcome To Level " + level;
        String nextQuestion = "Next Question";
        String addAnswerButton = "Begin";

        if (tutorialActivitiy.getLanguage() == 2)
        {
            title = "Bienvenue à niveau " + level;
            nextQuestion = "Prochaine question";
            addAnswerButton = "Commençer";
        }

        nextQ.setText(nextQuestion);
        lvlShow.setText(title);
        beginAnswer.setText(addAnswerButton);
    }

    private void setQuestion()
    {
        getQuestion();
        String ask = "Sign the Following: " + theQuestion;

        if (tutorialActivitiy.getLanguage() == 2)
        {
            ask = "Signe la suivante: " + theQuestion;
        }

        question.setText(ask);
    }

    private void getQuestion()
    {
        Random rndIndex = new Random();
        Boolean foundNew = false;
        int qIndex = 0;

        if (level == 1) {
            theQuestion = quizTracking.getQuestion(tutorialActivitiy.getCurrent(level));
        }
        else if (level == 2){
            while(!foundNew) { //loop until you find a new question index
                qIndex = rndIndex.nextInt(26); //get a new random index from 0 to 25
                foundNew = true;
                if (tutorialActivitiy.getCurrent(level) != 0) {
                    for (int i = 0; i < tutorialActivitiy.getCurrent(level); i++) { //check if it exist
                        if (allQuestions[i] == qIndex) //if it doesnt
                        {
                            foundNew = false;
                        }
                    }
                }
            }
            //once you find a new index
            allQuestions[tutorialActivitiy.getCurrent(level)] = qIndex;
            theQuestion = quizTracking.getQuestion(qIndex);
        }
        else if (level == 3){
            //System.out.println("current is: " + tutorialActivitiy.getCurrent(level));

            while(!foundNew) { //loop until you find a new question index
                qIndex = rndIndex.nextInt(10) + 26; //get a new random index from 0 to 25
                //System.out.println("The new index is: " + qIndex);
                if (tutorialActivitiy.getCurrent(level) != 0) {
                    for (int i = 0; i < tutorialActivitiy.getCurrent(level); i++) { //check if it exist
                        if (allQuestions[i] != qIndex) //if it doesnt
                        {
                            foundNew = true;
                        } else {
                            foundNew = false;
                        }
                    }
                }
                else {foundNew = true;}
            }
            //once you find a new index
            allQuestions[tutorialActivitiy.getCurrent(level)] = qIndex;
            theQuestion = quizTracking.getQuestion(qIndex);
        }
    }

    //----------------------------------------Function for when the user begins answering-------------------------------------
    public void beginQ(View view)
    {
        answer.setBackgroundColor(Color.TRANSPARENT);

        if (receivingAnswer) {
            letterAns += addLetter();
            answer.setText(letterAns);
            if(theQuestion.length() <= letterAns.length())
            {
                receivingAnswer = false;
            }
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

    public String addLetter()
    {
        if (sharePreferences.getConnection()) {
            if (Bluetooth.mBTDevice ==  null) {
                sharePreferences.saveConnection(false);
            }
            else{
                Bluetooth.mBluetoothConnection.write(bytes);
                sharePreferences.saveConnection(true);
            }

            try {
                Thread.sleep(2500);
            }
            catch (Exception e){e.printStackTrace();}

            return BluetoothConnectionService.Print();

        }
        else {if (tutorialActivitiy.getLanguage() == 2){return "CONNECTEZ AVEC BLUETOOTH";} return "CONNECT TO BLUETOOTH";}
    }
    //--------------------------------------Function to check if answer is corrected------------------------------------------
    public void checkQ(String ans)
    {
        if (theQuestion.equals(ans))
        {
            //increment level
            tutorialActivitiy.setCurrent(level);

            answer.setBackgroundColor(Color.argb(100, 0, 200, 0));

            beginAnswer.setVisibility(View.INVISIBLE);
            nextQ.setVisibility(View.VISIBLE);
            if (tutorialActivitiy.getCurrent(level)  == tutorialActivitiy.getTotal(level))
            {
                String text = "Completed";
                if (tutorialActivitiy.getLanguage() == 2){ text = "Terminé";}
                nextQ.setText(text);

                completeGame();
            }
        }
        else
        {

            answer.setBackgroundColor(Color.argb(100, 200, 0, 0));
            if (ans.equals("CONNECTEZ AVEC BLUETOOTH") || ans.equals("CONNECT TO BLUETOOTH") ){answer.setBackgroundColor(Color.argb(0, 0, 0, 0));}


            reset();
        }
    }

    //------------------------------------Function to reset the test-------------------------------------
    public void reset()
    {
        receivingAnswer = true;
        letterAns = "";
        nextQ.setVisibility(View.INVISIBLE);
        try {
            Thread.sleep(500);
        }
        catch (Exception e)
        {e.printStackTrace();}
        answer.setText("");

    }

    //---------------------------------------Function to set the game as complete----------------------------------------
    public void completeGame(){

        String restartText = "Restart";
        String textComplete = "Level Completed!";

        if (tutorialActivitiy.getLanguage() == 2)
        {
            restartText = "Recommencer";
            textComplete = "Niveau terminé!";

            Toast toast = Toast.makeText(getApplicationContext(), "FÉLICITATIONS! VOUS AVEZ TERMINÉ LA NIVEAU :)", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "CONGRATS! YOU COMPLETED THIS LEVEL :)", Toast.LENGTH_LONG);
            toast.show();
        }

        nextQ.setText(restartText);
        question.setText(textComplete);
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


    //--------------------------------------------------Menu Functions---------------------------------------------------
    public void goTranslate(View view)
    {
        Intent startIntent = new Intent(testActivity.this, wordPageActivity.class);
        startActivity(startIntent);
    }

    public void goHelp(View view)
    {
        Intent startIntent = new Intent(testActivity.this, help.class);
        startActivity(startIntent);
    }

    public void goHome(View view)
    {
        Intent startIntent = new Intent(testActivity.this, MainActivity.class);
        startActivity(startIntent);
    }

    public void goSettings(View view)
    {
        Intent startIntent = new Intent(testActivity.this, settings.class);
        startActivity(startIntent);
    }

    public void goTutorial(View view)
    {
        Intent startIntent = new Intent(testActivity.this, tutorialActivitiy.class);
        startActivity(startIntent);
    }
}
