package sortingalgorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] test = ArrayGenerator.getRand();
                System.out.println("Unsorted array:");
        for(int i : test) {
            System.out.println(i);
        }
        bs(test);
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
            n0 = n1;
        } while (n0 != 0);
    }
    
    /*swap values of elements in array*/
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
}
