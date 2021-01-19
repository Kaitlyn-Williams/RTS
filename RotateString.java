/**
 * Author: Kaitlyn Williams 
 * Date: 01/18/2021
 * #2 Rotate the characters in a string by a given input and have the overflow
 *    appear at the beginning, e.g. “MyString” rotated by 2 is “ngMyStri”.
 */
public class RotateString{
    public static void main(String[] args){
        String str = args[0];
        StringBuilder result = new StringBuilder();
        int strLen = str.length();
        int rotate = Integer.parseInt(args[1]);

        //get 'rotate' amount of characters from end of string to set as beginning
        result.append(str.substring(strLen-rotate, strLen));
        //get rest of string and append
        result.append(str.substring(0, (strLen-rotate)));

        System.out.println(result.toString());
    }
}