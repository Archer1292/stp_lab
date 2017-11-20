public class ShellSorter implements Sorter {

    /**
     * The number of external loop.
     * От ее значения зависит размер шага предварительных проходов.
     * Для первой итерации внешнего цикла шаг будет максимальным,
     * с каждой итерацией он будет уменьшаться до 1 - масив отсортируется как при сортировке вставкой.
     */
    private int iterationNumber=0;
    /**
     *Метод сортирует массив по алгоритму Шелла, размер шага для грубых
     * предварительных прогонов определяется последовательностью Хиббрда
     */
       public int[] sort(int[] arr) {
        for (int step = getStep(arr.length, iterationNumber); step > 0;
             step = getStep(arr.length, ++iterationNumber)) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i-step; j >= 0; j -= step) {
                    int smallerElementValue = arr[j];
                    if (temp < arr[j]) {
                        arr[j+step] = arr[j];
                    }else break;
                }
                arr[j+step] = temp;
            }

        }
        return arr;
    }

    /**
     * The method calculates the size of the step to traverse an array.
     * Calculates according to the Hibbard sequence     *
     * @param lenght          is lenght of array.
     * @param iterationNumber is number of external iteration.
     * @return int.     *
     * @see
     */
    protected int getStep(int lenght, int iterationNumber) {
        if (lenght < 0 && iterationNumber < 0) return 0;
        int i = (int) (Math.log(lenght + 1) / (double) Math.log(2));
        return (int) Math.pow(2, i - iterationNumber);
    }

}

