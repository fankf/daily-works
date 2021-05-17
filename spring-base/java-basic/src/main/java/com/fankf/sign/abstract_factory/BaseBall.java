package com.fankf.sign.abstract_factory;

/**
 * @AUTHOR thinkpad
 * @DATETIME 2020-07-14 19:20
 * @PACKAGE com.fankf.sign.abstract_factory
 */
public class BaseBall implements BallInterface {
    @Override
    public void makeBall() {
        System.out.println("制作一个棒球...");
    }
}
