package sortingalgorithms;


public class Quicksort {


    public static void main(String[] args) {
        int[] test = ArrayGenerator.getRand(1000, -1000, 1000);
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
            final int THRESH_HOLD = 10;//number at which insertion sort is used instead of quicksort
            if(high - low <= THRESH_HOLD) {
                InsertionSort.doSort(arr);//use insertion sort on small arrays
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
        int i = low - 1;
        int j = high + 1;
        for(;;) {//intentional infinte loop
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
        int middle = (low + high) / 2;
        if(arr[middle] < arr[low])
            swap(arr, low, middle);
        if(arr[high] < arr[low])
            swap(arr, low, high );
        if(arr[high] < arr[middle])
            swap(arr, middle, high);

        return arr[middle];
    }
    
    /*swam values in array*/
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;        
    }
    
}
