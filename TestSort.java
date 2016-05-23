package sortingalgorithms;

/*Used to test sorting algorithms*/
public class TestSort {

    public static void main(String[] args) {
                
        int[] sampleData = ArrayGenerator.getRand(25, -10, 10);        
        
        for(int i : sampleData)
            System.out.println(i);
        System.out.println("---");
        MergeSort.sort_bu(sampleData);
        System.out.println("---");
        for(int i : sampleData)
            System.out.println(i);
        if(ArrayGenerator.isSorted(sampleData))
            System.out.println("SORTED");
        else
            System.out.println("NOT SORTED");
    }
    
}