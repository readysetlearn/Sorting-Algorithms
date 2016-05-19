
package sortingalgorithms;


public class MergeSort {
    
    public void merge(int[] arr, int low, int mid, int high) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert ArrayGenerator.isSorted(arr, low, mid);
        assert ArrayGenerator.isSorted(arr, mid+1, high);

        /*copy contents of array*/
        for(int k = low; k <= high; k++) {
            auxiliary[k] = arr[k];
        }

        int i = low, j = mid + 1;//i points to left part of left half, j points to left point of right half        
        for(int k = low; k < high; k++) {
            if(i > mid) {
                arr[k] = auxiliary[j++];//i pointer is exhausted
            } else if(j > high) {
                arr[k] = auxiliary[i++];//j pointer is exhausted
            } else if(auxiliary[j] < auxiliary[i]) {
                arr[k] = auxiliary[j++];
            } else {
                arr[k] = auxiliary[i++];
            }
        }
        
        
        // postcondition: a[lo .. hi] is sorted
        assert ArrayGenerator.isSorted(arr, low, high);
    }
    
    private static int[] auxiliary;    
}
