import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Kaitlyn Williams 
 * Date: 01/19/2021
 * #1 Print the number of integers in an array that are above the given input and the number that
 *    are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
 */
public class AboveBelow {
    private ArrayList<Double> numArray;
    private Double num;
    private int above;
    private int below;

    /**
     * Displays the count of how many numbers were higher and how many were lower in value than the comparison number (num)
     */
    public static void main(String[] args) {
        //get user input and set values
        ArrayList<Double> input = getInput();
        AboveBelow ab = new AboveBelow(input.subList(1, input.size()), input.get(0));

        //compare numbers and track how many are higher and/or lower than num
        ab.compareAndIncrement();

        System.out.println("above: " + ab.getAbove() + ", below: " + ab.getBelow());
    }

    /**
     * Parameterized constructor
     * @param numArray the numbers to be compared
     * @param num the number to compare to
     */
    public AboveBelow(List<Double> numArray, Double num) {
        this.numArray = new ArrayList<Double>();
        this.numArray.addAll(numArray);
        this.num = num;
        above = 0;
        below = 0;
    }

    /**
     * @return the number of values that have been compared with and are higher in value than num
     */
    public int getAbove() {
        return above;
    }

    /**
     * @return the number of values that have been compared with and are lower in value than num
     */
    public int getBelow() {
        return below;
    }

    /**
     * Compares num with the values in numArray.
     * Increments above variable if the value in numArray is higher than the value of num.
     * Increments below variable if the value in numArray is lower than the value of num.
     */
    public void compareAndIncrement() {
        for(int i=0; i < numArray.size(); i++) {
            if(numArray.get(i) < num)
                below++;
            else if(numArray.get(i) > num)
                above++;
        }
    }

    /**
     * Prompts the user to enter the comparison number and the numbers to be compared
     * @return user input (comparison number and the numbers to be compared)
     */
    public static ArrayList<Double> getInput() {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> input = new ArrayList<Double>();
        boolean isNumber = true;

        do {
            System.out.print("Please enter the number you would like to use as a comparison: ");
            try{
                input.add(Double.parseDouble(in.nextLine()));
                isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
                System.out.print("Invalid number. ");
            }
        } while (!isNumber);

        do {
            System.out.print("Please enter a number to be included in your array [type 'end' to finish]: ");
            String str = in.nextLine(); 
            try{
                input.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {
                //expected if string is "end"
                isNumber = false;
            }
        } while (isNumber);

        in.close();

        return input;
    }
}