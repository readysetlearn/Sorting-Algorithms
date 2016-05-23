
package sortingalgorithms;


public class MergeSort {
    
    public static void merge(int[] arr, int low, int mid, int high) {
        // precondition: a[low .. mid] and a[mid+1 .. high] are sorted subarrays
        assert ArrayGenerator.isSorted(arr, low, mid);
        assert ArrayGenerator.isSorted(arr, mid+1, high);

        /*copy contents of array*/
        for(int k = low; k <= high; k++) {
            auxiliary[k] = arr[k];
        }

        int i = low, j = mid + 1;//i points to left part of left half, j points to left point of right half        
        for(int k = low; k <= high; k++) {
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
        
        
        // postcondition: a[low .. high] is sorted
        assert ArrayGenerator.isSorted(arr, low, high);
    }

    /*Top-down implementation of mergesort*/
    public static void sort_td(int[] a) {
            auxiliary = new int[a.length];
            sort_td(a, 0, a.length-1);
    }
    
    /*Top-down implementation of mergesort*/
    private static void sort_td(int[] a, int lo, int hi) {
	if (hi <= lo) {
            return;
	}
        int mid = lo + (hi - lo) / 2;
	sort_td(a, lo, mid);//recursive call
	sort_td(a, mid+1, hi);//recursive call
	merge(a, lo, mid, hi);
    }
    
    /*Bottom-up implementation of merge sort*/
    public static void sort_bu(int[] arr) {
        final int N = arr.length;
        auxiliary = new int[N];
        /*sz is size of subarray, N is size of full array*/
        for(int sz = 1; sz < N; sz = 2*sz) {//executes log(N) times
            for(int low = 0; low < N - sz; low += 2*sz) {
                merge(arr, low, (low + sz - 1), Math.min(low + 2*sz - 1, N - 1));//same merge() is used in bottom-up and top-down
            }
        }
    }


    
    private static int[] auxiliary;    
}
