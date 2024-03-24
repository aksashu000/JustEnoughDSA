package org.ashutosh.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given two integer arrays arr1 and arr2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: arr1 = [1,2,2,1], arr2 = [2,2]
Output: [2]

Example 2:
Input: arr1 = [4,9,5], arr2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));

        int[] arr3 = {1,2,2,1};
        int[] arr4 = {2,2};
        System.out.println(Arrays.toString(intersection(arr3, arr4)));
    }

    //Time Complexity: O(m+n) => m = length of first array, n = length of second array
    public static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();
        for (int j : arr1) {
            set.add(j);
        }
        for (int j : arr2) {
            if (set.contains(j)) {
                intersectionSet.add(j);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (Integer num : intersectionSet) {
            result[i++] = num;
        }
        return result;
    }

    //Time Complexity: O(n * logn)
    public static int[] findIntersectionWithSortingAndBinarySearch(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr2);
        for (Integer num : arr1) {
            if (binarySearch(arr2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    //This is a helper method for Binary Search
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
