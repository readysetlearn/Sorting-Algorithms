
package sortingalgorithms;

/*Used to test sorting algorithms*/
public class TestSort {

    public static void main(String[] args) {
        
        int[] test1 = {-2598,
-2008,
9724};
        if(ArrayGenerator.isSorted(test1))
            System.out.println("sorted");
        else
            System.out.println("unsorted");
        
        //int[] sampleData = ArrayGenerator.getRand(20, -10000, 10000);        
        //int[] sampleData = {72, -45, 15, 2, -46, 94, -34, -63, 5, -16};
        int[] sampleData = {
                        9724,
                        -2598,
                        -2008,
                        -5135,
                        -144,
                        9505,
                        4445,
                        7262,
                        8065,
                        8268,
                        8132,
                        1136,
                        -9623,
                        4205,
                        2111,
                        -7989,
                        -4033,
                        1443,
                        9372,
                        -4195
        };
        for(int i : sampleData)
            System.out.println(i);
        System.out.println("---");
        MergeSort.sort(sampleData);
        System.out.println("---");
        for(int i : sampleData)
            System.out.println(i);
        if(ArrayGenerator.isSorted(sampleData))
            System.out.println("SORTED");
        else
            System.out.println("NOT SORTED");
    }
    
}
