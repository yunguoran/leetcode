package onetofifty.twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yunguoran
 * @see: <a href="https://leetcode.cn/problems/two-sum/">two-sum</a>
 * 使用 Map 的 key 存储 target 与数组元素的差值，value 存储数组元素的 index，以达到降低时间复杂度的目的。
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{11, 15, 7, 2}, 9)));
    }
}

