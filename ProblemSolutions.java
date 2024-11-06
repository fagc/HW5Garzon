/******************************************************************
 *
 *   FRANCISCO GARZON / COMP 400C
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        Set<Integer> setA = new HashSet<>();

        // adding all the numbers from list1 to setA
        for (int num : list1){
            setA.add(num);

        }
        // check each number in list2
        for (int num : list2){
            // if the number isnt in setA, then list2 isnt a subset
            if(!setA.contains(num)){
                return false;
            }
        }

        // if we didnt find any missing one, list2 is a subset
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // loop through each num in the array
        for (int num : array){

            // then we add the nunmber to the heap
            minHeap.add(num);

            // if the heap has more than k, remove the smallest
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        // the top of the heap is the largest k number
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // new array to hold both of them
        int[] bothArrays = new int[array1.length + array2.length];

        //copy elements from the first array to both
        System.arraycopy(array1,0,bothArrays,0,array1.length);

        //copy elements from the second one to both
        System.arraycopy(array2,0,bothArrays, array1.length, array2.length);

        // sort them combined
        Arrays.sort(bothArrays);

        // return the sorted array
        return bothArrays;
    }

}