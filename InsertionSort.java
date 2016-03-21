package sortingalgorithms;

public class InsertionSort {

    public static void main(String[] args) {
        int[] sampleData = {0,5,15,5,-39,1};
        System.out.println("Unsorted array:");
        for(int i : sampleData)
            System.out.println("\t"+i);
        doSort(sampleData);
        System.out.println("Sorted array:");
        for(int i : sampleData)
            System.out.println("\t"+i);
        
    }
    
    public static void doSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
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
