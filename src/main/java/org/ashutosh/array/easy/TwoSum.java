package org.ashutosh.array.easy;

/*
LC Link: https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumBruteForce(nums, 9)));

        int[] nums2 = {3,2,4};
        System.out.println(Arrays.toString(twoSumOptimized(nums2, 6)));

    }

    public static int[] twoSumOptimized(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();
        int k;
        for(int i=0; i<nums.length; i++){
            k = target - nums[i];
            if(valIndexMap.containsKey(k))
                result = new int[] {valIndexMap.get(k), i};
            valIndexMap.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }
}