package sortingalgorithms;

/*Used to test sorting algorithms*/
public class TestSort {

    public static void main(String[] args) {
                
        int[] sampleData = ArrayGenerator.getRand(100, -500, 500);        
        
        for(int i : sampleData)
            System.out.println(i);
        //time how long sorting takes
        final long startTime = System.nanoTime();
        MergeSort.sort_bu(sampleData);
        final long endTime = System.nanoTime();
        
        System.out.println("---");
        System.out.println("---");
        for(int i : sampleData)
            System.out.println(i);
        System.out.println("Sorting execution time: " + (endTime - startTime));
        if(ArrayGenerator.isSorted(sampleData))
            System.out.println("SORTED");
        else
            System.out.println("NOT SORTED");
    }
    
}