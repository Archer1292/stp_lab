import java.util.Scanner;



public class Array {
    public Array(){
        System.out.print("Количество элементов массива:");
        Scanner sc = new Scanner(System.in);
        int count=-1;
        try{
            count =sc.nextInt() ;
        }
        catch (Exception e) {System.out.println("Ошибка ввода");}

        if(count>0)
            System.out.println("Введите элементы массива A");
        array = new int[count];
        for(int i=0;i < array.length;i++){
            System.out.print("a["+i+"] = ");
            sc = new Scanner(System.in);
            try{
                array[i]=sc.nextInt();
            }
            catch (Exception e) {System.out.println("Ошибка ввода");i--;}
        }

    }
    private int[] array;
    public int[] getMaxMin() {
        int min = array[0], max = array[0];
        try{
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        return new int[]{max,min};}
        catch (NullPointerException e){
            System.out.print(e.toString());
            return null;
        }
    }

    private double geometricMean(double a, double b) {
        return Math.sqrt((double) Math.abs(a * b));
    }

    public int sum() {
        int sum = 0;
        try {
            for (int x : array) {
                sum += x;
            }
            return sum;
        }
        catch (NullPointerException e){
                System.out.print(e.toString());
                return -1;
            }
    }

    public int countPosiеive() {
        int pCount = 0;//positive / ntgative
        try{
        for (int x : array) {
            if (x > 0) pCount++;
        }
        return pCount;
        }
        catch (NullPointerException e){
                System.out.print(e.toString());
                return -1;
            }

    }

    public int sumOfNegative() {
        int negSum = 0;// ntgative
        try{
        for (int x : array) {
            if (x < 0) negSum += x;
        }
        return negSum;
        }
        catch (NullPointerException e){
            System.out.print(e.toString());
            return -1;
            }

    }

    public int sumElementsIndexIsMultiple3() {
        int Sum = 0;//positive / ntgative
        try{

        for (int i = 3; i < array.length; i += 3) {
            Sum += array[i];
        }
            return Sum;
        }
        catch (NullPointerException e){
            System.out.print(e.toString());
            return -1;
        }


    }

    public int productLargestSmallestElements() {
        int[] maxmin=getMaxMin();
        return maxmin[0]*maxmin[1];
    }
    public double geomMeanLargestSmallestElements() {
        int[] maxmin=getMaxMin();
        return geometricMean(maxmin[0],maxmin[1]);
    }


}
