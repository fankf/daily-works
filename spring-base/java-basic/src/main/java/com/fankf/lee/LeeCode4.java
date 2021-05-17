package com.fankf.lee;

import java.util.ArrayList;
import java.util.List;

/**
 * fankunfeng
 * 2020-10-30 09:10
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class LeeCode4 {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 首先处理情况
        if (m == 0) {
            // 奇数
            if (n % 2 == 1) {
                return nums2[(n + 1) / 2];
            }
            // 偶数 取中间两数的平均值
            else {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            }
        }
        if (n == 0) {
            // 奇数
            if (m % 2 == 1) {
                return nums1[(m + 1) / 2];
            }
            // 偶数 取中间两数的平均值
            else {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            }
        }
        // 正常情况
        int s1 = 0, s2 = 0;
        List<Integer> list = new ArrayList<>();
        while (list.size() != (m + n)) {
            if (nums1[s1] <= nums2[s2]) {
                list.add(nums1[s1]);
                if (s1 != m-1) {
                    s1++;
                }else {
                    for (int i = s2; i < n; i++) {
                        list.add(nums2[i]);
                    }
                }
            } else {
                list.add(nums2[s2]);
                if (s2 != n-1) {
                    s2++;
                }else {
                    for (int i = s1; i < m; i++) {
                        list.add(nums1[i]);
                    }
                }
            }
        }
        // 取数
        if ((m + n) % 2 == 1) {
            return list.get((m + n - 1) / 2);
        }
        // 偶数 取中间两数的平均值
        else {
            return (list.get((m + n) / 2) + list.get((m + n) / 2 - 1)) / 2.0;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (cal(nums1, 0, nums2, 0, left) + cal(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double cal(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i == nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j == nums2.length) return nums1[i + k - 1];//nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return cal(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return cal(nums1, i, nums2, j + k / 2, k - k / 2);
        }

    }

    public static void main(String[] args) {
        LeeCode4 lee4 = new LeeCode4();
        int[] nums2 = {1};
        int[] nums1 = {2};
        double arrays = lee4.findMedianSortedArrays(nums1, nums2);
        System.out.println(arrays);
    }
}
