package coen390.nicholas.sss;

import java.util.Hashtable;

public class hash {
    Hashtable<Integer, String> alphabets = new Hashtable<Integer, String>();

    //--------------------------------------------Function that sets the alphabet----------------------------------------------
    public void setAlphabets() {
        //this where we assign the key and the value<KEY,Value>
        alphabets.put(1, "A");
        alphabets.put(2, "B");
        alphabets.put(3, "C");
        alphabets.put(4, "D");
        alphabets.put(5, "E");
        alphabets.put(6, "F");
        alphabets.put(7, "G");
        alphabets.put(8, "H");
        alphabets.put(9, "I");
        alphabets.put(10, "J");
        alphabets.put(11, "K");
        alphabets.put(12, "L");
        alphabets.put(13, "M");
        alphabets.put(14, "N");
        alphabets.put(15, "O");
        alphabets.put(16, "P");
        alphabets.put(17, "Q");
        alphabets.put(18, "R");
        alphabets.put(19, "S");
        alphabets.put(20, "T");
        alphabets.put(21, "U");
        alphabets.put(22, "V");
        alphabets.put(23, "W");
        alphabets.put(24, "X");
        alphabets.put(25, "Y");
        alphabets.put(26, "Z");
    }


    public Hashtable<Integer, String> getAlphabets(int key)
    {
        alphabets.get(key);//this where we get the key andget the value that is assigned to the key

        return alphabets;
    }
}
