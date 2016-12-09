package sortingalgorithms;

public class BubbleSort {
    
    /*do bublesort*/
    public static void bs(int[] arr) {
        int n0 = arr.length;
        do {
            int n1 = 0;
            for(int i = 1; i < n0; i++) {//note i must start at 1
                if(arr[i-1] > arr[i]) {
                    swap(arr, i, i-1);
                    n1 = i;
                }
            }
            n0 = n1;//remeber where last swap was done
        } while (n0 != 0);
    }
    
    /*swap values of elements in array*/
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
}
