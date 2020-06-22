import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortAlgorithm {
    public static Integer[] insertSort(Integer[] array){
        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static List<Integer> insertSort(List<Integer> array){
        for(int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;
            while(j >= 0 && array.get(j) > key){
                array.set(j+1,array.get(j));
                j = j - 1;
            }
            array.set(j + 1, key);
        }
        return array;
    }

    public static List<Integer> quicksort(List<Integer> arr, int begin, int end) {
        if(arr.size() < 2){
            return arr;
        }
        if(begin < end){
            int partitionIndex = partition(arr, begin, end);
            quicksort(arr, begin, partitionIndex-1);
            quicksort(arr, partitionIndex+1, end);
        }

        return arr;
    }

    private static int partition(List<Integer> arr, int begin, int end){
        int pivot = arr.get(end);
        int i = begin - 1;

        for(int j = begin; j < end; j++){
            if(arr.get(j) <= pivot){
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i+1, end);

        return i+1;
    }

    public static Integer[] quicksort(Integer[] arr, Integer begin, Integer end) {
        if(arr.length < 2){
            return arr;
        }
        if(begin < end){
            int partitionIndex = partition(arr, begin, end);
            quicksort(arr, begin, partitionIndex-1);
            quicksort(arr, partitionIndex+1, end);
        }

        return arr;
    }

    private static Integer partition(Integer[] arr, Integer begin, Integer end){
        int pivot = arr[end];
        int i = begin - 1;

        for(int j = begin; j < end; j++){
            if(arr[j] <= pivot){
                i++;

                int tempSwap = arr[i];
                arr[i] = arr[j];
                arr[j] = tempSwap;
            }

        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
