package coen390.nicholas.sss;

public class quizTracking
{
    //-------------------------------------Variables to set the lvl list---------------------------------------------
    private String lvl;
    private String lvlDescription;

    //-------------------------------------tracking variables for quizzes---------------------------------------------
    public int nmbCorrectQ1;
    int questionCompletition[] = new int[26];

    //---------------------------------------------Quiz Questions-------------------------------------------------
    String questions[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    //----------------------------------------------------Constructor--------------------------------------------------------
    public quizTracking(String level, String description)
    {
        lvl = level; lvlDescription = description;
    }

    //--------------------------------------------------------Getters-------------------------------------------------------4
    //get the level
    public String getLevel(){return lvl;}

    //get the description
    public String getDescription() { return lvlDescription;}
}
