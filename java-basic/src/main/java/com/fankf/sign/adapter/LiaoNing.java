package com.fankf.sign.adapter;

import org.springframework.util.StringUtils;

/**
 * **************************************
 *
 * @author fankunfeng
 * @datetime 2020-07-21 18:10
 * @package com.fankf.sign.adapter
 * ***************************************
 */
public class LiaoNing extends ChineseExt{

    @Override
    public void country() {
        System.out.println("我是中国人~~~ ext 并来自辽宁");
    }

    public static void main(String[] args) {
        System.out.println(Double.valueOf(-1).compareTo(0.0));
        System.out.println(test("0"));
    }


    public  static int test(String t) {
        if (!t.equals( "0") &&
                !t.equals( "2") &&
                !t.equals( "1")
        )
            return  1;
        return 2;
    }
}
