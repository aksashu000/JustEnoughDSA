package org.ashutosh.algorithms.search;

public class BinarySearch {

    //Driver program
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40 };
        int target = 10;

        int index = binarySearch(arr, target);

        if(index == -1){
            System.out.println("Element " + target + " is not present in array");
        } else{
            System.out.println("Element " + target +  " is present at index " + index);
        }


        target = 5;
        index = binarySearchRecursive(arr, 0, arr.length, target);

        if(index == -1){
            System.out.println("Element " + target + " is not present in array");
        } else{
            System.out.println("Element " + target +  " is not present");
        }
    }

    //Iterative Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //Recursive Binary Search implementation
    public static int binarySearchRecursive(int[] arr, int start, int end, int target)
    {
        if (end >= start) {
            int mid = (start + end) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target)
                return binarySearchRecursive(arr, start, mid - 1, target);

            return binarySearchRecursive(arr, mid + 1, end, target);
        }

        // If the number is not present, return -1
        return -1;
    }
}
