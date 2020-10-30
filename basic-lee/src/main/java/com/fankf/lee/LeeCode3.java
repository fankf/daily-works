package com.fankf.lee;

/**
 * fankunfeng
 * 2020-10-30 09:09
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LeeCode3 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, now = 0, end = 1;
        int maxStart = 0, maxEnd = 1, length = 0;
        while (end < s.length()) {
            while (now < end) {
                if (s.charAt(now) == s.charAt(end)) {
                    if (end - start > length) {
                        maxStart = start;
                        maxEnd = end;
                        length = end - start;
                    }
                    now++;
                    start = now;
                }else {
                    now++;
                }
            }
            end++;
        }
        System.out.println(maxStart);
        System.out.println(maxEnd);
        System.out.println(length);
        return 0;
    }

    public static void main(String[] args) {
        LeeCode3 leeCode3 = new LeeCode3();
        leeCode3.lengthOfLongestSubstring("aasds2131fasfas");
    }
}
