package sortingalgorithms;

import java.util.Arrays;
import java.util.NoSuchElementException;


public final class Heapsort {
    
    public static void main(String[] args) {
        int[] sample = {10,5,6,4};
        Heapsort heap = new Heapsort(sample);
    }
    
    public Heapsort(final int[] arr) {
        heap = new int[arr.length + FRONT];//extra element at front simplifies calculations (http://stackoverflow.com/questions/22900388/why-in-a-heap-implemented-by-array-the-index-0-is-left-unused)
        /*copy array to "heap"*/
        for(int i = FRONT; i < heap.length; i++) {
            heap[i] = arr[i-FRONT];
        }
        
        end = heap.length - 1;//not sure if this is right
        heapSize = arr.length - 1;//maybe should be -1 here
        buildMaxHeap();
        
        for(int i = heapSize; i >= FRONT; i--) {         
            removeMax();
            heapifyDown(FRONT);
        }
        
        for(int i = FRONT; i < heap.length; i++)
            System.out.print(heap[i]+",");
        
    }
    
    /*build a binary tree putting values into arbitrary nodes
    that will latter be ordered into a heap*/
    private void buildMaxHeap() {
        for(int i = heapSize / 2; i >= FRONT; i--) {
            heapifyDown(i);//aka maxHeapify
        }
    }
    /*
    private void maxHeapify(int i) {
        
    }*/
    
    public void insert(final int key) {//in heaps, the value being stored is called the "key"
        if(end == heapSize) {//TODO: since heapSize is no longer final, this method may need to change
            throw new NoSuchElementException("heap is full");
        }
        
        heap[++end] = key;
        heapifyUp(end); 
        

    }
    
    /*INPUT i: index of child*/
    private int getParentIndx(final int i) {
        return (i / 2);
    }
    
    /*INPUT i: index of parent*/
    private int getLeftChildIndex(final int i) {
        return (i * 2);
    }
    
    /*INPUT i: index of parent*/
    private int getRightChildIndex(final int i) {
        return (i * 2 + 1);
    }
    
    /*return true if node at position is leaf*/
    private boolean isLeaf(int position) {
        return ((2 * position) > end);
    }
    
    /*swap two elements in heap*/
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    /*consider maknig this a public method,
    so that the user can insert a bunch of keys
    and only have to heapify once*/
    private void heapifyUp(int position) {//this function could be written in a recursive way
        int childIndx = position;
        int newKey = heap[childIndx];
        
        while(childIndx > FRONT && newKey > heap[getParentIndx(childIndx)]) {
            heap[childIndx] = heap[getParentIndx(childIndx)];
            childIndx = getParentIndx(childIndx);
        }
        
        heap[childIndx] = newKey;
    }
    
    /*display contents of heap, including unused first element*/
    public void dump() {
        for(int i = 0; i <= end; i++) {
            System.out.println("index: " +i+ " key: "+heap[i]);
         }
    }
    
    public void pprint() {
        for (int i = FRONT; i <= (int)Math.floor(end / 2); i++) {
            System.out.print("Parent: " + heap[i] + " Left child: " + heap[2 * i]);
            if(2 * i + 1 <= end) {//must check as parent may have no right child
                    System.out.print(" Right child: " + heap[2 * i  + 1]);
            }
            System.out.println();
        }
        assert isHeap() : "not a heap";
    }
    
    /*returns number of nodes*/
    public int getSize() {
        return end;
    }
    
    /*returns true iff array has heap property*/
    /*consider making this a static method so any array can be tested*/
    public boolean isHeap() {
        for(int i = FRONT; i <= end / 2; i++) {            
            if (2 * i + 1 <= end && heap[i] < heap[2 * i + 1] || heap[i] < heap[2 * i]) {
                return false;
            }
        }
        
        return true;
			
    }

    /*removes largest element and puts at end of array and decreases heap size*/
    public void removeMax() {
        
        final int MAX = heap[FRONT];
        heap[FRONT] = heap[end--];
        heapifyDown(FRONT);
        heap[end + 1] = MAX;
        
        //return MAX;
    }
    
    
    /*compares node at position with its children and
    swaps it with the largest child if its larger than it*/
    private void heapifyDown(int position) {
        /*pesudeocode:
            while(position has leaf) {
                choose largest leaf
                if bigger than swap
                else break
            }
        */
        //TODO: since start in middle knowing there are leafs, maybe can skip step for checking if node has leaf
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
    
    /*return the heap as array*/
    public int[] getHeapArray() {
        return heap;
    }
    
    
    private final int[] heap;//array where keys(values) are stored
    private int end;//pointer to last used element
    private int heapSize;//space used by heap
    private final int FRONT = 1;//first key is inserted at index 1, not 0
}
