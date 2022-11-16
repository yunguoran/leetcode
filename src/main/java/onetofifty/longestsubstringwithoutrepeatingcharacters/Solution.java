package onetofifty.longestsubstringwithoutrepeatingcharacters;

/**
 * @author Yunguoran
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">longest-substring-without-repeating-characters</a>
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 字符上一次出现的位置，ASCII 共定义了 128 个字符。
        int[] last = new int[128];
        int n = s.length();
        int result = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            System.out.printf("这是第 %s 次循环，index 的值为 %s。%n", i, index);
            start = Math.max(start, last[index]);
            result = Math.max(result, i - start + 1);
            last[index] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
