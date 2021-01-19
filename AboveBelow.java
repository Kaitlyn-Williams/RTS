/**
 * Author: Kaitlyn Williams 
 * Date: 01/19/2021
 * #1 Print the number of integers in an array that are above the given input and the number that
 *    are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
 */
public class AboveBelow {
    public static void main(String[] args) {
        int[] numArray = {1, 5, 2, 1, 10};
        int num = 6;
        int above = 0;
        int below = 0;

        for(int i=0; i<numArray.length; i++) {
            if(numArray[i] < num)
                below++;
            else if(numArray[i] > num)
                above++;
        }

        System.out.println("above: " + above + ", below: " + below);
    }
}