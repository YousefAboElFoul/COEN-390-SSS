import java.util.Hashtable;

public class Hash {
    Hashtable<Integer, String> alphabets = new Hashtable<Integer, String>();
    public void setAlphabets() {


        alphabets.put(1, "A");
        alphabets.put(2, "B");
        alphabets.put(3, "C");
        //this where we assign the key and the value<KEY,Value>
        //put(key,value)
        }


    public Hashtable<Integer, String> getAlphabets (int key) {
        alphabets.get(key);//this where we get the key andget the value that is assigned to the key

        return alphabets;
    }
