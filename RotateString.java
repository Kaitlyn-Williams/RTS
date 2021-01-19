import java.util.Scanner;

/**
 * Author: Kaitlyn Williams 
 * Date: 01/19/2021
 * #2 Rotate the characters in a string by a given input and have the overflow
 *    appear at the beginning, e.g. “MyString” rotated by 2 is “ngMyStri”.
 */
public class RotateString {
    private String message;
    private int rotation;

    /**
     * If commandline arguments entered are not sufficient, the user is prompted for input to define the message and rotation amount.
     * @param args first element should be the string and second element should be the distance each character is rotated
     */
    public static void main(String[] args) {
        //get user input
        String[] input = getInput(args);

        //set values
        RotateString msg = new RotateString(input[0], Integer.parseInt(input[1]));

        //display rotated message
        System.out.println(msg.rotate());
    }

    /**
     * Parameterized constructor
     * @param message the message to be rotated
     * @param rotation the number of spaces to rotate each character in the message
     */
    public RotateString(String message, int rotation) {
        this.message = message;
        this.rotation = rotation;
    }

    /**
     * Rotates a message by the given number. Positive numbers rotate right, negative numbers rotate left.
     * @return the rotated message
     */
    public String rotate(){
        StringBuilder result = new StringBuilder();
        int strLen = message.length();

        if(rotation > -1){
            //get 'rotation' amount of characters from end of string to set as beginning
            result.append(message.substring(strLen-rotation, strLen));
            //get rest of string and append
            result.append(message.substring(0, (strLen-rotation)));
        } else {
            //convert negative number to positive
            rotation = Math.abs(rotation);
            //get all of string except beginning 'rotation' characters and set as beginning
            result.append(message.substring(rotation, strLen));
            //get 'rotation' amount of characters from beginning of string and set as end            
            result.append(message.substring(0, rotation));
        }
        
        return result.toString();
    }

    /**
     * Prompts the user to enter input if there were insufficient commandline arguments
     * @param args commandline arguments
     * @return user input (the message at index 0 and the rotation number at index 1)
     */
    public static String[] getInput(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = new String[2];

        if (args.length == 2) {
            System.out.println("Using the first two arguments entered.");
                input[0] = args[0];
                input[1] = args[1];
        } else { //incorrectly formatted command - can't trust data entered at commandline
            System.out.print("Please enter a string to rotate: ");
            input[0] = in.nextLine();
            System.out.print("Please enter the rotation amount: ");
            input[1] = in.nextLine();
        }

        in.close();

        return input;
    }
}