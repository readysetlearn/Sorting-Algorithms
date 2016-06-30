package sortingalgorithms;


public class Quicksort {


    public static void main(String[] args) {
        int[] test = ArrayGenerator.getRand(150, -1000, 1000);
        System.out.println("Unsorted array:");
        for(int i : test) {
            System.out.println(i);
        }
        quicksort(test, 0, test.length-1);
        System.out.println("Sorted array:");
        for(int i : test) {
            System.out.println(i);
        }
        
        if(ArrayGenerator.isSorted(test)) {
            System.out.println("Sorting worked correctly.");
        } else {
            System.out.println("Sorting went wrong.");
        }
    }
    
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
        int pivot = median(arr, low, high);
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
    
    /*sorts first, last and middle element and returns median*/
    private static int median(int[] arr, int low, int high) {
        
        //System.out.println("low: "+low+" high: "+high);
        /*regular median fails if subarray is length less than 3*/
        if(low == high) {
            return arr[low];
        } else if(high - low == 1) {
            if(arr[low] > arr[high]) {
              swap(arr, low, high);
            }
            return arr[low];
        }
            
        if(high - low < 2) {//this should no longer happen
            System.out.println("problem! low: "+low+" high: "+high);
        }
        
        int middle = (low + high) / 2;
        if(arr[middle] < arr[low])
            swap(arr, low, middle);
        if(arr[high] < arr[low])
            swap(arr, low, high );
        if(arr[high] < arr[middle])
            swap(arr, middle, high);


        swap(arr, middle, high - 1);//know middle will end up on right partition

        //return the middle value
        return arr[high - 1];
    }
    
    /*swam values in array*/
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;        
    }
    
}
