package com.fankf.lee;

import java.util.HashMap;
import java.util.Map;

/**
 * fankunfeng
 * 2020-11-01 21:44
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode5 {
    /**
     * 思路： 从长往短取最长子串
     * 1.获取字符串长度 m
     * 2.下标0开始，判断0+m-1坐标和0是否相等
     * 3.如果相等判断0向右取，m-1向左取，判断是否相等，如果相等继续向内判断，
     * 直到0x向右取的坐标 >= 向左取为止，如果都相等为最长子串
     * 4.如果不等，抛弃，下次执行，直到坐标加长度等于 m-1为止
     * 5. m--
     */
    public String longestPalindrome(String s) {
        int m = s.length(); // 字符串长度
        if (m == 1) {
            return s;
        }
        int i = 0; //起始值
        int k = m - 1; //当前最大的长度
        while (m != 1) {
            while (i + k < m) {
                if (isMax(s, i, i + k)) {
                    return s.substring(i, i + k + 1);
                } else {
                    i++;
                }
            }
            k--;
            i = 0;
        }
        return null;
    }

    private boolean isMax(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeeCode5 leeCode5 = new LeeCode5();
        String s = leeCode5.longestPalindrome("a");
        System.out.println(s);
    }
}
