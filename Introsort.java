//currently this code is just a copy of Quicksort
package sortingalgorithms;


public class Introsort {
    
    /*main body of Quicksort*/
    public static void quicksort(int[] arr, int low, int high) {
        if(low < high) {
            final int THRESH_HOLD = 5;//when to switch from quicksort to insertion sort
            if(high - low <= THRESH_HOLD) {
                InsertionSort.doSort(arr);//using insertionsort on small arrays is more efficent
            }
            int pivot = partition(arr, low, high);
            /*recursivley sort two subarrays*/
            quicksort(arr, low, pivot);
            quicksort(arr, pivot + 1, high);
        }
    }
    
    /*Hoare's partition scheme*/
    private static int partition(int[] arr, int low, int high) {
        int pivot = medianOf3(arr, low, high);
        if(high - low <= 3)//median already sorts 3 so no need to continue
            return high - 1;//not having this here may result in index out of range
        
        /*after first iterration of do while, i = low and j = high hence the -1/+1 */
        int i = low - 1 + 1;//+1 b/c first element is on correct side of pivot
        int j = high + 1 - 1 - 1;//-2 b/c last 2 elements are on correct side of pivot
        for(;;) {//infinte loop
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if(i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }
    
    /*sorts the first, last and middle elements of subarray [start, end]
    * places median value at position end - 1
    * returns median value
    */
     private static int medianOf3(int[] data, int start, int end) {
        if(end - start == 0) {
            return data[start];
        }else if(end - start == 1) {
            if(data[start] > data[end]) {
                swap(data, start, end);
            }
            return data[end];//return higher value for arrays of length 2
        }
	
        int middle = start + ((end-start)/2);
        
        if (data[start] > data[end])
           swap(data, start, end);

        if (data[start] > data[middle])
           swap(data, start, middle);

        if (data[middle] > data[end])
           swap(data, middle, end);
        
        swap(data, middle, end - 1);//know middle will end up on right partition
        
        return data[end - 1];//return the middle value
        
    }
    
    /*swam values in array*/
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;        
    }
    
}
