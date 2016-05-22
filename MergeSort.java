
package sortingalgorithms;


public class MergeSort {
    
    private static void merge(int[] arr, int low, int mid, int high) {
        // precondition: a[low .. mid] and a[mid+1 .. high] are sorted subarrays
        assert ArrayGenerator.isSorted(arr, low, mid);
        assert ArrayGenerator.isSorted(arr, mid+1, high);

        /*copy contents of array*/
        for (int k = low; k <= high; k++) {
            auxiliary[k] = arr[k]; 
        }


        int i = low, j = mid + 1;//i points to left part of left half, j points to left point of right half        
        for (int k = low; k <= high; k++) {
            if      (i > mid)              arr[k] = auxiliary[j++];//i pointer is exhausted
            else if (j > high)               arr[k] = auxiliary[i++];
            else if ((auxiliary[j] < auxiliary[i])) arr[k] = auxiliary[j++];//j pointer is exhausted
            else                           arr[k] = auxiliary[i++];
        }

        // postcondition: a[low .. high] is sorted
        assert ArrayGenerator.isSorted(arr, low, high);
 }

    /*Top-down implementation of mergesort*/
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] arr) {
        auxiliary = new int[arr.length];
        sort(arr, 0, arr.length-1);
        assert isSorted(arr);
    }
    
    /*Top-down implementation of mergesort*/
    // mergesort a[low..high] using auxiliary array aux[lo..hi]
    private static void sort(int[] arr, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if ((a[i] < a[i-1])) return false;
        return true;
    }

    
    private static int[] auxiliary;    
}
