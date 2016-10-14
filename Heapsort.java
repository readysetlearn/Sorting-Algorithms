package sortingalgorithms;

import java.util.Arrays;
import java.util.NoSuchElementException;


public final class Heapsort {
    
    public static void heapsort(final int[] data) {
        heapsort(data, 0, data.length - 1);
    }
    
    /*
    INPUT data: array of data to be sorted
    INPUT fromIndx: index of first element to be sorted
    INPUT toIndx: index of last element to be sorted
    OUTPUT data: the array is now in sorted order
    */
    public static void heapsort(final int[] data, final int fromIndx, final int toIndx) {
        // adding extra element with +FRONT makes calculations simpler, +1 at end is because arrays start at 0 (and here it's setting size)
        heap = new int[toIndx - fromIndx + FRONT + 1];
        /*copy array to "heap" (binary tree)*/
        for(int i = fromIndx + FRONT; i < heap.length; i++) {
            heap[i] = data[i - FRONT];
        }
        
        end = heap.length - 1;
        heapSize = toIndx - fromIndx + 1;//+1 b/c arrays start at 0 and here we are concerned with size
        buildMaxHeap();
        
        for(int i = heapSize; i >= FRONT; i--) {         
            removeMax();
            siftDown(FRONT);
        }
        
        for(int i = FRONT; i < heap.length; i++) {//copy sorted array back to original
            data[i - FRONT] = heap[i];
        }
        
    }
    
    /*build a binary tree putting values into arbitrary nodes
    that will latter be ordered into a heap*/
    private static void buildMaxHeap() {
        for(int i = heapSize / 2; i >= FRONT; i--) {
            siftDown(i);//aka heapifyDown, bubbleDown
        }
    }
    
        /*compares node at position with its children and
    swaps it with the largest child if its larger than it*/
    private static void siftDown(int position) {
        /*pesudeocode:
            while(position has leaf) {
                choose largest leaf
                if bigger than swap
                else break
            }
        */
        //TODO: since start in middle knowing there are leafs, maybe can skip step for checking if node has leaf
        //refer to second pseudocode portion of https://en.wikipedia.org/wiki/Heapsort#Pseudocode
        while(!isLeaf(position)) {
            //get largest of children
            int largestChildIndex;
            if(getRightChildIndex(position) <= end) {//check if node has a right child
                if(heap[getLeftChildIndex(position)] > heap[getRightChildIndex(position)]) {
                    largestChildIndex = getLeftChildIndex(position);
                } else {
                    largestChildIndex = getRightChildIndex(position);
                }
            } else {//no right child
                largestChildIndex = getLeftChildIndex(position);
            }
            //check if child is larger than parent
            if(heap[position] < heap[largestChildIndex]) {
                //if it is, then swap
                swap(position, largestChildIndex);
                position = largestChildIndex;
            } else {
                //if it's not, heap property is satisfied
                break;
            }
        }
    }
    
    public static void insert(final int key) {//in heaps, the value being stored is called the "key"    
        heap[++end] = key;
        heapifyUp(end); 
    }
    
    /*consider maknig this a public static method,
    so that the user can insert a bunch of keys
    and only have to heapify once*/
    private static void heapifyUp(int position) {//this function could be written in a recursive way
        int childIndx = position;
        int newKey = heap[childIndx];
        
        while(childIndx > FRONT && newKey > heap[getParentIndx(childIndx)]) {
            heap[childIndx] = heap[getParentIndx(childIndx)];
            childIndx = getParentIndx(childIndx);
        }
        
        heap[childIndx] = newKey;
    }
    
    /*INPUT i: index of child*/
    private static int getParentIndx(final int i) {
        return (i / 2);
    }
    
    /*INPUT i: index of parent*/
    private static int getLeftChildIndex(final int i) {
        return (i * 2);
    }
    
    /*INPUT i: index of parent*/
    private static int getRightChildIndex(final int i) {
        return (i * 2 + 1);
    }
    
    /*return true if node at position is leaf*/
    private static boolean isLeaf(int position) {
        return ((2 * position) > end);
    }
    
    /*swap two elements in heap*/
    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    /*display contents of heap, including unused first element*/
    public static void dump() {
        for(int i = 0; i <= end; i++) {
            System.out.println("index: " +i+ " key: "+heap[i]);
         }
    }
    
    public static void pprint() {
        for (int i = FRONT; i <= end / 2; i++) {//can start at end/2 as any lower would have no children
            System.out.print("Parent: " + heap[i] + " Left child: " + heap[2 * i]);
            if(2 * i + 1 <= end) {//must check as parent may have no right child
                    System.out.print(" Right child: " + heap[2 * i  + 1]);
            }
            System.out.println();
        }
        assert isHeap() : "not a heap";
    }
    
    /*returns number of nodes*/
    public static int getSize() {
        return end;
    }
    
    /*returns true iff array has heap property*/
    /*consider making this a static method so any array can be tested*/
    public static boolean isHeap() {
        for(int i = FRONT; i <= end / 2; i++) {            
            if (2 * i + 1 <= end && heap[i] < heap[2 * i + 1] || heap[i] < heap[2 * i]) {
                return false;
            }
        }
        
        return true;
			
    }

    /*removes largest element and puts at end of array and decreases heap size*/
    public static void removeMax() {
        
        final int MAX = heap[FRONT];
        heap[FRONT] = heap[end--];
        siftDown(FRONT);
        heap[end + 1] = MAX;
        
        //return MAX;
    }
    
    /*return the heap as array*/
    public static int[] getHeapArray() {
        return heap;
    }
    
    
    private static int[] heap;//array where keys(values) are stored
    private static int end;//pointer to last used element
    private static int heapSize;//space used by heap
    private static final int FRONT = 1;//first key is inserted at index 1, not 0
}
