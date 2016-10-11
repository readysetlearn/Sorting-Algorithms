package sortingalgorithms;

import java.util.Arrays;


public class Introsort {
    
    public static int[] testMe(int[] arr) {
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        Quicksort.quicksort(arr, 0, arr2.length - 1);
        Heapsort.heapsort(arr2);
        return arr2;
    }
    
    /*
    INPUT arr: array to be sorted
    */
    public static void sort(int[] arr) {
        MAX_DEPTH =  (int)Math.floor(Math.log(arr.length) / Math.log(2));
        //sort(int[] arr, 0, arr.length);
    }
    
    /*
    INPUT arr: array to be sorted
    INPUT low: index of first element to sort (inclusive)
    INPUT high: index of last element to sort (inclusive)
    */    
    public static void sort(int[] arr, int low, int high) {
        
    }
    
    private static int MAX_DEPTH;
}
