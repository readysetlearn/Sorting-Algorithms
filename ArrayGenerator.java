package sortingalgorithms;

import java.util.Random;
import java.util.Arrays;

public class ArrayGenerator {

    /*returns array of  length length with values in [min, max]*/
    public static int[] getRand(int length, int min, int max) {
        int[] out = new int[length];
        for(int i = 0; i < length; i++) {
            out[i] = min + RAND.nextInt((max - min) + 1);
        }
        return out;
    }
    
    public static int[] getRand() {
        return getRand(10, -10, 10);
    }

    /*returns array in ascending order*/
    public static int[] getSorted(int length, int min, int max) {
        int [] out = getRand(length, min, max);
        Arrays.sort(out);//use the sort that comes with Java
        return out;
    }
    
    public static int[] getSorted() {
        return getSorted(10, -10, 10); 
    }
    
    /*returns array in reverse sorted order*/
    public static int[] getReverseSorted(int length, int min, int max) {
        int[] out = getSorted(length, min, max);
        reverse(out);
        return out;
    }
    
    public static int[] getReverseSorted() {
        return getSorted(10, -10, 10);
    }
    
    /*reverses array in place*/
    private static void reverse(int[] arr) {
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            //swap values
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
    
    /*check if entire array is sorted in ascending order*/
    public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /*check if array is sorted in ascending order between indexes [min, max]*/
    public static boolean isSorted(int[] arr, int min, int max) {
        for(int i = min; i < max - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /*create an array, sort it, then add n number of inversions*/
    /*need to change method so that it only counts final # of inversions
    the way it works now doesn't make sense
    */
    public static int[] getPartialSorted(int n, int length, int min, int max) {
        if(length < 2) {//array of less than 2 elements can't have inversion
            throw new IllegalArgumentException("length must be greater or equal to 2");
        }
        int[] out = getSorted(length, min, max);
        for(int i = 0; i < n; i++) {
            int x, y;
            x = RAND.nextInt(length);
            y = RAND.nextInt(length);
            while(x == y) {//prevent case of swapping element with itself
                y = RAND.nextInt(length);
            }
            int temp = out[x];
            out[x] = out[y];
            out[y] = temp;
        }
        
        if(isSorted(out)) {//if output turned out sorted, repeat call to this functionArr
            return getPartialSorted(n, length, min, max);
        }
        
        return out;
    }
            
    private final static Random RAND = new Random();
}
