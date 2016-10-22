package sortingalgorithms;

/*main file to test ArrayGenerator class*/

public class TestArrGen {

    public static void main(String[] args) {
        int[] sample1 = ArrayGenerator.getRand(5, 0, 20);
        int[] sample2 = ArrayGenerator.getRand();
        int[] sample3 = ArrayGenerator.getSorted(5, 0, 10);
        int[] sample4 = ArrayGenerator.getReverseSorted(15, -100, 100);
        int[] sample5 = ArrayGenerator.getPartialSorted(1, 4, 1, 10);
        int[] sample6 = ArrayGenerator.getPartialSorted(2, 5, 1, 10);
        
        
        System.out.println("Random length 5, vals [0, 1]");
        for(int i : sample1) {
            System.out.println(i);
        }
        
        System.out.println("Random length 10, vals [-10, 10]");
        for(int i : sample2) {
            System.out.println(i);
        }
        
        System.out.println("Sorted length 5 vals [0, 10]");
        for(int i : sample3) {
            System.out.println(i);
        }
        
        System.out.println("Reverse sorted length 15, vals [-100, 100]");
        for(int i : sample4) {
            System.out.println(i);
        }
        
        System.out.println("Partial sorted length 4, vals [1, 10], inversion 1");
        for(int i : sample5) {
            System.out.println(i);
        }
        
        System.out.println("Partial sorted length 5, vals [1, 10], inversion 2");
        for(int i : sample6) {
            System.out.println(i);
        }
        
    }
    
}
