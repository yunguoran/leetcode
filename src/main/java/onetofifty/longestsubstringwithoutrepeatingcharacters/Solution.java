package onetofifty.longestsubstringwithoutrepeatingcharacters;

/**
 * @author Yunguoran
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">longest-substring-without-repeating-characters</a>
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 字符上一次出现的位置（1-based），ASCII 共定义了 128 个字符。
        int[] last = new int[128];
        int n = s.length();
        int result = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            // charAt 方法返回值为 char 类型，使用 int 类型接收，index 的值为字符所对应的 ASCII 字符编码表中的数值。
            int index = s.charAt(i);
            // 若遇到之前出现过的字符，窗口的起始位置就要滑动至出现字符上次出现位置的下一个位置。
            start = Math.max(start, last[index]);
            result = Math.max(result, i - start + 1);
            // 记录字符上一次出现的位置（1-based）。
            last[index] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
