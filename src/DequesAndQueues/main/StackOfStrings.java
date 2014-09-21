/**
 * Created by mch on 9/14/14.
 */
public class StackOfStrings {
    private stackString current = null;



    public void push(String s){
        stackString stackStringObject = new stackString();
        stackStringObject.s = s;
        stackStringObject.next = current;
        current = stackStringObject;
    }

    public String pop() {
        String currentString = current.s;
        current = current.next;
        return currentString;
    }

    public boolean isEmpty() {
        return current == null;
    }


    private class stackString {
        String s;
        stackString next;
    }

}
