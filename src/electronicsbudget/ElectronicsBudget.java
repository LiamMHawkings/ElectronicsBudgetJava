package electronicsbudget;

import java.util.Arrays;
import java.util.Random;

public class ElectronicsBudget {

    /**
     * The following program calculates the most expensive combination for a
     * keyboard and driver given a specified budget.
     */
    public static void main(String[] args) {
        int budget = 50;
        System.out.println("Available Budget: $" + budget);

        //Instantiate new main object.
        ElectronicsBudget ec = new ElectronicsBudget();

        ec.spendBudget(budget);
    }

    /**
     * Simple integer random number generate function with return variable.
     *
     * @param range
     * @return
     */
    public int generateNumber(int range) {
        Random number = new Random();
        int n = number.nextInt(range);
        return n;
    }

    /**
     * Method calls random number generator to build an array of 'n' elements,
     * with randomised values.
     *
     * @return keyboards
     */
    public int[] stockKeyboards() {
        int nKeyboards = generateNumber(5);
        int[] keyboards = new int[nKeyboards];

        if (keyboards.length == 0) {
            System.out.println("No Keyboards In Stock");
            return keyboards;
        }

        for (int i = 0; i < nKeyboards; i++) {
            keyboards[i] = generateNumber(40);
            if (keyboards[i] == 0) {
                i--;
            }
        }

        keyboards = sortArray(keyboards);

        System.out.println("Keyboard Stock " + Arrays.toString(keyboards));
        return keyboards;
    }

    /**
     * Method calls random number generator to build an array of 'n' elements,
     * with randomised values.
     *
     * @return drivers
     */
    public int[] stockDrivers() {
        int nDrivers = generateNumber(5);
        int[] drivers = new int[nDrivers];

        if (drivers.length == 0) {
            System.out.println("No Drivers In Stock");
            return drivers;
        }

        for (int i = 0; i < nDrivers; i++) {
            drivers[i] = generateNumber(40);
            if (drivers[i] == 0) {
                i--;
            }
        }

        drivers = sortArray(drivers);

        System.out.println("Drivers Stock " + Arrays.toString(drivers));
        return drivers;
    }

    /**
     * Procedural array sorting method via comparing each element in the array
     * with the proceeding elements at each index.
     *
     * @param array
     * @return array
     */
    public int[] sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    /**
     * Method used to calculate the most expensive combination within the given
     * budget by comparing each element of both arrays with each other. This
     * result is then printed to the console.
     *
     * @param b
     */
    public void spendBudget(int b) {
        int currSum = 0;
        int maxSum = currSum;

        int[] k = stockKeyboards();
        int[] d = stockDrivers();

        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < d.length; j++) {
                currSum = k[i] + d[j];
                if (currSum <= b) {
                    if (currSum > maxSum) {
                        maxSum = currSum;
                    }
                } else {
                    currSum = 0;
                }
            }
        }

        if (maxSum > 0 && maxSum <= b) {
            System.out.println("Most expensive combination: $" + maxSum);
        } else {
            System.out.println("No available combination.");
        }
    }
}
