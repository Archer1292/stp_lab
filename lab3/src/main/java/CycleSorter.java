import java.util.Comparator;
/**
 * @author Bratus Nadja on 10/20/2017
 * @project mtp-03
 */
public class CycleSorter {

    public class CycleSorter  Sortable {
       void processSorting(int[] arr) {
            int length = arr.length;

            for (int cycleStart = 0; cycleStart < length - 1; cycleStart++)
            {
                int item = arr[cycleStart];

                int currentPosition = cycleStart;
                for (int j = cycleStart + 1; j < length; j++) {
                    if (compare(arr[j], item, comparator) < 0) {
                        currentPosition++;
                    }
                }

                if (currentPosition == cycleStart) {
                    continue;
                }

                while (compare(item, arr[currentPosition], comparator) == 0) {
                    currentPosition += 1;
                }

                if (currentPosition != cycleStart) {
                    T temp = item;
                    item = arr[currentPosition];
                    arr[currentPosition] = temp;
                }

                while (currentPosition != cycleStart)
                {
                    currentPosition = cycleStart;

                    for (int j = cycleStart + 1; j < length; j++) {

                        if (compare(arr[j], item, comparator) < 0) {
                            currentPosition += 1;
                        }
                    }

                    while (compare(item, arr[currentPosition], comparator) == 0) {
                        currentPosition += 1;
                    }

                    if (compare(item, arr[currentPosition], comparator) != 0) {
                        T temp = item;
                        item = arr[currentPosition];
                        arr[currentPosition] = temp;
                    }
                }
            }
        }

    }
