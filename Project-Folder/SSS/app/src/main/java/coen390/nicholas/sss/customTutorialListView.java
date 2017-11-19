package coen390.nicholas.sss;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customTutorialListView extends ArrayAdapter<quizTracking>
{
        private static final String TAG = "CourseListAdapter"; //tracking tag

        private Context mContext;//variable for context
        int mResource; //variable for resource

        //custom adapter
        public customTutorialListView(Context context, int resource, ArrayList<quizTracking> level)
        {
            super(context, resource, level); //calls existing
            mContext = context;
            mResource = resource;
        }

        //customizing the getView function
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            //-------Set the content-------------
            String level = getItem(position).getLevel();
            String descrip = getItem(position).getDescription();
            String score = tutorialActivitiy.getScore(position + 1);


            //setting the inflater
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            //connecting TextView objects to textView variables
            TextView quizLvl = (TextView) convertView.findViewById(R.id.listLevel);
            TextView quizScore = (TextView) convertView.findViewById(R.id.listScore);
            TextView quizDesc = (TextView) convertView.findViewById(R.id.listDescription);

            quizLvl.setText(level); //set the text
            quizScore.setText(score);
            quizDesc.setText(descrip);

            //---------------Set the colour------------------
            if (position == 0) {
                quizLvl.setBackgroundColor(Color.argb(100, 0, 0, 130));
                quizScore.setBackgroundColor(Color.argb(100, 0, 0, 130));
                quizDesc.setBackgroundColor(Color.argb(100, 0, 0, 130));
            }
            else if (position == 1){
                quizLvl.setBackgroundColor(Color.argb(100, 130, 0, 0));
                quizScore.setBackgroundColor(Color.argb(100, 130, 0, 0));
                quizDesc.setBackgroundColor(Color.argb(100, 130, 0, 0));
            }
            else if (position == 2){
                quizLvl.setBackgroundColor(Color.argb(100, 0, 100, 0));
                quizScore.setBackgroundColor(Color.argb(100, 0, 100, 0));
                quizDesc.setBackgroundColor(Color.argb(100, 0, 100, 0));
            }


            return convertView;
        }

}
