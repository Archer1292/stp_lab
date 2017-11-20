/**
 * @author Bratus Nadja on 09/14/2017
 * @project lab2
 */
import java.util.Scanner;


public class ArraySolver {
    public static void main(String[] args) {
        ArraySolver arr=new ArraySolver();
        System.out.println("Sum of negative elements: "+arr.sumOfNegative());
        System.out.println("Product of largest and smalest elements: "+arr.productLargestSmallestElements());
        System.out.println("Count of positive elements: "+arr.countPositive());
        System.out.println("Geometric mean of largest and smalest elements: "+arr.getGeometricMean());
        System.out.println("Sum of elements with indices that are divided by 3: "+arr.sumElementsIndexIsMultiple3());
    }
    public ArraySolver() {
        Scanner sc = new Scanner(System.in);
        int count = -1;
        do {
            if (sc.hasNextInt())
                System.out.print("Number of elements in the array:");
                count = getInputNumber();
        } while (count < 0);

        System.out.println("Enter the elements of array A");

        array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.print("a[" + i + "] = ");
            array[i] = getInputNumber();
        }
    }
    public  ArraySolver(int[]arr){
        array=arr;
    }


    private int[] array;

    public static int getInputNumber() {
        int num;
        Scanner input=new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("\nSorry, that's not a number.");
            input.next();
        }
        num = input.nextInt();
        return num;
    }

    public int[] getMaxMin() {
        try {
            int min = array[0], max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) min = array[i];
                if (array[i] > max) max = array[i];
            }
            return new int[]{max, min};
        } catch (NullPointerException e) {
            System.out.print(e.toString());
            return null;
        }
    }

    public double getGeometricMean() {
        int[] minMax = getMaxMin();
        try {
            return Math.sqrt((double) Math.abs(minMax[0] * minMax[1]));
        } catch (Exception e) {
            return 0;
        }
    }

    public int sum() {
        int sum = 0;
        try {
            for (int x : array) {
                sum += x;
            }
            return sum;
        } catch (NullPointerException e) {
            System.out.print(e.toString());
            return -1;
        }
    }

    public int countPositive() {
        int pCount = 0;//positive
        try {
            for (int x : array) {
                if (x > 0) pCount++;
            }
            return pCount;
        } catch (NullPointerException e) {
            System.out.print(e.toString());
            return -1;
        }
    }

    public int sumOfNegative() {
        int negSum = 0;// ntgative
        try {
            for (int x : array) {
                if (x < 0) negSum += x;
            }
            return negSum;
        } catch (NullPointerException e) {
            System.out.print(e.toString());
            return -1;
        }
    }

    public int sumElementsIndexIsMultiple3() {
        int Sum = 0;//positive / ntgative
        try {
            for (int i = 3; i < array.length; i += 3) {
                Sum += array[i];
            }
            return Sum;
        } catch (NullPointerException e) {
            System.out.print(e.toString());
            return -1;
        }
    }

    public int productLargestSmallestElements() {
        int[] maxmin = getMaxMin();
        try {
            return maxmin[0] * maxmin[1];
        } catch (Exception e) {
            System.out.print(e.toString());
            return 0;
        }
    }
}

