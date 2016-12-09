package sortingalgorithms;

public class InsertionSort {
    
    public static void doSort(int[] arr) {
        doSort(arr, 0, arr.length);
    }
    
    /*sort arr from elements [low, high]*/
    public static void doSort(int[] arr, int low, int high) {
        for(int i = low+1; i < high; i++) {
            int value = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > value) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = value;
        }
            
    }
    
}
