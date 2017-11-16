package coen390.nicholas.sss;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import coen390.nicholas.sss.quizTracking;

public class tutorialActivitiy extends AppCompatActivity {


    public void goTranslate(View view)
    {
        Intent startIntent = new Intent(tutorialActivitiy.this, letterPage.class);
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
