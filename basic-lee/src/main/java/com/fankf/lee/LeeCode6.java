package com.fankf.lee;

/**
 * fankunfeng
 * 2020-11-02 22:49
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode6 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() < 2){
            return s;
        }
        /**
         *   有什么特点呢，假如做成一个矩阵的话，宽度是可以确定的，长度可以求出来，
         *   每个点的坐标也都可以求出来生成一个二维数组，然后每行处理
         *   int x = s.length();
         *   if(x/(rowNum-1)%2 == 0 )  i轴坐标等于 x/(rowNum-1)
         *   if(x/(rowNum-1)%2 == 1 )  i轴坐标等于 x/(rowNum-1) + x%(rowNum-1）
         *
         *   完成之后每行拼接成最终值
         *   --------------------------------------------------------------
         *   但是看完别的答案觉得自己的办法太笨了，看了别人的思路这里再次编写下
         */

        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }
        for (int i = 0; i < s.length(); i++) {
            int division = i / (numRows-1);
            int remainder = i % (numRows-1);
            if(division % 2 == 0){
                sbs[remainder].append(s.charAt(i));
            }
            if(division % 2 != 0){
                sbs[numRows-1-remainder].append(s.charAt(i));
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sbs.length; i++) {
            result.append(sbs[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeeCode6 leeCode6 = new LeeCode6();
        System.out.println(leeCode6.convert("0123456789",3));
    }
}
