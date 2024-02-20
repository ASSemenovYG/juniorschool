package ru.liga.dcs.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int foundIndex = 0;
        int[] numSort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numSort);
        List<Integer> listNums = Arrays.stream(nums).boxed().toList();
        while (i < numSort.length) {
            if (i == 0) {
                foundIndex = Arrays.binarySearch(numSort, 1, numSort.length, target - numSort[i]);
            } else {
                foundIndex = Arrays.binarySearch(numSort, 0, i, target - numSort[i]);
            }
            if (foundIndex >= 0) {
                break;
            }
            if (i > 0) {
                foundIndex = Arrays.binarySearch(numSort, i, numSort.length, target - numSort[i]);
                if (foundIndex >= 0) {
                    break;
                }
            }
            i++;
        }

        int[] result = {listNums.indexOf(numSort[i]), listNums.lastIndexOf(numSort[foundIndex])};
        Arrays.sort(result);
        return result;
    }
}
