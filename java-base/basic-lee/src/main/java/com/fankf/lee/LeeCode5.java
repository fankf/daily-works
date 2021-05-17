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
        if (m == 1 || m == 0) {
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
        String s = leeCode5.longestPalindrome("a111dsda");
        System.out.println(s);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
